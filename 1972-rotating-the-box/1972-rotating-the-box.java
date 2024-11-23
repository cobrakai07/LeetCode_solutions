class Solution {
    public void flip(char[][] g) {
        int s = 0, e = g[0].length - 1;
        while (s < e) {
            for (int i = 0; i < g.length; i++) {
                char temp = g[i][s];
                g[i][s] = g[i][e];
                g[i][e] = temp;
            }
            
            s++;
            e--;
        }
    }

    public void fun(int sc, int[] i, char[][] g, boolean flag) {

        if (!flag) {
            g[i[0]][i[1]] = '*';
            int r = i[0] - 1, c = i[1];
            for (int ii = r; ii >= 0 && sc > 0; ii--, sc--) {
                g[ii][c] = '#';
            }
        } else {
            for (int ii = i[0]; ii >= 0 && sc > 0; ii--, sc--) {
                g[ii][i[1]] = '#';
            }
        }

    }

    public char[][] rotateTheBox(char[][] box) {

        char[][] g = new char[box[0].length][box.length];
        for (char[] a : g)
            Arrays.fill(a, '.');

        for (int i = 0; i < box.length; i++) {
            int stoneCount = 0;
            for (int j = 0; j < box[0].length; j++) {
                if (box[i][j] == '*')// obs
                {
                    int idx[] = { j, i };
                    fun(stoneCount, idx, g, false);
                    stoneCount = 0;
                } else if (box[i][j] == '#')// stone
                {
                    stoneCount++;
                }
            }
            if (stoneCount != 0)
                fun(stoneCount, new int[] { box[0].length - 1, i }, g, true);
        }
        flip(g);
        return g;
    }
}