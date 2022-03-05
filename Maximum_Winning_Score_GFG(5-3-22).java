/*
Difficulty : Medium

Topic Tags : Recursion, Tree 

Date : 5-3-22

Problem Statement:
In an online game, N blocks are arranged in a hierarchical manner. All the blocks are connected together by a total of N-1 connections. Each block is given an ID from 1 to N. A block may be further connected to other blocks. Each block is also assigned a specific point value.

A player starts from Block 1. She must move forward from each block to a directly connected block until she reaches the final block, which has no further connection. When the player lands on a block, she collects the point value of that block. The players score is calculated as the product of point values that the player collects.
Find the maximum score a player can achieve.
Note: The answer can always be represented with 64 bits.

Input 1: 
Input:
     4
    / \
   2   8
  / \ / \
 2  1 3  4
Output: 128
Explanation: Path in the given tree 
goes like 4, 8, 4 which gives the max
score of 4x8x4 = 128.
------------------------------------------
Input 2:
     10
   /    \
  7      5
          \
           1
Output: 70
Explanation: The path 10, 7 gives a 
score of 70 which is the maximum possible.

*/

class Solution
{
    public static long func(Node root)  // recursive function to calculate the maximum product of the paths from root to leaf.
    {
        if(root==null)
        {
            return 1;
        }
        if(root.left==null && root.right==null) // if you find a leaf node, that is the end of that path and return the leaf node data...
            return root.data;
        
        long val = root.data * Math.max(func(root.left),func(root.right)); // recurse in left subtree and right subtree and find the maximum value of the obtained paths..
        return val;
    }
    
    public static Long findMaxScore(Node root)
    {
        //code here
        long res = func(root);
        return res;
    }
}
