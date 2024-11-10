
class Solution {
    public boolean checkValid(int[][] matrix) {
        int n = matrix.length;
        
        for (int i = 0; i < n; i++) {
            Set<Integer> rowSet = new HashSet<>();
            Set<Integer> colSet = new HashSet<>();
            
            for (int j = 0; j < n; j++) {
                rowSet.add(matrix[i][j]);
                colSet.add(matrix[j][i]);
            }
            
            if (rowSet.size() != n || colSet.size() != n) {
                return false;
            }
            
            for (int k = 1; k <= n; k++) {
                if (!rowSet.contains(k) || !colSet.contains(k)) {
                    return false;
                }
            }
        }
        
        return true;
    }
}
