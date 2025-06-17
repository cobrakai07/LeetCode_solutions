class Solution {
    public int lb(int t, int [][]arr){
        int l=0,h=arr.length-1;
        int ans = -1;
        while(l<=h){
            int m = l+(h-l)/2;
            if(arr[m][arr[0].length-1]>=t){
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
            if(arr[m][0]==t){ return m;}
            if(arr[m][0]<t){
                ans = m;
                l=m+1;
            }else{
                h=m-1;
            }
        }
        return ans;
    }
    public boolean searchMatrix(int[][] matrix, int target) {
        int l = llb(target,matrix);
        int h = lb(target,matrix);
        // System.out.println(l+","+h);
        int idx = h;
        if(l!=h)return false;
         l =0; h = matrix[0].length-1;
        while(l<=h){
            int m = l+(h-l)/2;
            if(matrix[idx][m]==target)return true;
            if(matrix[idx][m]<target)l=m+1;
            else h=m-1;
        }
        return false;
    }
}