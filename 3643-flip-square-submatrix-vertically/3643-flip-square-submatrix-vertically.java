class Solution {
    public void flip(int x, int y, int k, int[][]arr){
        for(int i1=x, i2=x+k-1;i1<i2;i1++,i2--){
            for(int j=y;j<y+k;j++){
                int temp = arr[i1][j];
                arr[i1][j] = arr[i2][j];
                arr[i2][j] = temp;
            }
        }
    }
    public int[][] reverseSubmatrix(int[][] grid, int x, int y, int k) {
        for(int i=0; i<grid.length; i++){
            for(int j=0;j<grid[0].length; j++){
                if(x==i && y==j){
                    flip(x,y,k,grid);
                    return grid;
                }
            }
        }
        return grid;
    }
}