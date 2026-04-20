

class Solution {
    public int[][] colorGrid(int n, int m, int[][] sources) {

        int[][] grid = new int[n][m];
        int[][] time = new int[n][m];

        for (int i = 0; i < n; i++) {
            Arrays.fill(time[i], Integer.MAX_VALUE);
        }

        Queue<int[]> q = new ArrayDeque<>();

     
        for (int[] s : sources) {
            int x = s[0], y = s[1], color = s[2];
            q.offer(new int[]{x, y});
            grid[x][y] = color;
            time[x][y] = 0;
        }

        int[] dx = {0, 0, -1, 1};
        int[] dy = {1, -1, 0, 0};

        while (!q.isEmpty()) {
            int[] curr = q.poll();
            int x = curr[0], y = curr[1];

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (nx < 0 || ny < 0 || nx >= n || ny >= m) continue;

              
                if (time[nx][ny] > time[x][y] + 1) {
                    time[nx][ny] = time[x][y] + 1;
                    grid[nx][ny] = grid[x][y];
                    q.offer(new int[]{nx, ny});
                }
                else if (time[nx][ny] == time[x][y] + 1) {
                    grid[nx][ny] = Math.max(grid[nx][ny], grid[x][y]);
                }
            }
        }

        return grid;
    }
}