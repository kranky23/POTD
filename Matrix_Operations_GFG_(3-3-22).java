/*
Problem statement:

Given a binary matrix of dimensions N * M. One can perform the given operation in the matrix.

    If the value of matrix[i][j] is 0, then traverse in the same direction and check the next value.
    If the value of matrix[i][j] is 1, then update matrix[i][j] to 0 and change the current direction from up, right, down, or left to the directions right, down, left, and up respectively.

Initially you start from cell(0, 0), moving in right direction.

The task is to find the indices of the matrix  which leads to outside the matrix from the traversal of the given matrix from the cell (0, 0) by performing the operations.

Example 1:
Input: 
matrix[][] = {{0, 1, 1, 1, 0},
              {1, 0, 1, 0, 1},
              {1, 1, 1, 0, 0}}

Output: (2,0)
----------------------------------------
Example 2:
Input:
matrix[][] = {{0,1},
              {1,0}}

Output: (1,1)
*/

class Solution
{
    static int [] endPoints(int [][]arr, int m, int n)
    {
        //code here
        int count = 0;
        int x = 0, y=0;
        
        boolean up = false, down = false, right = false, left = false; //variables to keep track of the direction
        
        right = true;
        
        while(count < n*m)
        {
            if(x>=0 && x<m && y>=0 && y<n)  // checkikng if the indices crossed the borders
            {
                
                if(right)
                {
                    if(arr[x][y] == 1)
                    {
                        arr[x][y] = 0;
                        x++;
                        down = true;
                        right = false;
                        continue;
                    }
                    else
                    {
                        y++;
                        continue;
                    }
                }
                
                if(down)
                {
                    if(arr[x][y]==1)
                    {
                        arr[x][y] = 0;
                        y--;
                        left = true;
                        down = false;
                        continue;
                    }
                    else
                    {
                        x++;
                        continue;
                    }
                }
                
                if(left)
                {
                    if(arr[x][y] == 1)
                    {
                        arr[x][y] = 0;
                        x--;
                        up = true;
                        left = false;
                        continue;
                    }
                    else
                    {
                        y--;
                        continue;
                    }
                }
                
                if(up)
                {
                    if(arr[x][y] == 1)
                    {
                        arr[x][y] = 0;
                        y++;
                        right = true;
                        up = false;
                        continue;
                    }
                    else
                    {
                        x--;
                        continue;
                    }
                }
            }// if condition of checking borders end here..
            else
                break;
        }
        
        
        int res[] = new int[2]; // resultant array of coordinates
        
        /* tracing the value back to the coordinates that were the last visited
        value of the matrix */
        
        if(down)
            x--;
        if(up)
            x++;
        if(left)
            y++;
        if(right)
            y--;
        res[0] = x;
        res[1] = y;
        
        return res;
         
    }
}
