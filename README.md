= Cracking the Coding Interview, 6th Edition

 
 
== https://github.com/sunilsoni/cracking-the-coding-interview/tree/master/src/Strings[Solutions to Chapter 1: Arrays and Strings]

* https://github.com/sunilsoni/cracking-the-coding-interview/blob/master/src/Strings/IsUniqueChars.java[*Is Unique:*] Implement an algorithm to determine if a string has all unique characters. What if you cannot use additional data structures?.

* https://github.com/sunilsoni/cracking-the-coding-interview/blob/master/src/com/ctci6/ch01/Permutation.java[*Check Permutation:*] Given two strings, write a method to decide if one is a permutation of the
other.


* https://github.com/kiranjagtap/Cracking-Coding-Interview/blob/master/src/com/ctci6/ch01/URLify.java[*URLify:*] Write a method to replace all spaces in a string with '%2e: You may assume that the string has sufficient space at the end to hold the additional characters, and that you are given the "true" length of the string. 
Note:: If implementing in Java, please use a character array so that you can perform this operation in place.

[source,java]
-----------------
	EXAMPLE
	Input: "Mr John Smith JJ, 13  "
	Output: "Mr%2eJohn%2eSmith"
-----------------

* https://github.com/kiranjagtap/Cracking-Coding-Interview/blob/master/src/com/ctci6/ch01/PalindromePermutation.java[*Palindrome Permutation:*] Given a string, write a function to check if it is a permutation of a palindrome. A palindrome is a word or phrase that is the same forwards and backwards. A permutation is a rearrangement of letters. The palindrome does not need to be limited to just dictionary words.

