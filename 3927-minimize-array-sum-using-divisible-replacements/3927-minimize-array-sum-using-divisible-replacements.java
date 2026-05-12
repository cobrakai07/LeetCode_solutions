class Solution {
    public long minArraySum(int[] nums) {

        int MAX = 100000;

        boolean[] present = new boolean[MAX + 1];

        for (int x : nums) {
            present[x] = true;
        }

      
        int[] best = new int[MAX + 1];

        for (int d = 1; d <= MAX; d++) {

            if (!present[d]) continue;

            for (int multiple = d; multiple <= MAX; multiple += d) {

                if (best[multiple] == 0) {
                    best[multiple] = d;
                }
            }
        }

        long ans = 0;

        for (int x : nums) {
            ans += best[x];
        }

        return ans;
    }
}