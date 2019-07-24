##############################################################################
#Author: Will Maxcy

#Date Created: 9/20/2017

#Date Modified: 11/29/2017

#Function: Majority of functions
##############################################################################
import os, os.path, shutil
import sys
import nltk
import re
from nltk import word_tokenize
from nltk.tokenize import RegexpTokenizer
from nltk import bigrams
from nltk import trigrams
from nltk import ngrams
from nltk.collocations import *
from nltk.corpus import stopwords
import Date
import numpy as np
import matplotlib.pyplot as plt
import string

global cBigrams
global cTrigrams
cBigrams = list()
cTrigrams = list()

global lBigrams
global lTrigrams
lBigrams = list()
lTrigrams = list()

global compareBigrams
global compareTrigrams
compareBigrams = list()
compareTrigrams = list()

global d
d = list()


# Main function used to grab blogs from Blog folder and begin to seperate
# and analyise the seperate parts
def go(setNum):

	# deletes the L.txt and C.txt files
	# does this so the same file does not contine to be appeneded
	resetAffOutput()
	delFolder()
	
	# finds raw text files from Blogs folder
	path, dirs, files = os.walk(sys.path[0]+'/Blogs/Set'+str(setNum)+'/Train').__next__()

	# loop that takes all files from from Blogs folder and runs them
	# through the seperate() function
	for file in files:
		
		#allData = seperate(file,setNum)

		seperate2(file)

	return ()

# First time running the program should use this method. Does a lot of nGram
# operations that take time and takes over an hour to run
def goBig():
	#major method
	go()
	# 
	#Test.combineGrams()
	#Test.makeGrahamCompare()
	#Test.getGramCompare()
	#don't run unless more blogs are added
	#takes over an hour to run
	

	return

# Major and most important method of Test class. Seperates title, date, and
# blog into seperate parts and runs operations on these parts. Writes data to
# the 'Output' file
def seperate(file,setNum):

	# whole text file with entire path
	textFile = sys.path[0] + '/Blogs/Set'+str(setNum)+'/Train/'+ str(file)

	# author name - finds from file name
	authName = getName(textFile)
	
	# political affiliation - found from predetermined file name
	polAff = getAff(file)
	
	# flag that keeps up what blog is being read
	print("Reading " + authName + " file:")

	
	# sorts all lines in file and saves them in a list
	with open(textFile, encoding = "utf-8", errors='replace') as l:
		lines = l.readlines()
	l.close()

	# goes through text file and and uses the lines
	with open(textFile, encoding = "utf-8", errors='replace') as f:

		# main loop that finds flags in text by enumerating the lines, then
		# extracts the text 
		for num, line in enumerate(f,0):
			
			# flag inside text indicating the beginning of a new blog
			if '+++++' in line:
				

				# extraction of  title and date
				title = lines[num+2].rstrip()
				fileTitle = ''.join(re.findall("[a-zA-Z ]*", title))
				date = lines[num+4]
				start = num + 5	
				
				# first heuristic finidng title positve or negative score
				titleAfinn = tafinn([title])
				
				#naming the output file
				outFile = str(polAff) + ' ' + str(authName) +  ' ' + str(fileTitle) + ".txt" 

				# print to let blog title known
				print("    blog: "+title)

			# mark the end of the blog with &&&&&
			if '&&&&&' in line:

				# saving blog data
				end = num
				blog = lines[start:end]
				data = [title, date, blog]

				# making blog into string
				blog = str(blog).rstrip().lower()
				blog = blog.replace('\\n','')
				blog = blog.replace('\\t','')
				blog = blog.replace('\\u','')

				# first heuristic finidng title positve or negative score
				titleAfinn = tafinn([title])

				# finding the lexical diversity of the blog text
				strBlog = ''.join(str(e) for e in blog)
				lexDiv = lexicalDiversity((strBlog).rstrip())
				
				#finding the sentiment score using the AFINN word list
				sentScore = afinn(blog)

				# creating a 0 - 1 sentiment score from sentScore so that it can be compared
				adjSentScore = adjustedSentScore(blog, sentScore)

				# finding the bigram score by inserting the raw bigram score
				bigramScore = str(rawBigramScore(blog) + 9)

				# adjusting bigram score to be between 0 and 1
				adjBigramScore = adjustedBigramScore(blog, bigramScore)

				# finding the trigram score
				tgramScore = rawTrigramScore(blog)

				# all the data combined into a string to be written to multiple files
				csvData = (titleAfinn + ','
					+ sentScore + ','
					+ str(int(float(adjSentScore)*100000)) + ','
					+ str(int(float(lexDiv)*100000)) + ','
					+ str(int(float(bigramScore)*100000)) + ','
					+ str(int(float(adjBigramScore)*100000)) + ','
					+ str(int(float(tgramScore))*100000))

				data = (titleAfinn + ','
					+ sentScore + ','
					+ adjSentScore + ','
					+ lexDiv + ','
					+ bigramScore + ','
					+ adjBigramScore + ','
					+ tgramScore + ','
					+ polAff + ','
					+ authName)
				
				# date function ***
				Date.date(date,data,outFile,polAff)

				# write file to text files
				write(outFile, data, csvData)

	# close file
	f.close()
	
	
	
	return()

