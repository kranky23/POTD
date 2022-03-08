/*
Difficulty : Easy

Topic Tags: HashTable, Linked List, 2 Pointers

Problem Statement:
Given head, the head of a linked list, determine if the linked list has a cycle in it.

There is a cycle in a linked list if there is some node in the list that can be reached again by continuously following the next pointer. Internally, pos is used to denote the index of the node that tail's next pointer is connected to. Note that pos is not passed as a parameter.

Return true if there is a cycle in the linked list. Otherwise, return false.

Example 1:

Input: head = [3,2,0,-4], pos = 1
Output: true
Explanation: There is a cycle in the linked list, where the tail connects to the 1st node (0-indexed).

Example 2:

Input: head = [1,2], pos = 0
Output: true
Explanation: There is a cycle in the linked list, where the tail connects to the 0th node.

Example 3:

Input: head = [1], pos = -1
Output: false
Explanation: There is no cycle in the linked list.

Follow up: Can you solve it using O(1) (i.e. constant) memory?
*/

public class Solution 
{
    public boolean hasCycle(ListNode head) 
    {
        //base cases
        if(head==null)
            return false;
        if(head.next==null)
            return false;
        
        //2 pointer technique..
        ListNode slow = head;
        ListNode fast = head.next;
        
        while(slow!=fast)
        {
            if(fast!=null && fast.next!=null && fast.next.next!=null) //once fast reaches the end of linked list, then there is no cycle..
            {
                fast = fast.next.next;
                slow = slow.next;
            }
            else
            {
                return false;  //this means faster node has reached the end of the list and no cycle is present.. hence return false..
            }
        }
        return true; // this means that slow and fast nodes have met and it means that there is a cycle present and hence returns true..
        
    }
}
