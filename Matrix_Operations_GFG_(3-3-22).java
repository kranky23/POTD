class Solution
{
    static int [] endPoints(int [][]arr, int m, int n)
    {
        //code here
        int count = 0;
        int x = 0, y=0;
        
        boolean up = false, down = false, right = false, left = false;
        
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
