##############################################################################
#Author: Will Maxcy

#Date Created: 10/02/2017

#Date Modified: 11/12/2017

#Function: creation and organization of blogs by date
##############################################################################

import os, os.path
import sys
import re
import datetime

def date(date, data, outFile, polAff):
	#print(date,blog)

	def dateWeek(date):
		week = "00"
		year = int((date.replace("-",""))[:4])
		stripped = int((date.replace("-",""))[4:])
		if(101 <= stripped <= 108):
			week = "01"
		if(109 <= stripped <= 115):
			week = "02"
		if(116 <= stripped <= 122):
			week = "03"
		if(123 <= stripped <= 129):
			week = "04"
		if(130 <= stripped <= 205):
			week = "05"
		if(206 <= stripped <= 212):
			week = "06"
		if(213 <= stripped <=219 ):
			week = "07"
		if(220 <= stripped <= 226):
			week = "08"
		if(227 <= stripped <= 305):
			week = "09"
		if(306 <= stripped <= 312):
			week = "10"
		if(313 <= stripped <= 319):
			week = "11"
		if(320 <= stripped <= 326):
			week = "12"
		if(407 <= stripped <= 402):
			week = "13"
		if(403 <= stripped <= 409):
			week = "14"
		if(410 <= stripped <= 416):
			week = "15"
		if(417 <= stripped <= 423):
			week = "16"
		if(424 <= stripped <= 430):
			week = "17"
		if(501 <= stripped <= 507):
			week = "18"
		if(508 <= stripped <= 514):
			week = "19"
		if(515 <= stripped <= 521):
			week = "20"
		if(522 <= stripped <= 528):
			week = "21"
		if(529 <= stripped <= 604):
			week = "22"
		if(605 <= stripped <= 611):
			week = "23"
		if(612 <= stripped <= 618):
			week = "24"
		if(619 <= stripped <= 625):
			week = "25"
		if(626 <= stripped <= 702):
			week = "26"
		if(703 <= stripped <= 709):
			week = "27"
		if(710 <= stripped <= 716):
			week = "28"
		if(717 <= stripped <= 723):
			week = "29"
		if(724 <= stripped <= 730):
			week = "30"
		if(731 <= stripped <= 806):
			week = "31"
		if(807 <= stripped <= 813):
			week = "32"
		if(814 <= stripped <= 820):
			week = "33"
		if(821 <= stripped <= 827):
			week = "34"
		if(828 <= stripped <= 903):
			week = "35"
		if(904 <= stripped <= 910):
			week = "36"
		if(911 <= stripped <= 917):
			week = "37"
		if(918 <= stripped <= 924):
			week = "38"
		if(925 <= stripped <= 1001):
			week = "39"
		if(1002 <= stripped <= 1008):
			week = "40"
		if(1009 <= stripped <= 1015):
			week = "41"
		if(1016 <= stripped <= 1022):
			week = "42"
		if(1023 <= stripped <= 1029):
			week = "43"
		if(1030 <= stripped <= 1105):
			week = "44"
		if(1106 <= stripped <= 1112):
			week = "45"
		if(1113 <= stripped <= 1119):
			week = "46"
		if(1120 <= stripped <= 1126):
			week = "47"
		if(1127 <= stripped <= 1203):
			week = "48"
		if(1204 <= stripped <= 1210):
			week = "49"
		if(1211 <= stripped <= 1217):
			week = "50"
		if(1218 <= stripped <= 1224):
			week = "51"
		if(1225 <= stripped <= 1231):
			week = "52"
		

		dateFile = (year, 'Week '+week)
		return dateFile

	#print(sys.path[0] + '/Blogs/Blog Data/' + str(dateWeek(date)[0]) + '/' + str(dateWeek(date)[1]))
	if(polAff is 'C'):
		path = sys.path[0] + '/Blogs/Dated Blogs/C/'

	if(polAff is 'L'):
		path = sys.path[0] + '/Blogs/Dated Blogs/L/'

	if(polAff is 'U'):
		path = sys.path[0] + '/Blogs/Dated Blogs/U/'

	year = str(dateWeek(date)[0])
	week = str(dateWeek(date)[1])
	outFileName = os.path.join(path + '/' + year + '/' + week+ '/', outFile)
	
	if not os.path.isdir(path + '/' + year):
		os.mkdir(path + '/' + year)
	if not os.path.isdir(path + '/' + year + '/' + week):
		os.mkdir(path + '/' + year + '/' + week)
	
	f = open(outFileName, 'w+')
	f.write(data)
	f.close()
	

	
