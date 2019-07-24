##############################################################################
#Author: Will Maxcy

#Date Created: 9/15/2017

#Date Modified: 11/29/2017

#Function: Runner class for program
##############################################################################

import os, os.path
import sys
import Train


# set number for pre made train/test sets
setNum = 3


# main function of program
Train.makeSet()
Train.go(setNum)

#Does entire analysis of bigrams and trigrams
#Train.goBig()

# train blogs
Train.testGo(setNum)

#Train.graph(0, 'A')	# Title Score
#Train.graph(1, 'A')	# Sentiment Score	
#Train.graph(2, 'A')	# Adjusted Sentiment Score
#Train.graph(3, 'A')	# Lexical Diversity
#Train.graph(4, 'A')	# Bigram Raw Score
#Train.graph(5, 'A')	# Adjusted Bigram Score
#Train.graph(6, 'A')	# Trigram Score