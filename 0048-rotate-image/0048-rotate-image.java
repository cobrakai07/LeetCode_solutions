class Solution {
    public void transpose(int [][]arr)
    {
        for(int i=0;i<arr.length;i++)
        {
            for(int j=i+1;j<arr.length;j++)
            {
                int temp=arr[j][i];
                arr[j][i]=arr[i][j];
                arr[i][j]=temp;
            }
        }
    }
    public void swapColumns(int[][]arr)
    {
        for(int i1=0,i2=arr.length-1;i1<i2;i1++,i2--)
        {
            for(int j1=0;j1<arr.length;j1++)
            {
                int temp=arr[j1][i1];
               arr[j1][i1]= arr[j1][i2];
                arr[j1][i2]=temp;
            }
        }
    }
    public void rotate(int[][] matrix) {
        transpose(matrix);
        swapColumns(matrix);
    }
}