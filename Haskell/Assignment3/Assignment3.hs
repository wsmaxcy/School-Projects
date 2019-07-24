--Will Maxcy Assignment 3

-----------------------------------------------------------------------
--
-- 	Haskell: The Craft of Functional Programming, 3e
-- 	Simon Thompson
-- 	(c) Addison-Wesley, 1996-2011.
-- 
-- 	Chapter 12, Section 3: Recognizing Regular Expressions
--
------------------------------------------------------------------------

module RegExp where

import Data.List (foldl1)

type RegExp = String -> Bool

epsilon :: RegExp
epsilon = (=="")

char :: Char -> RegExp
char ch = (==[ch])

(|||) :: RegExp -> RegExp ->  RegExp
e1 ||| e2 = 
    \x -> e1 x || e2 x

(<*>) :: RegExp -> RegExp ->  RegExp
e1 <*> e2 =
    \x -> or [ e1 y && e2 z | (y,z) <- splits x ]

splits :: String -> [(String,String)]
splits xs = [splitAt n xs | n<-[0..len]]
    where
      len = length xs

(<**>) :: RegExp -> RegExp ->  RegExp
e1 <**> e2 =
    \x -> or [ e1 y && e2 z | (y,z) <- fsplits x ]

star :: RegExp -> RegExp
star p = epsilon ||| (p <**> star p)
--           epsilon ||| (p <*> star p)
-- is OK as long as p can't have epsilon match

fsplits :: String -> [(String,String)]
fsplits xs = tail (splits xs)

-- define a few char patterns for use in exercises
a,b :: RegExp
a = char 'a'
b = char 'b'

--- End of base program for assignment

--12.14 answer: Any combination of a's or b's as long as the length of the string of a's and b's is 0 or even
--proof of this will be showed in the screenshots.

--12.15 answer: Because of the rules of regular expression, the combination of star(regEx x) and 
--star(star(regEx x) would be the exact same thing. since the regular expression would be ((a+b)*(a+b)*)
--that would equal the same as ((a+b)*(a+b)*)*


--simple function that says that a method can either be the epislon function,which returns an empty
--string, or the regular expression "e" that is passed into the function
--12.16
option :: RegExp -> RegExp
option e = epsilon ||| e

--function that takes in a regular expression and says that either there has to be the regular expression
--that was passed through, or at least one of the multiple ways in order to complete the regular expression
--that was passed through (which is "e") this basically means that there can be any combination
--in the regular expression except for epsilon.
plus :: RegExp -> RegExp
plus e = e <**> star e

--12.17
--could not figure this one out.:(

--12.18
--a.
--since the regular expression for this would be (b*(a or epsilon) b* (a or epsilon) b*) the way to 
--transcribe this to this haskell function  would be 
--(star b <*> (a ||| epsilon) <*> star b <*> (a ||| epsilon) <*> star b)
--proof in screenshots

--b.
--the regular expression of this would be ((b*) a (b*) a (b*)) so the simple way to transpose this would 
--proof in screenshots
--be ((star b) <*> a <*> (star b) <*> a <*> (star b))