def seperate2(file):

	# whole text file with entire path
	textFile = sys.path[0] + '/Blogs/AllBlogs/'+ str(file)

	# author name - finds from file name
	authName = getName(textFile)
	
	# political affiliation - found from predetermined file name
	polAff = getAff(file)
	
	# flag that keeps up what blog is being read
	print("Reading " + authName + " file:")

	
	# sorts all lines in file and saves them in a list
	with open(textFile, encoding = "utf-8", errors='replace') as l:
		lines = l.readlines()
	l.close()

	# goes through text file and and uses the lines
	with open(textFile, encoding = "utf-8", errors='replace') as f:

		# main loop that finds flags in text by enumerating the lines, then
		# extracts the text 
		for num, line in enumerate(f,0):
			
			# flag inside text indicating the beginning of a new blog
			if '+++++' in line:
				

				# extraction of  title and date
				title = lines[num+2].rstrip()
				fileTitle = ''.join(re.findall("[a-zA-Z ]*", title))
				date = lines[num+4]
				start = num + 5	
				
				# first heuristic finidng title positve or negative score
				titleAfinn = tafinn([title])
				
				#naming the output file
				outFile = str(polAff) + ' ' + str(authName) +  ' ' + str(fileTitle) + ".txt" 

				# print to let blog title known
				print("    blog: "+title)

			# mark the end of the blog with &&&&&
			if '&&&&&' in line:

				# saving blog data
				end = num
				blog = lines[start:end]
				data = [title, date, blog]

				

				# write file to text files
				write2(outFile, data)

	# close file
	f.close()

	return

# simple write function that writes collection of data to the 'Output' files.
# the first write is a single vector containgin all the data collected from
# the blogs. the second write is the same data, but written to a single file
# in which all conservative or liberals are written to
def write(outFile, data, csvData):

	outPath = sys.path[0] + '/Output/'
	
	# single file
	writeFile = str(os.path.join(outPath,  outFile))
	# multiple file csv
	writeFile2 = os.path.join(outPath,  getAff(outFile) + '.csv')
	# multiple file txt
	writeFile3 = os.path.join(outPath,  getAff(outFile) + '.txt')

	# single txt write
	f = open(writeFile, "w+")
	f.write(data)
	f.close()

	# multiple csv write
	f2 = open(writeFile2, "a")
	f2.write(csvData + '\n')
	f2.close()

	# multiple txt write
	f3 = open(writeFile3, "a")
	f3.write(data + '\n')
	f3.close()

	return()

def write2(outFile, data):

	outPath = sys.path[0] + '/Blogs/AllSeperated/'

	title = data[0]
	date = data[1]
	blog = ''.join(word for word in data[2])

	blog = str(blog).rstrip().lower()
	printable = set(string.printable)
	filter(lambda x: x in printable, blog)

	
	# single file
	writeFile = str(os.path.join(outPath,  outFile))
	
	# single txt write
	f = open(writeFile, "w+", encoding='utf-8')
	f.write('+++++\n\n' + str(title) + '\n\n' + str(date) + str(blog) + '\n\n&&&&&\n\n')
	f.close()


	return()

