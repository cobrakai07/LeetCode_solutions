class Solution {
 public int fun(int i, int cc, int cost, int[] d, int[] c ,int[][]dp) {
        if (i == d.length) {
            return 0;
        }

        if(dp[i][cc]!=-1)return dp[i][cc];

        int c1 = Integer.MAX_VALUE;
        int c2 = Integer.MAX_VALUE;
        int c3 = Integer.MAX_VALUE;

        c1 = c[0] + fun(i + 1, 0, cost + c[0], d, c ,dp);

        int maxDay = d[i] + 7;
        int j = i;
        while (j < d.length && d[j] < maxDay) {
            j++;
        }
        c2 = c[1] + fun(j, 1, cost + c[1], d, c ,dp);

        maxDay = d[i] + 30;
        j = i;
        while (j < d.length && d[j] < maxDay) {
            j++;
        }
        c3 = c[2] + fun(j, 2, cost + c[2], d, c, dp);

        return  dp[i][cc]=Math.min(c1, Math.min(c2, c3));
    }


    public int mincostTickets(int[] days, int[] costs) {
        int[][]dp=new int[days.length][4];
        for(int []i: dp)
            Arrays.fill(i,-1);
        return fun(0, 0, 0, days, costs,dp);
    }
}
