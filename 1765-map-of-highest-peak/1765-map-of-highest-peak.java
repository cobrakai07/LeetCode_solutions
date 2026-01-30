class Solution {
    public int[][] bfs(int[][] arr) {

        int[] dirX = { 0, 0, -1, 1 };
        int[] dirY = { 1, -1, 0, 0 };

        Queue<int[]> queue = new ArrayDeque<>();
        int[][] ans = new int[arr.length][arr[0].length];
        boolean[][] vis = new boolean[arr.length][arr[0].length];

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                if (arr[i][j] == 1)
                    queue.offer(new int[] { i, j, 0 });
            }
        }

        while (!queue.isEmpty()) {

            int[] node = queue.poll();

            int x = node[0], y = node[1], level = node[2];

            
            if(vis[x][y])continue;
            vis[x][y] = true;
            ans[x][y] = level;

            for (int i = 0; i < 4; i++) {
                int nx = x + dirX[i];
                int ny = y + dirY[i];
                if (nx >= 0 && ny >= 0 && nx < arr.length && ny < arr[0].length) {
                    queue.offer(new int[] { nx, ny, level + 1 });
                }
            }
        }

        return ans;

    }

    public int[][] highestPeak(int[][] isWater) {
        return bfs(isWater);
    }
}