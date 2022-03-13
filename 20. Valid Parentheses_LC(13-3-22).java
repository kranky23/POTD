/*
Difficulty : Easy

Topic Tags : String, Stack

Problem Statement:
Given a string s containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.

An input string is valid if:

    Open brackets must be closed by the same type of brackets.
    Open brackets must be closed in the correct order.

Example 1:

Input: s = "()"
Output: true

Example 2:

Input: s = "()[]{}"
Output: true

Example 3:

Input: s = "(]"
Output: false
*/

class Solution 
{
    public boolean isValid(String s) 
    {
        int square = 0;
        int open = 0;
        int curly = 0;
        // if(s.charAt(0))
        Stack<Character> st = new Stack<>();  // the saviour data structure for such kind of problems..
        
        for(int i=0;i<s.length();i++)
        {
            if(s.charAt(i) == '(' || s.charAt(i)=='[' || s.charAt(i)=='{')  // push if open brackets..
                st.push(s.charAt(i));
            else if(!st.isEmpty())
            {
                char ch = st.peek();
                st.pop();  // pop if close brackets and compare... return false if doesnt match.. else continue until the end of string..
                if(ch=='(' && s.charAt(i)!=')')
                    return false;
                else if(ch=='{' && s.charAt(i)!='}')
                    return false;
                else if(ch=='[' && s.charAt(i)!=']')
                    return false;
            }
            else if(st.isEmpty())  // if stack is empty in between i.e. if a closed bracket comes before an opening bracket, return false..
                return false;
                
        }
        if(st.isEmpty()) // if stack is empty after the loop exited then return true coz all the brackets matched...
            return true;
        return false;  // else did not match..
        
    }
}
