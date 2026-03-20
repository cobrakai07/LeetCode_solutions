class Solution {
    public int findMin(int[][] arr, int i, int j, int k){
        int min = Integer.MAX_VALUE;
        Set<Integer> set = new HashSet<>();
        for(int x = i;x<i+k && x<arr.length;x++){
            for(int y=j;y<j+k && y<arr[0].length;y++){
                set.add(arr[x][y]);
            }
        }
        List<Integer>list = new ArrayList<>(set);
        if(list.size()==1)return 0;
        Collections.sort(list);
        // System.out.println(list);
        for(int it=0;it<list.size()-1;it++){
            min = Math.min(min, Math.abs(list.get(it)- list.get(it+1)));
        }
        return min;
    }
    public int[][] minAbsDiff(int[][] grid, int k) {
        int row = grid.length-k+1;
        int col = grid[0].length-k+1;

        int[][] ans = new int[row][col];

        for(int i=0; i<row; i++){
            for(int j=0; j<col; j++){
                ans[i][j] = findMin(grid,i,j,k);
            }
        }

        return ans;

    }
}