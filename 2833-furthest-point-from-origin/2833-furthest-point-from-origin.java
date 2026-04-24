class Solution {
    public int dis(int x, int y, int i, char[] arr,int[][][] dp){
        if(i==arr.length)return (int)Math.sqrt((x*x)+(y*y));
        if(dp[x+50][y+50][i]!=-1)return dp[x+50][y+50][i];
        char c = arr[i];
        int maxdis = 0;
        if(c=='L'){
            maxdis = dis(x,y-1,i+1,arr,dp);
        }else if(c=='R'){
            maxdis = dis(x,y+1,i+1,arr,dp);
        }else{
            maxdis = Math.max(dis(x,y-1,i+1,arr,dp),dis(x,y+1,i+1,arr,dp));
        }
        return dp[x+50][y+50][i] = maxdis;
    }
    public int furthestDistanceFromOrigin(String moves) {
        int[][][] dp = new int[100][100][50];
        for(int [][]a: dp){
            for(int []b: a){
                Arrays.fill(b,-1);
            }
        }
        return dis(0,0,0,moves.toCharArray(),dp);
    }
}