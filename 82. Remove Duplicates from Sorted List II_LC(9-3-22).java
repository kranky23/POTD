/*
Difficulty : Medium

Topic : LinkedList, 2 Pointers

Problem Statement:
Given the head of a sorted linked list, delete all nodes that have duplicate numbers, leaving only distinct numbers from the original list. Return the linked list sorted as well.


Example 1:

Input: head = [1,2,3,3,4,4,5]
Output: [1,2,5]

Example 2:

Input: head = [1,1,1,2,3]
Output: [2,3]
*/


class Solution {
    public ListNode deleteDuplicates(ListNode head) 
    {
        TreeMap<Integer,Integer> hm = new TreeMap<>();
        
        ListNode temp = head;
        
        while(temp!=null)
        {
            if(hm.containsKey(temp.val))
            {
                int count = hm.get(temp.val);
                count++;
                hm.put(temp.val,count);
            }
            else
            {
                hm.put(temp.val,1);
            }
            temp = temp.next;
        }
        ListNode start = null;
        ListNode first = null;
        // ListNode head = start;
        for(int i: hm.keySet())
        {
            
            if(hm.get(i)==1)
            {
                if(first==null)
                {
                    first = new ListNode();
                    first.val = i;
                    start = first;
                }
                else
                {
                    ListNode add = new ListNode();
                    add.val = i;
                    start.next = add;
                    start = add;
                }
            }
        }
        return first;
        
    }
}
