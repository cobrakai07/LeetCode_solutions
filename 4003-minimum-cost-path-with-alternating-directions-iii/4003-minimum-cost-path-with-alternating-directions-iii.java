class Solution {
    int dir[][]= {{0,1},{1,0},{0,-1},{-1,0}};
    public record Node(int x, int y, long cost, boolean isEven){}
    public long calculateCost(int i, int j){
        return 1L*(i+1)*(j+1);
    }
    
    public boolean isValid(int x, int y, int m, int n){
        if(x<0 || y<0 || x==m || y ==n)return false;
        else return true;
    }
    public long minCost(int m, int n, int[][] penalty) {

        long[][][] dis = new long[m][n][2];

        for(long[][] disSubArray: dis){
            for(long[] d: disSubArray)Arrays.fill(d,Long.MAX_VALUE);
        }

        PriorityQueue<Node> pq = new PriorityQueue<>((a,b)->Long.compare(a.cost(),b.cost()));
        pq.offer(new Node(0,0,calculateCost(0,0),false));

        Set<String> vis = new HashSet<>();

        while(!pq.isEmpty()){
            // System.out.println(pq);
            // System.out.println("-----");
            Node currNode = pq.poll();
            String str = currNode.x()+","+currNode.y()+","+currNode.isEven();
            if(vis.contains(str))continue;
            vis.add(str);
            long waitCost = penalty[currNode.x()][currNode.y()]+ currNode.cost();

            if(dis[currNode.x()][currNode.y()][currNode.isEven()?0:1]>waitCost ){
                pq.offer(new Node(currNode.x(),currNode.y(),waitCost, !currNode.isEven()));
            }

            if(!currNode.isEven()){
                for(int i=0;i<4;i++){
                    int nx = currNode.x()+dir[i][0];
                    int ny = currNode.y()+dir[i][1];
                    if(isValid(nx, ny, m,n)){
                        long costToMove = calculateCost(nx,ny) + currNode.cost();
                        if(i>=2)costToMove += penalty[currNode.x()][currNode.y()];
                        if(costToMove < dis[nx][ny][currNode.isEven()?0:1]){
                            dis[nx][ny][currNode.isEven()?0:1] = costToMove;
                            pq.offer(new Node(nx,ny,costToMove,!currNode.isEven()));
                        }
                    }
                }
     
            }else{
                for(int i=0;i<4;i++){
                    int nx = currNode.x()+dir[i][0];
                    int ny = currNode.y()+dir[i][1];
                    if(isValid(nx, ny, m,n)){
                        long costToMove = calculateCost(nx,ny) + currNode.cost();
                        if(i<2)costToMove += penalty[currNode.x()][currNode.y()];
                        if(costToMove < dis[nx][ny][currNode.isEven()?0:1]){
                            dis[nx][ny][currNode.isEven()?0:1] = costToMove;
                            pq.offer(new Node(nx,ny,costToMove,!currNode.isEven()));
                        }
                    }
                }

            }
        }

        return Math.min(dis[m-1][n-1][0],dis[m-1][n-1][1]);
    }
}