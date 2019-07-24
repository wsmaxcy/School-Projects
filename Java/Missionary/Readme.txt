Will Maxcy - Program 1 - September 24, 2015 - Readme.txt

Implementation Choices: The way that decided the best way to build this problem would be to build a tree of states. Each state contained a 4 numbers: left number of cannibals, right number of cannibals, left number of missionaries, right number of missionaries. The state also included whether or not the boat was on the left side or the right side of the river as well as a pointer to the previous move that the program made. Each cross is determined by if the boat is on the left or the right side of the river, and from there the program goes through the list of possible (can’t move more people than exist) and “safe” (states where there are not cannibals than missionaries on both the left and right side of the river) moves. 
I eliminated duplicate states by checking each new state and making sure that every new created state was not the child of one of it’s parent states. This was done in order to avoid infinite replication of the same loops and states. Once the tree was made I matched it with an “end state” that was made when the user would put in their parameters for the problem. If the input never matched, a message pops up and says there are no known solutions. This should be true due to the fact that every possible non-looping state would be made with this tree. Once the correct state was matched I printed the state of the final state as well as each of the corresponding parents of each state until I pulled a null state. From here, I put each state on a stack, then reversed the order of the states and 

Data Structures: I used a “state” class that had the number of missionaries and cannibals on each side of the state. I also used a tree that would keep track of the parent state in order to be able to find the correct path back to the root node.

Issues Encountered: Endless looping of creating identical states. This was a tough bug to fix because it was hard to figure out a way that would not only check the states of the parents, but also the parent’s parents and so on. Finally I used a recursive check that would check every single parent of the current state and if any of them matched the current state, the state would not be added into the tree. 

Known Bugs:
None ;)

Sample Outputs:
1.
Enter the number of seats in the boat between 2 and 4 : 3
Enter the number of total cannibals between 2 and 6 : 4
Enter the number of total missionaries between 2 and 6 : 4
---Start---
CCCCMMMM < 
CMMMM > CCC
CCMMMM < CC
MMMM > CCCC
CMMMM < CCC
CM > CCCMMM
CCMM < CCMM
C > CCCMMMM
CCMM > CCMM
CCCMMM < CM
CCC > CMMMM
CCCC < MMMM
CC > CCMMMM
CCC < CMMMM
 > CCCCMMMM
----End----

2.
Enter the number of seats in the boat between 2 and 4 : 4
Enter the number of total cannibals between 2 and 6 : 2
Enter the number of total missionaries between 2 and 6 : 2
---Start---
CCMM < 
 > CCMM
----End----

3.
Enter the number of seats in the boat between 2 and 4 : 6
Bruh, you need to put between 2 and 4 seats for this boat
5
Bruh, you need to put between 2 and 4 seats for this boat
4
Enter the number of total cannibals between 2 and 6 : 1
Hey, you need between 2 and 6 cannibals! Try again!
7
Hey, you need between 2 and 6 cannibals! Try again!
6
Enter the number of total missionaries between 2 and 6 : 6
---Start---
CCCCCCMMMMMM < 
CCMMMMMM > CCCC
CCCMMMMMM < CCC
MMMMMM > CCCCCC
CCCCMMMMMM > CC
CCCCCMMMMMM < C
CMMMMMM > CCCCC
CCMMMMMM < CCCC
CCMM > CCCCMMMM
CCCCMMMM > CCMM
CCCCMMMMMM < CC
CCCMMM > CCCMMM
CCCCMMMM < CCMM
CCCC > CCMMMMMM
CCCCC < CMMMMMM
C > CCCCCMMMMMM
CCCCC > CMMMMMM
CCCCCC < MMMMMM
CC > CCCCMMMMMM
CCC < CCCMMMMMM
 > CCCCCCMMMMMM
----End----

4. 
Enter the number of seats in the boat between 2 and 4 : 3
Enter the number of total cannibals between 2 and 6 : 3
Enter the number of total missionaries between 2 and 6 : 2
More cannibals than missionaries! Side unsafe! Use more or the same amount of missionaries!
5
---Start---
CCCMMMMM < 
MMMMM > CCC
CMMMMM < CC
CMM > CCMMM
CCMMMM > CM
CCCMMMM < M
CCMM > CMMM
CCMMM < CMM
CM > CCMMMM
CMM < CCMMM
 > CCCMMMMM
----End----

5.
Enter the number of seats in the boat between 2 and 4 : 2
Enter the number of total cannibals between 2 and 6 : 4
Enter the number of total missionaries between 2 and 6 : 4
No known solution for this problem :(

6.
---Start---
CCMMMMMM < 
MMMMMM > CC
CMMMMMM < C
CMMMMM > CM
CCMMMMM < M
CCMMM > MMM
CCMMMM < MM
CMMMM > CMM
CMMMMM < CM
CMMM > CMMM
CCMMM < MMM
MMM > CCMMM
CMMM < CMMM
CMM > CMMMM
CCMM < MMMM
MM > CCMMMM
CMM < CMMMM
C > CMMMMMM
CC < MMMMMM
 > CCMMMMMM
----End----