[source,java]
-----------------
	EXAMPLE
	Input: Tact Coa
	Output: True (permutations:"taco cat'; "atco cta'; etc.)
-----------------


* https://github.com/kiranjagtap/Cracking-Coding-Interview/blob/master/src/com/ctci6/ch01/OneEditAway.java[*One Away:*] There are three types of edits that can be performed on strings: insert a character, remove a character, or replace a character. Given two strings, write a function to check if they are one edit (or zero edits) away.

[source,java]
-----------------
EXAMPLE
pale, ple -> true
pales, pale -> true
pale, bale -> true
pale, bae -> false
-----------------


* https://github.com/kiranjagtap/Cracking-Coding-Interview/blob/master/src/com/ctci6/ch01/StringCompression.java[*String Compression:*] Implement a method to perform basic string compression using the counts of repeated characters. For example, the string aabcccccaaa would become a2blc5a3. If the
"compressed"string would not become smaller than the original string, your method should return the original string. You can assume the string has only uppercase and lowercase letters (a - z).

* https://github.com/kiranjagtap/Cracking-Coding-Interview/blob/master/src/com/ctci6/ch01/RotateMatrix.java[*Rotate Matrix:*] Given an image represented by an NxN matrix, where each pixel in the image is 4 bytes, write a method to rotate the image by 90 degrees. Can you do this in place? 

* https://github.com/kiranjagtap/Cracking-Coding-Interview/blob/master/src/com/ctci6/ch01/ZeroMatrix.java[*Zero Matrix:*] Write an algorithm such that if an element in an MxN matrix is 0, its entire row and column are set to 0

* https://github.com/kiranjagtap/Cracking-Coding-Interview/blob/master/src/com/ctci6/ch01/StringRotation.java[*String Rotation:*] Assume you have a method i5Substring which checks ifone word is a substring of another. Given two strings, 51 and 52, write code to check if 52 is a rotation of 51 using only one call to isSubstring 

[source,java]
-----------------
e.g., Uwaterbottleu is a rotation of uerbottlewatU.
-----------------

== https://github.com/kiranjagtap/Cracking-Coding-Interview/tree/master/src/com/ctci6/ch02[Solutions to Chapter 2: Linked List]

* https://github.com/kiranjagtap/Cracking-Coding-Interview/blob/master/src/com/ctci6/ch02/RemoveDups.java[*Remove Dups:*] Write code to remove duplicates from an unsorted linked list.
FOLLOW UP:: How would you solve this problem if a temporary buffer is not allowed?


* https://github.com/kiranjagtap/Cracking-Coding-Interview/blob/master/src/com/ctci6/ch02/ReturnKthToLast.java[*Return Kth to Last:*] Implement an algorithm to find the kth to last element of a singly linked list.

* https://github.com/kiranjagtap/Cracking-Coding-Interview/blob/master/src/com/ctci6/ch02/DeleteMiddleNode.java[*Delete Middle Node:*] 
Implement an algorithm to delete a node in the middle (i.e., any node but the first and last node, not necessarily the exact middle) of a  singly linked list, given only access to that node.
 
[source,java]
-----------------
EXAMPLE
Input: the node c from the linked list a - >b- >c - >d - >e- >f
Result: nothing is returned, but the new linked list looks like a->b->d->e->f
-----------------

* https://github.com/kiranjagtap/Cracking-Coding-Interview/blob/master/src/com/ctci6/ch02/Partition.java[*Partition:*] 
Write code to partition a linked list around a value x, such that all nodes less than x come before all nodes greater than or equal to x.
If x is contained within the list, the values of x only need to be after the elements less than x (see below).
The partition element x can appear anywhere in the "right partition"; it does not need to appear between the left and right partitions.

[source,java]
-----------------
EXAMPLE
Input: 3 -> 5 -> 8 -> 5 -> 113 -> 2 -> 1 [partition = 5]
Output: 3 -> 1 -> 2 -> 113 -> 5 -> 5 -> 8
-----------------

* https://github.com/kiranjagtap/Cracking-Coding-Interview/blob/master/src/com/ctci6/ch02/SumLists.java[*Sum Lists:*] 
You have two numbers represented by a linked list, where each node contains a single digit. The digits are stored in reverse order,
such that the 1's digit is at the head of the list. Write a function that adds the two numbers and returns the sum as a linked list.

[source,java]
-----------------
EXAMPLE:
Input: (7-> 1 -> 6) + (5 -> 9 -> 2) .That is,617 + 295.
Output: 2 - > 1 - > 9.That is, 912.
-----------------

[source,java]
-----------------
FOLLOW UP:Suppose the digits are stored in forward order. Repeat the above problem.
Input: (6 -> 1 -> 7) + (2 -> 9 -> 5).That is,617 + 295.
Output: 9 - > 1 - > 2.That is, 912.
-----------------


* https://github.com/kiranjagtap/Cracking-Coding-Interview/blob/master/src/com/ctci6/ch02/Palindrome.java[*Palindrome:*] 
Implement a function to check if a linked list is a palindrome.



* https://github.com/kiranjagtap/Cracking-Coding-Interview/blob/master/src/com/ctci6/ch02/Intersection.java[*Intersection:*] 
Given two (singly) linked lists, determine if the two lists intersect. Return the intersecting node. Note that the intersection is defined based on reference, not value. That is, if the kth node of the first linked list is the exact same node (by reference) as the jth node of the second
linked list, then they are intersecting.

* https://github.com/kiranjagtap/Cracking-Coding-Interview/blob/master/src/com/ctci6/ch02/LoopDetection.java[*Loop Detection:*] 
Given a circular linked list, implement an algorithm that returns the node at the beginning of the loop.

DEFINITION:
Circular linked list: A (corrupt) linked list in which a node's next pointer points to an earlier node, so as to make a loop in the linked list.

[source,java]
-----------------
EXAMPLE
Input:A - > B - > C - > D - > E - > C [the same C as earlier]
Output:C
-----------------



== https://github.com/kiranjagtap/Cracking-Coding-Interview/tree/master/src/com/ctci6/ch03[Solutions to Chapter 3: Stacks and Queues]

* https://github.com/kiranjagtap/Cracking-Coding-Interview/blob/master/src/com/ctci6/ch03/ThreeInOneFixedMultiStack.java[*Three In One: Fixed Multi Stack*] 
Describe how you could use a single array to implement three stacks:

[source,java]
-----------------
Approach 1: Fixed Division
We can divide the array in three equal parts and allow the individual stack to grow in that limited space.
Note: We will use the notation "[" to mean inclusive of an end point and "(" to mean exclusive of an end
point.
For stack 1, we will use [0, X).
For stack 2, we will use [ X, 2X) .
For stack 3, we will use [ 2X , n) .
-----------------

* https://github.com/kiranjagtap/Cracking-Coding-Interview/blob/master/src/com/ctci6/ch03/ThreeInOneMultiStack.java[*Three In One: Multi Stack*] 
Describe how you could use a single array to implement three stacks.

[source,java]
-----------------
Approach 2: Flexible Divisions
A second approach is to allow the stack blocks to be flexible in size. When one stack exceeds its initial
capacity, we grow the allowable capacity and shift elements as necessary.
-----------------

* https://github.com/kiranjagtap/Cracking-Coding-Interview/blob/master/src/com/ctci6/ch03/StackWithMin.java[*Stack Min 1:*] 
How would you design a stack which, in addition to push and pop, has a function min which returns the minimum element? Push, pop and min should all operate in 0(1) time.

[source,java]
-----------------
Approach 1: One solution is to have just a single int value, minValue, that's a member of the Stack class. When
minValue is popped from the stack, we search through the stack to find the new minimum. Unfortunately,
this would break the constraint that push and pop operate in 0(1) time.
-----------------

* https://github.com/kiranjagtap/Cracking-Coding-Interview/blob/master/src/com/ctci6/ch03/StackWithMin2.java[*Stack Min 2:*] 
How would you design a stack which, in addition to push and pop, has a function min which returns the minimum element? Push, pop and min should all operate in 0(1) time.

[source,java]
-----------------
Approach 2: We can (maybe) do a bit better than this by using an additional stack which keeps track of the mins.
Why might this be more space efficient? Suppose we had a very large stack and the first element inserted
happened to be the minimum. In the first solution, we would be keeping n integers, where n is the size of
the stack. In the second solution though, we store just a few pieces of data: a second stack with one element
and the members within this stack.
-----------------

* https://github.com/kiranjagtap/Cracking-Coding-Interview/blob/master/src/com/ctci6/ch03/SetOfStacks.java[*Stack of Plates:*]
Imagine a (literal) stack of plates. If the stack gets too high, it might topple. Therefore, in real life, we would likely start a new stack when the previous stack exceeds some
threshold. Implement a data structure SetOfStacks that mimics this. SetOfStacks should be composed of several stacks and should create a new stack once the previous one exceeds capacity.
SetOfStacks.push() and SetOfStacks. pop() should behave identically to a single stack (that is, pop() should return the same values as it would if there were just a single stack).

FOLLOW UP:Implement a function popAt(int index) which performs a pop operation on a specifc substack.


* https://github.com/kiranjagtap/Cracking-Coding-Interview/blob/master/src/com/ctci6/ch03/QueueViaStack.java[*Queue Via Stack:*]
Implement a MyQueue class which implements a queue using two stacks

* https://github.com/kiranjagtap/Cracking-Coding-Interview/blob/master/src/com/ctci6/ch03/SortStack.java[*Sort Stack:*]
Write a program to sort a stack such that the smallest items are on the top. You can use an additional temporary stack, but you may not copy the elements into any other data structure (such as an array). The stack supports the following operations: push, pop, peek, and isEmpty.