def makeSet():

	textFile = sys.path[0] + '/Blogs/AllSeperated'

	return()

##############################################################################
################################################ HELPER FUNCTIONS FOR SEPERATE


# simple operation to get political affiliation
def getAff(file):

	#label conservative or liberal based on first char of the txt file name
	aff=''
	if (ord(file[0]) == ord('c')) or (ord(file[0]) == ord('C')):
		aff = 'C'
	if (ord(file[0]) == ord('l')) or (ord(file[0]) == ord('L')):
		aff = 'L'
	if (ord(file[0]) == ord('m')) or (ord(file[0]) == ord('M')):
		aff = 'M'
	if (ord(file[0]) == ord('u')) or (ord(file[0]) == ord('U')):
		aff = 'U'
	
	return aff

# extracts name of author from file name
def getName(file):

	# naming convention allows for
	name = ''.join(re.compile('[a-z]*-[a-z]*')
		.findall(file)).replace("-", " ").title()

	return name

# finds lexical diversty by dividing unique words by the number of words
def lexicalDiversity(blog):
	
	sentences = word_tokenize(blog)
	lexDiv = str(len(set(sentences)) / len(sentences))
	
	return lexDiv

# AFINN sentiment analysis
def afinn(blog):

	# finds and scores the sentiment for blogs in the file based 
	# off of AFINN-111
	# compares words from blog to words in AFINN list. If there 
	# is a match, the number associated with the word is returned
	# and added into the score.
	sentiment_dictionary = {}
	c = str(blog).lower().split()
	for line in open(sys.path[0]+'/Data/AFINN-111.txt'):
		word, score = line.split('\t')
		sentiment_dictionary[word] = int(score)

	sentScore = str(sum(sentiment_dictionary.get(word, 0) for word in c))

	return(sentScore)

# AFINN sentiment analysis for the blog title
def tafinn(title):

	# finds and scores the sentiment for blog titles in the file based 
	# off of AFINN-111 word list
	# compares words from blog to words in AFINN list. If there 
	# is a match, the number associated with the word is returned
	# and added into the score.
	sentiment_dictionary = {}
	c = str(title).lower().split()
	for line in open(sys.path[0]+'/Data/AFINN-111.txt'):
		word, score = line.split('\t')
		sentiment_dictionary[word] = int(score)

	sentScore = str(sum(sentiment_dictionary.get(word, 0) for word in c))

	return sentScore

# finds the raw bigram score based on self made list
def rawBigramScore(blog):

	# making blog into easily managable list of lower case tokens
	blog = ''.join(blog)
	blog = blog.rstrip().lower()
	blog = blog.replace('\\n','')
	blog = blog.replace('\\t','')
	blog = blog.replace('\\u','')
	blog = blog.split()

	bigramDictionary = {}

	# creating of bigrams from blog string into a tuple of blog divided 
	# into bigrams
	biList = list(bigrams(blog))
	
	# iteration of bigramCompare.txt - a self created list of all bigrams
	# from every blog text. Finds value associated with bigram and returns it
	for line in open(sys.path[0]+'/nGrams/bigramCompare.txt'): # created
		words, score = line.split('\t')						   # seperately
		bigramDictionary[words] = float(score)
	
	# sums all values together from bigrams adn returns them
	biScore = sum(bigramDictionary.get((str(word[0] + ' ' + word[1])),0) for word in biList)

	return(biScore)

