class Solution {
    public boolean fun(int nx, int ny, int px, int py, int[][]vis, char[][]grid){
        vis[nx][ny]=1;
        if(nx-1>=0 && grid[nx-1][ny]==grid[nx][ny]){
            if(vis[nx-1][ny]==0){
                if(fun(nx-1,ny,nx,ny,vis,grid))return true;
            }else if(nx-1!=px && ny!=py){
                return true;
            }
        }
        if(nx+1<grid.length&& grid[nx+1][ny]==grid[nx][ny]){
            if(vis[nx+1][ny]==0){
                if(fun(nx+1,ny,nx,ny,vis,grid))return true;
            }else if(nx+1!=px && ny!=py){
                return true;
            }
        }
        if(ny-1>=0 && grid[nx][ny-1]==grid[nx][ny]){
            if(vis[nx][ny-1]==0){
                if(fun(nx,ny-1,nx,ny,vis,grid))return true;
            }else if(nx!=px && ny-1!=py){
                return true;
            }
        }
        if(ny+1<grid[0].length && grid[nx][ny+1]==grid[nx][ny]){
            if(vis[nx][ny+1]==0){
                if(fun(nx,ny+1,nx,ny,vis,grid))return true;
            }else if(nx!=px && ny+1!=py){
                return true;
            }
        }
        return false;

    }
    public boolean containsCycle(char[][] grid) {
        int[][]vis= new int[grid.length][grid[0].length];
        
        for(int i=0;i<vis.length;i++){
            for(int j=0;j<vis[0].length;j++){
                if(vis[i][j]==0 && fun(i,j,-1,-1,vis,grid))return true;
            }
        }
        return false;
    }
}