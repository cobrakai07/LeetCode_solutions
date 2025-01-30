class Solution {
    public int orangesRotting(int[][] grid) {
        Queue<int[]>q= new ArrayDeque<>();
        int freshCount=0;
        for(int i=0;i<grid.length;i++){
            for(int j=0; j<grid[i].length; j++){
                if(grid[i][j]==2){
                    q.offer(new int[]{i,j,0});
                }else if(grid[i][j]==1){
                    freshCount++;
                }
            }
        }

        int []dirX={0,1,0,-1};
        int []dirY={1,0,-1,0};

        int totalTime=0;

        while(!q.isEmpty()){
            int[] arr = q.poll();
            int x=arr[0], y=arr[1], ct= arr[2];
            totalTime= Math.max(totalTime,ct);
            for(int i=0; i<4;i++){
                int nx= x+dirX[i];
                int ny= y+dirY[i];
                if(nx>=0 && nx<grid.length && ny>=0 && ny<grid[0].length){
                    if(grid[nx][ny]==1){
                        grid[nx][ny]=2;
                        q.offer(new int[]{nx,ny,ct+1});
                        freshCount--;
                    }
                }
            }
        }

        return freshCount==0?totalTime:-1;
    }
}