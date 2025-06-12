

class Solution {
    private final String target = "123450";
    private final int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}}; // Down, Up, Right, Left

    public int slidingPuzzle(int[][] board) {
        String start = boardToString(board);
        if (start.equals(target)) return 0;

        Queue<String> queue = new LinkedList<>();
        Set<String> visited = new HashSet<>();

        queue.offer(start);
        visited.add(start);

        int moves = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();
            moves++;

            for (int k = 0; k < size; k++) {
                String curr = queue.poll();
                int zeroIndex = curr.indexOf('0');
                int x = zeroIndex / 3, y = zeroIndex % 3;

                for (int[] dir : directions) {
                    int newX = x + dir[0];
                    int newY = y + dir[1];

                    if (newX >= 0 && newX < 2 && newY >= 0 && newY < 3) {
                        char[] next = curr.toCharArray();
                        int newIndex = newX * 3 + newY;

                        // Swap
                        char temp = next[zeroIndex];
                        next[zeroIndex] = next[newIndex];
                        next[newIndex] = temp;

                        String nextStr = new String(next);
                        if (nextStr.equals(target)) return moves;

                        if (!visited.contains(nextStr)) {
                            queue.offer(nextStr);
                            visited.add(nextStr);
                        }
                    }
                }
            }
        }

        return -1; // Not solvable
    }

    private String boardToString(int[][] board) {
        StringBuilder sb = new StringBuilder();
        for (int[] row : board) {
            for (int num : row) {
                sb.append(num);
            }
        }
        return sb.toString();
    }
}
