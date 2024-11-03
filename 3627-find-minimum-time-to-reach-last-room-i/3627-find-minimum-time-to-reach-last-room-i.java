class Solution {
   
    public int minTimeToReach(int[][] moveTime) {
        int[][]vis= new int[moveTime.length][moveTime[0].length];
        // return fun(0,0,0,moveTime,vis);

        PriorityQueue<int[]>pq= new PriorityQueue<>((a,b)->a[2]-b[2]);
        pq.offer(new int[]{0,0,0});
        int [][]grid=moveTime;
        while(!pq.isEmpty()){
            int[]arr= pq.poll();
            int i=arr[0],j=arr[1], cost=arr[2];

            if(vis[i][j]==1)continue;
            vis[i][j]=1;
            if(i==grid.length-1 && j== grid[0].length-1)return cost;
            if(i+1<grid.length){
                if(cost<grid[i+1][j])
                pq.offer(new int[]{i+1,j,cost+1+grid[i+1][j]-cost});
                else
                pq.offer(new int[]{i+1,j,cost+1});
            }
            if(i-1>=0){
                if(cost<grid[i-1][j])
                pq.offer(new int[]{i-1,j,cost+1+grid[i-1][j]-cost});
                else
                pq.offer(new int[]{i-1,j,cost+1});
            }
            if(j+1<grid[0].length){
                if(cost<grid[i][j+1])
                pq.offer(new int[]{i,j+1,cost+1+grid[i][j+1]-cost});
                else
                pq.offer(new int[]{i,j+1,cost+1});
            }
            if(j-1>=0){
                if(cost<grid[i][j-1])
                pq.offer(new int[]{i,j-1,cost+1+grid[i][j-1]-cost});
                else
                pq.offer(new int[]{i,j-1,cost+1});
            }
        }

        return -1;
    }
}