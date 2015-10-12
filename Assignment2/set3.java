Q1. Let�s consider K-based numbers, containing exactly N digits. We define a number to be valid if its K-based notation doesn�t contain two successive zeros. For example:
1010230 is a valid 7-digit number;
1000198 is not a valid number;
0001235 is not a 7-digit number, it is a 4-digit number.
Given two numbers N and K, you are to calculate an amount of valid K based numbers, containing N digits.
You may assume that 2 = K = 10; N = 2; N + K = 18.

Q2. Write a function with the following prototype that returns the sum of the digits of an integer.
int sumOfDigits(int x);
If x is 234, the function should return 2 + 3 + 4, that is, 9.
If x is 12, the function should return 1 + 2, which is 3.
If x is 39, the function should return 12.
If x is negative, ignore the minus sign. For example, -12 and 12 both return 3.

Q3. Write a reverse() function recursively. This function takes a string and the length of the string as arguments and returns the same string with its characters in the reverse order. 

Q4. Given an array of ints, compute recursively if the array contains a 6. We'll use the convention of considering only the part of the array that begins at the given index. In this way, a recursive call can pass index+1 to move down the array. The initial call will pass in index as 0. 

array6({1, 6, 4}, 0) : true
array6({1, 4}, 0) : false
array6({6}, 0) : true