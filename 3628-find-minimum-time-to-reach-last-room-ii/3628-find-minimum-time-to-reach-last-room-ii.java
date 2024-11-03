class Solution {
   
    public int minTimeToReach(int[][] moveTime) {
        int[][]vis= new int[moveTime.length][moveTime[0].length];
        // return fun(0,0,0,moveTime,vis);

        PriorityQueue<int[]>pq= new PriorityQueue<>((a,b)->a[2]-b[2]);
        pq.offer(new int[]{0,0,0,1});
        int [][]grid=moveTime;
        while(!pq.isEmpty()){
            int[]arr= pq.poll();
            int i=arr[0],j=arr[1], cost=arr[2];
            int alter=arr[3];

            if(vis[i][j]==1)continue;
            vis[i][j]=1;
            if(i==grid.length-1 && j== grid[0].length-1)return cost;
            if(i+1<grid.length){
                int ch = alter==1?2:1;
                if(cost<grid[i+1][j])
                pq.offer(new int[]{i+1,j,cost+alter+grid[i+1][j]-cost,ch});
                else
                pq.offer(new int[]{i+1,j,cost+alter,ch});
            }
            if(i-1>=0){
                int ch = alter==1?2:1;
                if(cost<grid[i-1][j])
                pq.offer(new int[]{i-1,j,cost+alter+grid[i-1][j]-cost,ch});
                else
                pq.offer(new int[]{i-1,j,cost+alter,ch});
            }
            if(j+1<grid[0].length){
                int ch = alter==1?2:1;
                if(cost<grid[i][j+1])
                pq.offer(new int[]{i,j+1,cost+alter+grid[i][j+1]-cost,ch});
                else
                pq.offer(new int[]{i,j+1,cost+alter,ch});
            }
            if(j-1>=0){
                int ch = alter==1?2:1;
                if(cost<grid[i][j-1])
                pq.offer(new int[]{i,j-1,cost+alter+grid[i][j-1]-cost,ch});
                else
                pq.offer(new int[]{i,j-1,cost+alter,ch});
            }
        }

        return -1;
    }
} 