# finds the raw trigram score based on self made list
def rawTrigramScore(blog):

	# strips and makes blog easier to match bigrams. puts in as list of words
	blog = ''.join(blog)
	blog = blog.rstrip().lower()
	blog = blog.replace('\\n','')
	blog = blog.replace('\\t','')
	blog = blog.replace('\\u','')
	blog = blog.split()

	trigram_dictionary = {}

	# creates a list of ngrams with the value of 3, so list of trigrams
	triList = list(ngrams(blog,3))
	
	# runs trigrams through self made list, 
	for line in open(sys.path[0]+'/nGrams/trigramCompare.txt'):
		words, score = line.split('\t')
		trigram_dictionary[words] = float(score)
	
	triScore = str(sum(trigram_dictionary.get((str(word[0] + ' ' + word[1] + ' ' + word[2])),0) for word in triList))

	return(triScore)

# adjusted bigram score used to create consistant value 
# between -1 and 1
def adjustedBigramScore(blog, bigramScore):

	return(str(float(bigramScore)/len(list(bigrams(str(blog).split())))))

# adjusted trigram score used to create consistant value 
# between -1 and 1
def adjustedSentScore(blog, sentScore):

	return(str(float(sentScore)/len(str(blog).split())))


##############################################################################
######################################## BIGRAM AND TRIGRAM CREATION FUNCTIONS


# first program used to create bigram list. Adds list of bigrams into glbal
# list of list of bigrams.
def bgrams(text, pa):

	# turns text to string and makes it lowercase. removes tabs and new lines
	text = str(text).rstrip().lower()
	text = text.replace('\\n','')
	text = text.replace('\\t','')
	text = text.replace('\\u','')

	# creates tokenizer, then tokenizes string. From these tokens, finds
	# bigrams and sorts them in respect to numbe of appearances in the blog
	tokenizer = RegexpTokenizer(r'([A-za-z]{2,})')
	tokens = tokenizer.tokenize(text)
	tokens = [word for word in tokens if word not in stopwords.words('english')]
	finder = BigramCollocationFinder.from_words(tokens, window_size = 2)

	bigram = list(finder.ngram_fd.items())
	bigram.sort(key=lambda item: item[-1], reverse=True)

	# adds list of bigrams to list of list of bigrams that match political affiliation
	if (pa is 'C'):
		for b in bigram:
   			cBigrams.append(b)

	if (pa is 'L'):
   		for b in bigram:
   			lBigrams.append(b)

	if (pa is 'M'):
   		for b in bigram:
   			mBigrams.append(b)

	if (pa is 'U'):
   		print()
   		

	return

# first program used to create bigram list. Adds list of bigrams into glbal
# list of list of bigrams.
def trigrams(text, pa):

	# turns text to string and makes it lowercase. removes tabs and new lines
	text = str(text).rstrip().lower()
	text = text.replace('\\n','')
	text = text.replace('\\t','')
	text = text.replace('\\u','')
	
	# creates tokenizer, then tokenizes string. From these tokens, finds
	# trigrams  and sorts them in respect to numbe of appearances in the blog
	tokenizer = RegexpTokenizer(r'([A-za-z]{2,})')
	tokens = tokenizer.tokenize(text)
	tokens = [word for word in tokens if word not in stopwords.words('english')]
	finder = TrigramCollocationFinder.from_words(tokens, window_size = 3)

	trigram = list(finder.ngram_fd.items())
	trigram.sort(key=lambda item: item[-1], reverse=True)

	# adds list of trigrams to list of list of trigrams that match political affiliation
	if (pa is 'C'):
		for b in trigram:
   			cTrigrams.append(b)

	if (pa is 'L'):
   		for b in trigram:
   			lTrigrams.append(b)

	if (pa is 'M'):
   		for b in trigram:
   			mTrigrams.append(b)
	
	if (pa is 'U'):
		print()

	return 

