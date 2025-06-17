class Solution {
    public int lb(int t, int [][]arr){
        int l=0,h=arr.length-1;
        int ans = -1;
        while(l<=h){
            int m = l+(h-l)/2;
            if(arr[arr.length-1][m]>=t){
                ans = m;
                h=m-1;
            }else{
                l=m+1;
            }
        }
        return ans;
    }
    public int llb(int t, int [][]arr){
        int l=0,h=arr.length-1;
        int ans = -1;
        while(l<=h){
            int m = l+(h-l)/2;
            if(arr[0][m]==t){ return m;}
            if(arr[0][m]<t){
                ans = m;
                l=m+1;
            }else{
                h=m-1;
            }
        }
        return ans;
    }
    public boolean bs(int idx,int target, int[][]matrix){
        // System.out.println(idx);
        int l=0, h=matrix[0].length-1;
        // if(l!=h)return false;
         l =0; h = matrix[0].length-1;
        while(l<=h){
            int m = l+(h-l)/2;
            if(matrix[idx][m]==target)return true;
            if(matrix[idx][m]<target)l=m+1;
            else h=m-1;
        }
        return false;
    }
    public boolean searchMatrix(int[][] matrix, int target) {
        int idx =0;
        while(idx<matrix.length){
            if(bs(idx,target,matrix))return true;
            idx++;
        }
        return false;
    }
}