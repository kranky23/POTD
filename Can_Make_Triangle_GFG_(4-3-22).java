/*
Problem Statement: Can Make Triangle
Difficulty : Medium (though it is very easy! :p)

Construct an array of integers of length N - 2 where ith element is equal to 1 if it is possible to form a triangle with side lengths A[i], A[i+1], and A[i+2]. otherwise 0.

Note: A triangle can be formed with side lengths a, b and c if a+b>c and a+c>b and b+c>a.

Input:
N = 4
A[] = {1, 2, 2, 4}
Output:
1 0


Input: 
N = 5
A[] = {2, 10, 2, 10, 2}
Output:
0 1 0
*/
class Solution 
{ 
    int[] canMakeTriangle(int a[], int N) 
    { 
        // code here
        int arr[] = new int[N-2];

        for(int i=0;i<N-2;i++) 
            if(a[i]+a[i+1]>a[i+2] && a[i+1]+a[i+2]>a[i] && a[i]+a[i+2]>a[i+1]) // check whether the sides of the triangle obey the laws of being a triangle...
                arr[i] = 1;  //if yes, make the ith index = 1 as mentioned in the problem statement..
                
        return arr;
    }
}
