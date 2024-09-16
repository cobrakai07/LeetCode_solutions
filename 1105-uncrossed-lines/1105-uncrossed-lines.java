class Solution {
    public int fun(int i, int j, int[] nums1, int[] nums2, int[][] dp) {
        // System.out.println(i + " " + j);
        if (i == nums1.length || j == nums2.length)
            return 0;
        if (dp[i][j] != -1)
            return dp[i][j];
        int pick = Integer.MIN_VALUE;
        int notPickOne = pick;
        int notPickTwo = pick;
        int skipBoth = pick;

        if (nums1[i] == nums2[j]) {
            pick = 1 + fun(i + 1, j + 1, nums1, nums2, dp);
        }
        notPickOne = fun(i, j + 1, nums1, nums2, dp);
        notPickTwo = fun(i + 1, j, nums1, nums2, dp);
        skipBoth = fun(i + 1, j + 1, nums1, nums2, dp);

        return dp[i][j] = Math.max(skipBoth, Math.max(pick, Math.max(notPickOne, notPickTwo)));
    }

    public int maxUncrossedLines(int[] nums1, int[] nums2) {
        int[][] dp = new int[nums1.length+1][nums2.length+1];
        for (int a[] : dp)
            Arrays.fill(a, -1);
        // return fun(0, 0, nums1, nums2, dp);
        for(int i=nums1.length, j=0;j<dp[0].length;j++){
            dp[i][j]=0;
        }
        for(int i=nums2.length, j=0;j<dp.length;j++){
            dp[j][i]=0;
        }
        for (int i = nums1.length - 1; i >= 0; i--) {
            for (int j = nums2.length - 1; j >= 0; j--) {

                // if (i == nums1.length || j == nums2.length)
                //     return 0;
                if (dp[i][j] != -1)
                        continue;
                int pick = Integer.MIN_VALUE;
                int notPickOne = pick;
                int notPickTwo = pick;
                int skipBoth = pick;

                if (nums1[i] == nums2[j]) {
                    pick = 1 + dp[i + 1][ j + 1];
                }
                notPickOne =  dp[i][ j + 1];
                notPickTwo =  dp[i + 1][ j ];
                skipBoth =  dp[i + 1][ j + 1];

              dp[i][j] = Math.max(skipBoth, Math.max(pick, Math.max(notPickOne, notPickTwo)));

            }
        }

        return dp[0][0];
    }
}