# creates text file list of conservative and liberal bigrams and trigrams 
# and the number of times occured
def createGramsLists():

	# creats output files for the lists of conservative and liberal
	# bigrams and trigrams. These are the lists
	cTriFile = sys.path[0] + '/nGrams/cTrigrams.txt'
	lTriFile = sys.path[0] + '/nGrams/lTrigrams.txt'
	cBiFile = sys.path[0] + '/nGrams/cBigrams.txt'
	lBiFile = sys.path[0] + '/nGrams/lBigrams.txt'

	# reading lines in the conservative trigram file
	with open(cTriFile, encoding = "utf-8", errors='replace') as l:
		lines = l.readlines()

	# writes file in the way of "word1 word2 score"
	for x in lines:
		k = x.split()[:3]
		v = x.split()[3]
		cTrigrams.append((k,v))

	# reading lines in the liberal trigram file
	with open(lTriFile, encoding = "utf-8", errors='replace') as l:
		lines = l.readlines()

	# writes file in the way of "word1 word2 score"
	for x in lines:
		k = x.split()[:3]
		v = x.split()[3]
		lTrigrams.append((k,v))

	# reading lines in the conservative bigram file
	with open(cBiFile, encoding = "utf-8", errors='replace') as l:
		lines = l.readlines()

	# writes file in the way of "word1 word2 score"
	for x in lines:
		k = x.split()[:2]
		v = x.split()[2]
		cBigrams.append((k,v))

	# reading lines in the liberal bigram file
	with open(lBiFile, encoding = "utf-8", errors='replace') as l:
		lines = l.readlines()

	# writes file in the way of "word1 word2 score"
	for x in lines:
		k = x.split()[:2]
		v = x.split()[2]
		lBigrams.append((k,v))

	
	
	return()

# creating of the weighted bigram and trigram list that uses
def makeGrahamCompare():

	# output path for  creating of bigram and trigram comparison list
	outPathB = sys.path[0] + '/nGrams/bigramCompare.txt'
	outPathT = sys.path[0] + '/nGrams/trigramCompare.txt'

	# removes file every time this is started so that bigrams arent 
	# always appeneded to the file
	try:
		os.remove(outPathB)
	except OSError:
		pass

	# 
	f = open(outPathB, "a")
	for ck,cv in cBigrams:
		for lk, lv in lBigrams:
			if ck == lk:
			
				if float(cv) > float(lv):
					f.write(ck[0] + ' ' + ck[1] + '\t'
						+ str(float(cv)/float(lv)) + '\n')
				
				if float(lv) > float(cv):
					f.write(ck[0] + ' ' + ck[1] + '\t'
						+ str((float(lv)/float(cv)) * -1) + '\n')
	f.close()

	try:
		os.remove(outPathT)
	except OSError:
		pass

	f = open(outPathT, "a")
	for ck,cv in cTrigrams:
		for lk, lv in lTrigrams:
			if ck == lk:
				if float(cv) > float(lv):
					f.write(ck[0] + ' ' + ck[1] + ' ' 
						+ ck[2] + '\t' + str(float(cv)/float(lv)) + '\n')
				elif float(lv) > float(cv):

					f.write(ck[0] + ' ' + ck[1] + ' '
						+ ck[2] + '\t' + str((float(lv)/float(cv)) * -1) + '\n')
	f.close()
	return()

# create thie bigram lists as a global variable
def getGramCompare():

	bCompare = sys.path[0] + '/nGrams/bigramCompare.txt'
	tCompare = sys.path[0] + '/nGrams/trigramCompare.txt'

	with open(bCompare, encoding = "utf-8", errors='replace') as l:
		lines = l.readlines()

	for x in lines:
		k = x.split()[:2]
		v = x.split()[2]
		compareBigrams.append((k,v))

	with open(tCompare, encoding = "utf-8", errors='replace') as l:
		lines = l.readlines()

	for x in lines:
		k = x.split()[:3]
		v = x.split()[3]
		compareTrigrams.append((k,v))

	return()

