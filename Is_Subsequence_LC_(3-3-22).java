/*
Difficulty : Easy
Date : 3-3-22

Problem Statement:
Given two strings s and t, return true if s is a subsequence of t, or false otherwise.

A subsequence of a string is a new string that is formed from the original string by deleting some (can be none) of the characters without disturbing the 
relative positions of the remaining characters. (i.e., "ace" is a subsequence of "abcde" while "aec" is not).

Input: s = "abc", t = "ahbgdc"
Output: true

Input: s = "axc", t = "ahbgdc"
Output: false

*/
class Solution
{
    public boolean isSubsequence(String s, String t) 
    {
        int arr[] = new int[s.length()];
        
        int ind = 0;
      
        //The following are the base cases..
        if(s.length()==0) // if subsequence string length is zero then it is a subsequence of every string. Hence return true
            return true;
        if(t.length()==0) // If main string length is zero, it cannot have subsequence of any other string. Hence return false.
            return false;
        
        int j=0;
        int i=0;

        while(j<t.length())  // run until the super string runs out of characters i.e. the length of the characters
        {
            if(t.charAt(j)==s.charAt(i))
                i++;
            j++;
            
            if(i==s.length())
                return true;
        }
        
        
        return false;
        
        
    }
}
