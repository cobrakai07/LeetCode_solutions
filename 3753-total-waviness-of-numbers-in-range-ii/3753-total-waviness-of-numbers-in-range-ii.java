class Solution {

    static class Node {
        long cnt;
        long wav;

        Node(long cnt, long wav) {
            this.cnt = cnt;
            this.wav = wav;
        }
    }

    String s;
    Node[][][][] dp;
    boolean[][][][] vis;

    private Node dfs(int pos, int started, int last, int secondLast, boolean tight) {

        if (pos == s.length()) {
            return new Node(1, 0);
        }

        if (!tight && vis[pos][started][last][secondLast]) {
            return dp[pos][started][last][secondLast];
        }

        int limit = tight ? s.charAt(pos) - '0' : 9;

        long totalCnt = 0;
        long totalWav = 0;

        for (int d = 0; d <= limit; d++) {

            boolean nextTight = tight && (d == limit);

            // Leading zeros
            if (started == 0 && d == 0) {

                Node next = dfs(pos + 1, 0, 10, 10, nextTight);

                totalCnt += next.cnt;
                totalWav += next.wav;
            } else {

                long add = 0;

                if (started == 1 && secondLast != 10) {

                    boolean isWave = (last > secondLast && last > d) ||
                            (last < secondLast && last < d);

                    if (isWave) {
                        add = 1;
                    }
                }

                int nextSecondLast = (started == 1) ? last : 10;

                Node next = dfs(pos + 1,1,d,nextSecondLast,nextTight);

                totalCnt += next.cnt;

                totalWav += next.wav + add * next.cnt;
            }
        }

        Node result = new Node(totalCnt, totalWav);

        if (!tight) {
            vis[pos][started][last][secondLast] = true;
            dp[pos][started][last][secondLast] = result;
        }

        return result;
    }

    private long solve(long n) {

        if (n < 0) {
            return 0;
        }

        s = Long.toString(n);

        dp = new Node[20][2][11][11];
        vis = new boolean[20][2][11][11];

        return dfs(0, 0, 10, 10, true).wav;
    }

    public long totalWaviness(long num1, long num2) {
        return solve(num2) - solve(num1 - 1);
    }
}