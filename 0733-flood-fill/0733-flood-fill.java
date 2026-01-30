class Solution {
    int dirX[] = {0,0,1,-1};
    int dirY[] = {1,-1,0,0};
    public void dfs(int x, int y, int sr, int sc, int color,int initColor, int[][]arr, int [][]vis){
        if(vis[x][y]==1)return;
        vis[x][y]=1;
        arr[x][y] = color;
        for(int i=0;i<4;i++){
            int nx = x+dirX[i];
            int ny = y+dirY[i];
            if(nx>=0 && ny>=0 && nx < arr.length && ny< arr[0].length &&arr[nx][ny] ==initColor){
                   dfs(nx,ny,sr,sc, color,initColor, arr,vis); 
            }
        }
    }
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int [][]vis = new int[image.length][image[0].length];
        dfs(sr,sc,sr,sc,color,image[sr][sc],image,vis);
        return image;
    }
}