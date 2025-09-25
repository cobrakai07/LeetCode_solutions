class Solution {
    public int fun(int rowIdx, int colIdx, List<List<Integer>> list,  int[][]dp){
        if(rowIdx==list.size())return 0;

        if(colIdx>=list.get(rowIdx).size())return 10001;

        if(dp[rowIdx][colIdx]!= Integer.MIN_VALUE)return dp[rowIdx][colIdx];
        
        int sumRowAdjacent = list.get(rowIdx).get(colIdx) + fun(rowIdx+1, colIdx+1, list, dp);
        int sumRowDown = list.get(rowIdx).get(colIdx) + fun(rowIdx+1, colIdx, list, dp);

        return dp[rowIdx][colIdx] = Math.min(sumRowAdjacent,sumRowDown);
    }
    public int minimumTotal(List<List<Integer>> triangle) {
        int[][]dp = new int[triangle.size()][triangle.size()];
        for(int i[]: dp)Arrays.fill(i,Integer.MIN_VALUE);
        return fun(0,0,triangle,dp);
    }
}