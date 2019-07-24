README for Project1
-Will Maxcy / Project 1 / 9/23/2016

Simply run file and the program giveswhat the max sum is, what positions the subarray goes from and to,
every value within subarray that allows for max sum to be possible.

There are comments within the code that explain what each part is doing.

The algorithm basically works by calling the findMax function which takes in an array.
From here, boundaries and sums are all set to 0.
The array is traversed ONE time (allowing for it to be linear time).
The total sum of the array is added together only if it will become larger. 
This is done by using the second if statement.
The first if statment checks to see if the current sum is larger than the current integer in the list being
	looked over. If it is it says that the left most node in the max sub array has to be this number.
From here, curSum is changed allowing for the new current subarray to be updated.
This continues until the list is traversed and a new max subarray is found.