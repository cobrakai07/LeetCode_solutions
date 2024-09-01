class Solution {
    public int[][] construct2DArray(int[] original, int m, int n) {
        if(m*n!=original.length)return new int[][]{};
        int[][]arr=new int[m][n];
        int idx=0;
        for(int i=0;i<arr.length; i++){
            for(int j=0; j<arr[0].length; j++){
                arr[i][j]=original[idx++];
            }
        }
        return arr;
    }
}