# combines all the list of bigrams with their counts into one list
def combineGrams():

	def combineCt():

		textFile = sys.path[0] + '/nGrams/cTrigrams.txt'

		f = open(textFile, 'a')

		for x,(k,v) in enumerate(cTrigrams):
			for bx,(bk,bv) in enumerate(cTrigrams):
				if((k == bk)&(bx!=x)):
					v=v+bv
					cTrigrams.__setitem__(x,(k,v))
					cTrigrams.pop(bx)
			print(str(x) + " out of " + str(len(cTrigrams)) + " complete:")

		cTrigrams.sort(key=lambda item: item[-1], reverse=True)

		for x,((k1,k2,k3),v) in enumerate(cTrigrams):
			f.write(str(k1) + ' ' + str(k2) + ' ' + str(k3) + ' ' + str(v) + '\n')

		f.close()

		return()

	def combineLt():
		textFile = sys.path[0] + '/nGrams/lTrigrams.txt'

		f = open(textFile, 'a')

		for x,(k,v) in enumerate(lTrigrams):
			for bx,(bk,bv) in enumerate(lTrigrams):
				if((k == bk)&(bx!=x)):
					v=v+bv
					lTrigrams.__setitem__(x,(k,v))
					lTrigrams.pop(bx)
			print(str(x) + " out of " + str(len(lTrigrams)) + " complete:")

		lTrigrams.sort(key=lambda item: item[-1], reverse=True)

		for x,((k1,k2,k3),v) in enumerate(lTrigrams):
			f.write(str(k1) + ' ' + str(k2) + ' ' + str(k3) + ' ' + str(v) + '\n')
		f.close()
		

		return()

	def combineC():

		textFile = sys.path[0] + '/nGrams/cBigrams.txt'

		f = open(textFile, 'a')

		for x,(k,v) in enumerate(cBigrams):
			for bx,(bk,bv) in enumerate(cBigrams):
				if((k == bk)&(bx!=x)):
					v=v+bv
					cBigrams.__setitem__(x,(k,v))
					cBigrams.pop(bx)
			print(str(x) + " out of " + str(len(cBigrams)) + " complete:")

		cBigrams.sort(key=lambda item: item[-1], reverse=True)

		for x,(k,v) in enumerate(cBigrams):
			f.write(str(k[0]) + ' ' + str(k[1]) + ' ' + str(v) + '\n')
		f.close()

		return()

	def combineL():
		textFile = sys.path[0] + '/nGrams/lBigrams.txt'

		f = open(textFile, 'a')

		for x,(k,v) in enumerate(lBigrams):
			for bx,(bk,bv) in enumerate(lBigrams):
				if((k == bk)&(bx!=x)):
					v=v+bv
					lBigrams.__setitem__(x,(k,v))
					lBigrams.pop(bx)
			print(str(x) + " out of " + str(len(lBigrams)) + " complete:")

		lBigrams.sort(key=lambda item: item[-1], reverse=True)

		for x,(k,v) in enumerate(lBigrams):
			f.write(str(k[0]) + ' ' + str(k[1]) + ' ' + str(v) + '\n')
		f.close()

		return()

	combineC()
	combineL()
	combineCt()
	combineLt()

	return()



##############################################################################
############################################### TESTING CASE FOR UNKNOWN BLOGS

# gets all data from output file and returns list of lits of data
def getData(aff):

	
	titleAfinnList = []
	sentScoreList = []
	adjSentScoreList = []
	lexDivList = []
	bigramScoreList = []
	adjBigramScoreList = []
	tgramScoreList = []
	polAffList = []
	authNameList = []

	if aff == 'C' or aff == 'A':

		for line in open(sys.path[0]+'/Output/C.txt'):
			
			titleAfinn, sentScore, adjSentScore, lexDiv, bigramScore, adjBigramScore, tgramScore, polAff, authName = line.split(',')
			
			titleAfinnList.append(float(titleAfinn))
			sentScoreList.append(float(sentScore))
			adjSentScoreList.append(float(adjSentScore))
			lexDivList.append(float(lexDiv))
			bigramScoreList.append(float(bigramScore))
			adjBigramScoreList.append(float(adjBigramScore))
			tgramScoreList.append(float(tgramScore))
			polAffList.append(polAff)
			authNameList.append(authName)


	if aff == 'L' or aff == 'A':

		for line in open(sys.path[0]+'/Output/L.txt'):

			titleAfinn, sentScore, adjSentScore, lexDiv, bigramScore, adjBigramScore, tgramScore, polAff, authName = line.split(',')
			
			titleAfinnList.append(float(titleAfinn))
			sentScoreList.append(float(sentScore))
			adjSentScoreList.append(float(adjSentScore))
			lexDivList.append(float(lexDiv))
			bigramScoreList.append(float(bigramScore))
			adjBigramScoreList.append(float(adjBigramScore))
			tgramScoreList.append(float(tgramScore))
			polAffList.append(polAff)
			authNameList.append(authName)

	allLists = [titleAfinnList, sentScoreList, adjSentScoreList, lexDivList, bigramScoreList, adjBigramScoreList, tgramScoreList, polAffList, authNameList]
	
	return(allLists)

