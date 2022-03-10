/*
Difficulty : Medium

Topic Tags : Linked List, Math, Recursion(Which I did not use)

Problem Statement:

You are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse order, and each of their nodes contains a single digit. Add the two numbers and return the sum as a linked list.

You may assume the two numbers do not contain any leading zero, except the number 0 itself.

*/




class Solution 
{
public:
    ListNode* addTwoNumbers(ListNode* l1, ListNode* l2) 
    {
        ListNode* h1 = l1;
        ListNode* h2 = l2;        
        
        ListNode* temp = l1;
        bool equal = false;
        
        int sum = 0;
        bool carry = false;
        ListNode* prev = NULL;
        
        while(l1!=NULL && l2!=NULL)
        {
            sum = l1->val + l2->val;
            if(carry==true)
                sum++;
            
            if(sum>=10)
            {
                carry = true;
                sum = sum%10;
            }
            
            else
                carry = false;
            l1->val = sum;
            prev = l1;
            l1 = l1->next;
            l2 = l2->next;
        }
        
        if(l1==NULL && l2==NULL)  // if two the numbers are of equal length
        {
            if(carry == true) // if any carry remained from the previous addition operation in the loop, add a new node to the end with value 1 at the end..
            {
                ListNode* add = new ListNode(1);
                prev->next = add;
                return temp;
            }
            else
                return temp;
        }
        
        if(l2==NULL)  // if l1 is longer than l2..
        {
            while(l1!=NULL)  // calculate and append the values of l1 only and check if any carry is present..
            {
                if(carry == true)
                {
                    sum = l1->val + 1;
                    carry = false;
                }
                else
                {
                    return temp;
                }
                if(sum>=10)
                {
                    sum = 0;
                    carry = true;
                }
                l1->val = sum;
                prev = l1;
                l1 = l1->next;
            }
            if(carry == true)
            {
                ListNode* add = new ListNode(1);
                prev->next = add;
                return temp;
            }
            else
                return temp;
        }
        else
        {
            while(l2!=NULL)  // calculate and append the values of l2 only and check if any carry is present..
            {
                if(carry == true)
                {
                    sum = l2->val + 1;
                    carry = false;
                }
                else
                    sum = l2->val;
                if(sum>=10)
                {
                    sum = 0;
                    carry = true;       //tricky line where some test cases are failing..
                }
                ListNode * add = new ListNode(sum);
                prev->next = add;
                prev = add;
                l2 = l2->next;
            }
            if(carry == true)
            {
                ListNode* add = new ListNode(1);
                prev->next = add;
                return temp;
            }
            else
                return temp;
        }
        
        
        return temp;
    }
};
