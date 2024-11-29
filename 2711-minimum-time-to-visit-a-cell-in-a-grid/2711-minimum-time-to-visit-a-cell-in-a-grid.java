class Solution {
    public int minimumTime(int[][] grid) {
        if (grid[0][1] > 1 && grid[1][0] > 1) return -1;
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> Integer.compare(a[2], b[2]));
        pq.offer(new int[]{0, 0, 0}); // Start from (0, 0) at time 0

        int[][] vis = new int[grid.length][grid[0].length]; // Visited array

        int[] dir1 = {-1, 0, 1, 0};
        int[] dir2 = {0, 1, 0, -1};

        while (!pq.isEmpty()) {
            int[] arr = pq.poll();
            int x = arr[0], y = arr[1], currentTime = arr[2];

            // If reached the bottom-right cell
            if (x == grid.length - 1 && y == grid[0].length - 1) return currentTime;
            if (vis[x][y] == 1) continue;
            vis[x][y] = 1;

            for (int i = 0; i < 4; i++) {
                int nx = x + dir1[i];
                int ny = y + dir2[i];
                if ((nx >= 0 && nx < grid.length) && (ny >= 0 && ny < grid[0].length)) {
                    int nextTime = currentTime + 1; // Moving takes 1 second

                    if (nextTime < grid[nx][ny]) {
                        // Calculate wait time if the cell is not yet valid
                        int waitTime = (grid[nx][ny] - nextTime) % 2 == 0 ? 0 : 1;
                        nextTime = grid[nx][ny] + waitTime;
                    }

                    pq.offer(new int[]{nx, ny, nextTime});
                }
            }
        }
        return -1; // If target cell is unreachable
    }
}
