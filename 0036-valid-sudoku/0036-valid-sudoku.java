class Solution {
    public boolean isValidSudoku(char[][] board) {
        Set<Character> set = new HashSet<>();

        // check rows
        for (int i = 0; i < 9; i++) {
            set.clear();
            for (int j = 0; j < 9; j++) {
                char c = board[i][j];
                if (c == '.') continue;
                if (set.contains(c)) return false;
                set.add(c);
            }
        }

        // check cols
        for (int i = 0; i < 9; i++) {
            set.clear();
            for (int j = 0; j < 9; j++) {
                char c = board[j][i];
                if (c == '.') continue;
                if (set.contains(c)) return false;
                set.add(c);
            }
        }

        // check 3x3 sub-boxes
        for (int boxRow = 0; boxRow < 9; boxRow += 3) {
            for (int boxCol = 0; boxCol < 9; boxCol += 3) {
                set.clear();
                for (int i = 0; i < 3; i++) {
                    for (int j = 0; j < 3; j++) {
                        char c = board[boxRow + i][boxCol + j];
                        if (c == '.') continue;
                        if (set.contains(c)) return false;
                        set.add(c);
                    }
                }
            }
        }

        return true;
    }
}
