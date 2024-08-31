
record Pair(int x, int y, int op){}

class Solution {
    public int minCost(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        boolean[][] vis = new boolean[m][n];
        
        // Direction arrays corresponding to right, left, down, up
        int[][] DIRS = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        
        // Priority queue to always process the cell with the least cost first
        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> a.op() - b.op());
        pq.offer(new Pair(0, 0, 0));
        
        while (!pq.isEmpty()) {
            Pair p = pq.poll();
            int i = p.x();
            int j = p.y();
            int op = p.op();
            
            // If we've reached the bottom-right cell, return the cost
            if (i == m - 1 && j == n - 1) return op;
            
            // If the cell is already visited, skip processing
            if (vis[i][j]) continue;
            vis[i][j] = true;
            
            // Process all 4 possible directions
            for (int d = 0; d < 4; d++) {
                int ni = i + DIRS[d][0], nj = j + DIRS[d][1];
                
                // Check bounds
                if (ni >= 0 && ni < m && nj >= 0 && nj < n) {
                    // If moving in the current direction, no extra cost
                    if (grid[i][j] == d + 1) {
                        pq.offer(new Pair(ni, nj, op));
                    } else { // Otherwise, add 1 to the cost
                        pq.offer(new Pair(ni, nj, op + 1));
                    }
                }
            }
        }
        
        return -1; // Should never reach here since there's always a path to the bottom-right corner
    }
}
