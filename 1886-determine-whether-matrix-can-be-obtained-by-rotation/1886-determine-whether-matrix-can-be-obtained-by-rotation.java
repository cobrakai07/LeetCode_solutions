class Solution {
    public boolean transpose(int[][] arr, int[][] target){
        int n = arr.length;
        int[][] transpose = new int[n][n];
        boolean isEqual = true;
        for(int i=0;i<n;i++){
            for(int j=n-1,k=0;j>=0;j--,k++){
                transpose[i][k] = arr[j][i];
                if(transpose[i][k]!=target[i][k]){
                    isEqual = false;
                }
            }
        }


        if(isEqual)return true;
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                arr[i][j] = transpose[i][j];
            }
        }
        
        return isEqual;
    }
    public boolean findRotation(int[][] mat, int[][] target) {
        for(int i=0;i<4;i++){
            if(transpose(mat,target))return true;
        }
        return false;
    }
}