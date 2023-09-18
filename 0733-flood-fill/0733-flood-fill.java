class Solution {
    public void dfs(int idx,int idy,int [][]arr,int c,int s){
        
        if(arr[idx][idy]==c)return;

        arr[idx][idy]=c;

        if((idx+1<arr.length)&&(arr[idx+1][idy]==s))//down
            dfs(idx+1,idy,arr,c,s);
        if((idx-1>=0&&idy>=0)&&(arr[idx-1][idy]==s))//up
            dfs(idx-1,idy,arr,c,s);
        if((idy+1<arr[idx].length)&&(arr[idx][idy+1]==s))//right
            dfs(idx,idy+1,arr,c,s);
        if((idy-1>=0)&&(arr[idx][idy-1]==s))//left
            dfs(idx,idy-1,arr,c,s);

    }
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        dfs(sr,sc,image,color,image[sr][sc]);
        return image;
    }
}