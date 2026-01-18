import java.util.Arrays;

class Solution {
    public void fun(int [][]g) {
        for(int []a: g) {
            System.out.println(Arrays.toString(a));
        }
        System.out.println();
    }
    
    public int largestMagicSquare(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        int[][] col = new int[n][m];
        int[][] row = new int[n][m];
        int[][] dag1 = new int[n][m];
        int[][] dag2 = new int[n][m];

        // Calculate row prefix sums
        for(int i = 0; i < n; i++) {
            int sum = 0;
            for(int j = 0; j < m; j++) {
                sum += grid[i][j];
                row[i][j] = sum;
            }
        }

        // Calculate column prefix sums
        for(int i = 0; i < m; i++) {
            int sum = 0;
            for(int j = 0; j < n; j++) {
                sum += grid[j][i];
                col[j][i] = sum;
            }
        }

        // Calculate main diagonal prefix sums
        for(int i = 0; i < m; i++) {
            int sum = 0;
            for(int j = 0, k = i; j < n && k < m; j++, k++) {
                sum += grid[j][k];
                dag1[j][k] = sum;
            }
        }
        
        for(int i = 1; i < n; i++) {
            int sum = 0;
            for(int j = i, k = 0; j < n && k < m; j++, k++) {
                sum += grid[j][k];
                dag1[j][k] = sum;
            }
        }

        // Calculate anti-diagonal prefix sums
        for(int i = m - 1; i >= 0; i--) {
            int sum = 0;
            for(int j = 0, k = i; j < n && k >= 0; j++, k--) {
                sum += grid[j][k];
                dag2[j][k] = sum;
            }
        }

        for(int i = 1; i < n; i++) {
            int sum = 0;
            for(int j = i, k = m - 1; j < n && k >= 0; j++, k--) {
                sum += grid[j][k];
                dag2[j][k] = sum;
            }
        }

        int maxK = 1;
        
        // Check every possible subgrid size k x k
        for (int k = 1; k <= Math.min(n, m); k++) {
            for (int i = k - 1; i < n; i++) {
                for (int j = k - 1; j < m; j++) {
                    int sum = row[i][j] - (j - k >= 0 ? row[i][j - k] : 0);
                    boolean isMagic = true;

                    // Check rows and columns
                    for (int p = 0; p < k; p++) {
                        if ((row[i - p][j] - (j - k >= 0 ? row[i - p][j - k] : 0)) != sum ||
                            (col[i][j - p] - (i - k >= 0 ? col[i - k][j - p] : 0)) != sum) {
                            isMagic = false;
                            break;
                        }
                    }

                    if (isMagic) {
                        // Check diagonals
                        int diag1Sum = dag1[i][j] - (i - k >= 0 && j - k >= 0 ? dag1[i - k][j - k] : 0);
                        int diag2Sum = dag2[i][j - k + 1] - (i - k >= 0 && j + 1 < m ? dag2[i - k][j + 1] : 0);
                        if (diag1Sum == sum && diag2Sum == sum) {
                            maxK = Math.max(maxK, k);
                        }
                    }
                }
            }
        }

        return maxK;
    }
}
