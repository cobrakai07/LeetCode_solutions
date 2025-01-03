class NumMatrix {
    int[][]arr;
    public NumMatrix(int[][] matrix) {
        arr= new int[matrix.length][matrix[0].length];
        for(int i=0;i<arr.length;i++){
            int sum=0;
            for(int j=0;j<arr[0].length;j++){
                sum+=matrix[i][j];
                arr[i][j]=sum;
            }
        }
        for(int i=0;i<arr[0].length;i++){
            int sum=0;
            for(int j=0;j<arr.length;j++){
                sum+=arr[j][i];
                arr[j][i]=sum;
            }
        }

        // for(int []a: arr)System.out.println(Arrays.toString(a));

    }
    
    public int sumRegion(int row1, int col1, int row2, int col2) {
        int doubleDeductionBalance = (row1-1>=0 && col1-1>=0) ? arr[row1-1][col1-1] : 0;
        int colSum= (col1-1>=0) ? arr[row2][col1-1] : 0;
        int rowSum= (row1-1>=0) ? arr[row1-1][col2] : 0;
        return arr[row2][col2] + doubleDeductionBalance - (colSum + rowSum);
    }
}

/**
 * Your NumMatrix object will be instantiated and called as such:
 * NumMatrix obj = new NumMatrix(matrix);
 * int param_1 = obj.sumRegion(row1,col1,row2,col2);
 */