# graphs different heuristic characteristics
def graph(num, polAffGraph):

	graphTitle = ''

	if int(num) is 0:
		graphTitle = 'AFINN Title'
	elif int(num) is 1:
		graphTitle = 'AFINN Blog'
	elif int(num) is 2:
		graphTitle = 'Adjusted Sentiment Score'
	elif int(num) is 3:
		graphTitle = 'Lexical Diversity'
	elif int(num) is 4:
		graphTitle = 'Bigram Raw Score'
	elif int(num) is 5:
		graphTitle = 'Adjusted Bigram Score'
	elif int(num) is 6:
		graphTitle = 'Trigram Raw Score'
	else: graphTitle = 'error'

	data = getData(polAffGraph)

	zipped = list(zip(data[-2], data[num]))

	polList = zipped

	polList.sort(key=lambda item: item[-1], reverse=True)

	polAff = tuple(zip(*polList))[0]
	score = tuple(zip(*polList))[1]
	x_pos = np.arange(len(polList)) 

	slope, intercept = np.polyfit(x_pos, score, 1)
	trendline = intercept + (slope * x_pos)



	#plt.plot(x_pos, trendline, color='black', linestyle='--')    
	barlist = plt.bar(x_pos, score,align='center')
	
	for x,(k, y) in enumerate(polList):
		if k is 'C':
			barlist[x].set_color('red')
		if k is 'L':
			barlist[x].set_color('blue')
	
	plt.xticks(x_pos, '') 
	plt.ylabel(graphTitle)
	plt.show()

	return

# deletes files with all data on them so data does not constantly get appeneded
def resetAffOutput():
	
	try:
		os.remove(sys.path[0] + '/Output/C.txt')
	except OSError:
		pass
	try:
		os.remove(sys.path[0] + '/Output/M.txt')
	except OSError:
		pass
	try:
		os.remove(sys.path[0] + '/Output/L.txt')
	except OSError:
		pass
	try:
		os.remove(sys.path[0] + '/Output/C.csv')
	except OSError:
		pass
	try:
		os.remove(sys.path[0] + '/Output/L.csv')
	except OSError:
		pass

	return()

def delFolder():

	folder = sys.path[0] + '/Output'

	for the_file in os.listdir(folder):
		file_path = os.path.join(folder, the_file)
		try:
			if os.path.isfile(file_path):
				os.unlink(file_path)
			#elif os.path.isdir(file_path): shutil.rmtree(file_path)
		except Exception as e:
			print(e)
	return

# runner function for the test function. takes files and individually tests
def testGo(setNum):

	path, dirs, files = os.walk(sys.path[0]+'/Blogs/Set'+str(setNum)+'/Test').__next__()

	xList = list()

	# loop that takes all files from from Blogs folder and runs them
	# through the test() function
	for file in files:
		xList.append(test(file,setNum))
	
	# flattens the list from being a list of lists to one big list
	xList = [item for sublist in xList for item in sublist]
	
	if len(xList) > 1:
		xList.sort()
		conPercentage = float(xList.count(1)/(xList.count(2)+xList.count(1)))
		libPercentage = float(xList.count(-1)/(xList.count(-2)+xList.count(-1)))
		allPercentage = libPercentage + conPercentage
		print('\n\n\n')
		print('Conservative - 	 Correct: ' + str(xList.count(1)) +' | Incorrect: ' + str(xList.count(2)))
		print('		Percentage correct:   ' + "{0:.0f}%".format(float(xList.count(1)/(xList.count(2)+xList.count(1)))*100))
		print('Liberal ------	 Correct: ' + str(xList.count(-1)) +' | Incorrect: ' + str(xList.count(-2)))
		print('		Percentage correct:   ' + "{0:.0f}%".format(float(xList.count(-1)/(xList.count(-2)+xList.count(-1)))*100))
		print('Unknown/Moderate-       : '+ str(xList.count(0)))
		print('\n')

	return()

