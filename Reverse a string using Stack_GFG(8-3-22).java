/*
Difficulty: Easy

Topic Tags: Stack, Strings

Problem Statement:
You are given a string S, the task is to reverse the string using stack.

Example 1:

Input: S="GeeksforGeeks"
Output: skeeGrofskeeG

*/

class Solution 
{
    
    public String reverse(String S)
    {
        //code here
        Stack<Character> st = new Stack<>();
        
        for(int i=0;i<S.length();i++)
            st.push(S.charAt(i));
            
        StringBuilder sb = new StringBuilder();  //using this so that appending is easy coz StringBuilders are mutable..
        while(!st.isEmpty())
            sb.append(st.pop()); // basis stuff..
        return sb.toString(); //returning the String version of StringBuilder..
    }

}
