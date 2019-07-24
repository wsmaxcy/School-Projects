--Will Maxcy
--Assignment 1 
--Sept 15 2014

--xor operation that only returns 'True' when there exists one and only one 'True' True argument. 
--simply hard coded due to the fact that there are only 4 possible states.
xor:: Bool -> Bool -> Bool
xor True True = False
xor True False = True
xor False True = True
xor False False = False

--recursive function that takes 2 integers in and returns the product of those integers
--returns 0 if either integers given are 0, and does a recursive addition call to multiply the rest
--says that if a or b is greater than 0, then the return value is the recursive call of mult with a,
--b - 1, and then an additional a added on to the product. this basically adds the integer 'a' to 'a'
--exactly 'b' number of times, resulting in the product of the two numbers
mult:: Int -> Int -> Int
mult a 0 = 0
mult 0 b = 0
mult a b | a > 0 = mult (a)(b-1)+a

--fucntion that takes in a list of any parameter that can be ordered (which is what "Ord a" allows for) and
--finds the largest value in that list. throws an error for an empty list.
maxval:: (Ord a) => [a] -> a
maxval [] = error "can't do this with empty list!"
maxval [x] = x
maxval (x:xs) = max x(maxval xs) --takes the first object of the list, then recursivly calls 'maxval'
				 --which basically stretches out each individual item in the list.
				 --the max function basically takes all the items in this list and
				 --finds the largest one out of this list. It looks like this.
				 --for [1,2,3,4,5] it says (1:2,3,4,5) to ([1:2]:[3,4,5]) to ... ([1:2:3:4:5] 
				 --so that max can iterate through the list of items and find the largest

--function that takes in a list of Int's and returns a list of ordered pair Int's, Has the base cases for
--empty lists and when the list only contains one element. the function breaks apart the list of Ints by
--finding the first two elements in it using (x:y:xs), x and y being the first two elements. Then it simply adds
--those to a list, then adds the recurisve call to adjpairs with the argument of the list, PLUS the second element
--in the list added to the top of it, in order to produce every possible ordered pair of Ints in the list that are
--directly next to eachother
adjpairs:: [Int] -> [(Int,Int)]
adjpairs [] = []
adjpairs [x] = []
adjpairs(x:y:xs)= [(x,y)]++ (adjpairs([y]++xs))


-----------------------------------------------------------------------------------------------------------------------

--this function takes in the list of doubles and returns the value of all of the doubles added together. this happens by 
--iterating through the list, taking the first double from the list, then adding to the recursive call of 'addlist' which
--repeats this process untill every Double in the list is added to the total value
addlist:: [Double] -> Double
addlist [] = error "empty list, you dummy!" 
addlist [x] = x
addlist (x:xs) = (x + addlist(xs))

--function that takes in a list of Doubles and finds how many objects are actually in the list. this is done by taking the
--tail of the list and adding one to every time there exists a tail that does not equal 0
findlength::[Double] -> Double
findlength [] = 0
findlength [x] = 1
findlength(_:xs) = 1 + findlength(xs)

--the mean class is the main "class" of this function. basically, the mean function takes in a list of doubles, and for
--every list that has more than 2 elements puts the list of Doubles into both the 'addlist' function as well as the 
--'findlength' function.
mean:: [Double] -> Double
mean [] = error "cant because empty!"
mean [x] = x
mean (x:xs) = addlist([x]++xs)/findlength([x]++xs)
------------------------------------------------------------------------------------------------------------------------

--function that takes an Int and asks if when it is modded by two if it equals 1 or 0. if it equals one, you take a 1
--and add it to the end of the list of integers, if it equals 0 you add 0 to the end of the list. then the x value
--is divided by 2 and mad to go back through the function again.
natToBin:: Int -> [Int]
natToBin 0 = [0]
natToBin x | (x `mod` 2)== 1= (natToBin(x `div` 2)++[1])
	   | (x `mod` 2)== 0= (natToBin(x `div` 2)++[0])

--function that takes the base number, a decimal integer and returns it in the value of whatever base you put in. this is done by 
--recursivly calling 'natToBase' and by dividing the number to change by the base number. Then we take the inverse of that in order
--to find out what actual number to place on to the end of the list. This is done by using the mod operation
natToBase:: Int -> Int -> [Int]
natToBase 0 y = error "no such thing as base 0"
natToBase x 0 = [0]
natToBase x y = natToBase x(y `div` x)++ [y `mod` x]

--Can not figure out base to Nat!