# test file that takes list of blogs in a test folder and extracts data from files
# this data is then used to compare against heuristics
def test(textFile,setNum):

	polAff = getAff(textFile)

	textFile = sys.path[0] + '/Blogs/Set'+str(setNum)+'/Test/'+ str(textFile)

	authName = getName(textFile)
	
	x = 0
	xList = list()
	

	print("Reading " + authName + " file:")


	with open(textFile, encoding = "utf-8", errors='replace') as l:
		lines = l.readlines()
	

	with open(textFile, encoding = "utf-8", errors='replace') as f:


		for num, line in enumerate(f,0):
			
			if '+++++' in line:
				

				title = lines[num+2].rstrip()
				fileTitle = ''.join(re.findall("[a-zA-Z ]*", title))
				date = lines[num+4]
				start = num + 5	
				
				titleAfinn = tafinn([title])
				
				outFile = str(polAff) + ' ' + str(authName) +  ' ' + str(fileTitle) + ".txt" 

				
				print("    Testing blog: "+title)
			if '&&&&&' in line:

				end = num
				blog = lines[start:end]
				data = [title, date, blog]
				

				strBlog = ''.join(str(e) for e in blog)
				lexDiv = lexicalDiversity((strBlog).rstrip())
				
				sentScore = afinn(blog)

				adjSentScore = adjustedSentScore(blog, sentScore)

				bigramScore = str(rawBigramScore(blog) + 9)

				adjBigramScore = adjustedBigramScore(blog, bigramScore)

				tgramScore = rawTrigramScore(blog)
			

				#all the data for every thing

				data = (titleAfinn + '\t'
					+ sentScore + '\t'
					+ adjSentScore + '\t'
					+ lexDiv + '\t'
					+ bigramScore + '\t'
					+ adjBigramScore + '\t'
					+ tgramScore + '\t'
					+ polAff + '\t'
					+ authName)
				

				conNum = 0
				libNum = 0


				# this one 1.52
				if float(bigramScore) > 1:
					
					conNum = conNum + 1.5


				# this one 1.63
				if float(bigramScore) < -1:
					
					libNum = libNum  + 1.5


				# this one  1.31
				if float(lexDiv) < .4:
					
					libNum = libNum  + 1

				#this one 1.46
				if float(lexDiv) > .432 and float(lexDiv) < .45:
					
					conNum = conNum + 1.46

				# this one 1.47
				if float(sentScore) > 40:
					
					libNum = libNum  + 1

				#not this one 1.86
				if float(sentScore) > 6 and float(sentScore) <= 11:
					
					conNum = conNum  + 2


				# this one 1.17
				if float(adjBigramScore) < -.015:
					
					libNum = libNum  + 1.5


				# this one 1.16
				if float(adjBigramScore) > .015:
					
					conNum = conNum + 1.5
				

				# this one 1.5
				if float(tgramScore) < -3:
					
					conNum = conNum + 1
				
				

				if (conNum > libNum) & (polAff == 'C'):
					x = 1
				elif(libNum > conNum) & (polAff == 'C'):
					x = 2
				elif (libNum > conNum) & (polAff == 'L'):
					x = -1
				elif (conNum > libNum) & (polAff == 'L'):
					x = -2
				elif(conNum == libNum):
					x = 0

				xList.append(x)

				if conNum > libNum:
					print('			Prediction: Conservative ')
				if libNum > conNum:
					print('			Prediction: Liberal ')
				if conNum == libNum:
					print('			Prediction: Unknown/Moderate')
				
	return(xList)
