class Solution {
     public int fun(int i, int mw, int[][] books, int[] dp) {
        if (i == books.length) {
            return 0;
        }

        if (dp[i] != -1) {
            return dp[i];
        }

        int maxHeight = 0;
        int currentWidth = 0;
        int minHeight = Integer.MAX_VALUE;

        for (int j = i; j < books.length; j++) {
            if (currentWidth + books[j][0] > mw) {
                break;
            }
            currentWidth += books[j][0];
            maxHeight = Math.max(maxHeight, books[j][1]);
            minHeight = Math.min(minHeight, maxHeight + fun(j + 1, mw, books, dp));
        }

        return dp[i] = minHeight;
    }

    public int minHeightShelves(int[][] books, int shelfWidth) {
        int[] dp = new int[books.length];
        Arrays.fill(dp, -1);
        return fun(0, shelfWidth, books, dp);
    }
}