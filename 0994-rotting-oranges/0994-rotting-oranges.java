class Solution {

    public int orangesRotting(int[][] grid) {
        Queue<int[]> queue = new ArrayDeque<>();
        int freshOrange = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                int x = i, y = j;
                if (grid[x][y] == 2)
                    queue.offer(new int[] { x, y, 0});
                if (grid[x][y] == 1)
                    freshOrange++;
            }

        }

      
        int minTime = 0;
        int dirX[] = { 1, -1, 0, 0 };
        int dirY[] = { 0, 0, 1, -1 };

        while (!queue.isEmpty()) {
            int[] arr = queue.poll();
            int x = arr[0], y = arr[1], time = arr[2];
            minTime = Math.max(time, minTime);
            
            for (int i = 0; i < 4; i++) {
                int nx = x + dirX[i];
                int ny = y + dirY[i];

                if (nx >= 0 && ny >= 0 && nx < grid.length && ny < grid[0].length) {
                    if (grid[nx][ny] == 1 ) {
                        grid[nx][ny]=2;
                            freshOrange--;
                        queue.offer(new int[] { nx, ny, time + 1 });
                    }
                }
            }
        }
        System.out.println(freshOrange);
        return freshOrange == 0 ? minTime : -1;

    }
}