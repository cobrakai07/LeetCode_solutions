class Solution {
    public int minFlips(int[][] grid) {
        int  rf=0;
        
        for(int i=0; i<grid.length ; i++){
            for(int j1=0, j2=grid[i].length-1; j1<j2; j1++,j2--){
                if(grid[i][j1]!=grid[i][j2]){
                    rf++;
                }
            }
        }

        int cf=0;

        for(int i=0; i<grid[0].length ; i++){
            for(int j1=0, j2=grid.length-1; j1<j2; j1++,j2--){
                if(grid[j1][i]!=grid[j2][i]){
                    cf++;
                }
            }
        }

        return Math.min(rf,cf);
    }
}