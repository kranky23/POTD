/*

Difficulty : Medium

Topic Tags : Heap , Linked List

Date: 7-3-22

Problem Statement:
Given K sorted linked lists of different sizes. The task is to merge them in such a way that after merging they will be a single sorted linked list.

Example 1:

Input:
K = 4
value = {{1,2,3},{4 5},{5 6},{7,8}}
Output: 1 2 3 4 5 5 6 7 8
Explanation:
The test case has 4 sorted linked 
list of size 3, 2, 2, 2
1st    list     1 -> 2-> 3
2nd   list      4->5
3rd    list      5->6
4th    list      7->8
The merged list will be
1->2->3->4->5->5->6->7->8.

Example 2:

Input:
K = 3
value = {{1,3},{4,5,6},{8}}
Output: 1 3 4 5 6 8
Explanation:
The test case has 3 sorted linked
list of size 2, 3, 1.
1st list 1 -> 3
2nd list 4 -> 5 -> 6
3rd list 8
The merged list will be
1->3->4->5->6->8.
*/


class Solution
{
    //Function to merge K sorted linked list.
    Node mergeKList(Node[]arr,int k)
    {
        //Add your code here.
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>(); // main weapon here is this data structure called priority queue
        
        for(int i=0;i<arr.length;i++)
        {
            Node temp = arr[i];  //heads of all the K linked lists are given in this array..
            
            while(temp!=null)
            {
                pq.add(temp.data);   // insert every node value into priority queue..
                temp = temp.next;
            }
        }
        // System.out.println(pq);
        Node head = new Node(pq.poll());
        Node last = head;
        while(!pq.isEmpty()) // iterate until the priority queue is empty..
        {
            Node add = new Node(pq.poll()); // create new node and append it to the last added node..
            last.next = add;
            last = add; // update the newly added node as the last node
        }
        return head; // return the head of the sorted linked list to the function..
        
    }
}
