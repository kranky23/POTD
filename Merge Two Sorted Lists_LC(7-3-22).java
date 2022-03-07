/*
Difficulty : Easy

Topic Tags : Linked List, Recursion

Date : 7-3-22

Problem Statement:
You are given the heads of two sorted linked lists list1 and list2.

Merge the two lists in a one sorted list. The list should be made by splicing together the nodes of the first two lists.

Return the head of the merged linked list.

Example1

Input: list1 = [1,2,4], list2 = [1,3,4]
Output: [1,1,2,3,4,4]
------------------------------------------
Example 2:

Input: list1 = [], list2 = []
Output: []
------------------------------------------

Example 3:

Input: list1 = [], list2 = [0]
Output: [0]

*/


class Solution {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) 
    {
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
        //following are the base cases..
        ListNode temp = list1;
        if(list1==null && list2==null)
            return null;
        if(list1==null)
            return list2;
        if(list2==null)
            return list1;
      //end of base cases.
      
        while(temp!=null)
        {
            pq.add(temp.val);
            temp = temp.next;
        }
        
        temp = list2;

        while(temp!=null)
        {
            pq.add(temp.val);
            temp = temp.next;
        }
        // used the same concept of priority queue which was not needed though..  could have done using recursion but opted for PQ coz GFG also had similar question
        // where it had to merge K linked lists (sorted).. Hence used the same code and tweaked it accordingly.. Otherwise can be solved using recursion..
      
        ListNode head = new ListNode(pq.poll());
        if(head==null)
            return head;
        ListNode last = head;
        while(!pq.isEmpty())
        {
            ListNode add = new ListNode(pq.poll()); // equivalent to Heap Sort..
            last.next = add;
            last = add;
        }
        return head;
    }
}
