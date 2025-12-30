class Solution {
    public int diagonalSum(int i, int j, int[][] grid) {
        int sum1 = 0, sum2 = 0;
        int idx = j + 2;
        int x = i, y = j;
        int loop = 3;
        while (loop != 0) {
            sum1 = sum1 + grid[x][y];
            sum2 = sum2 + grid[x][idx];
            loop--;
            x++;
            y++;
            idx--;
        }
        return sum1 != sum2 ? -1 : sum1;

    }

   public boolean magic(int i, int j, int[][] grid) {
    int m = i + 2, n = j + 2;
    if (m >= grid.length || n >= grid[0].length)
        return false;

    int sum = diagonalSum(i, j, grid);
    if (sum == -1)
        return false;

    int[] vis = new int[10];

    // Rows
    for (int x = i; x <= m; x++) {
        int csum = 0;
        for (int y = j; y <= n; y++) {
            int val = grid[x][y];
            if (val < 1 || val > 9 || vis[val] == 1)
                return false;
            vis[val] = 1;
            csum += val;
        }
        if (csum != sum)
            return false;
    }

    // Columns
    for (int x = j; x <= n; x++) {
        int csum = 0;
        for (int y = i; y <= m; y++) {
            csum += grid[y][x];
        }
        if (csum != sum)
            return false;
    }

    return true;
}


    public int numMagicSquaresInside(int[][] grid) {
        int ans = 0;

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (magic(i, j, grid))
                    ans++;
            }
        }
        return ans;
    }
}