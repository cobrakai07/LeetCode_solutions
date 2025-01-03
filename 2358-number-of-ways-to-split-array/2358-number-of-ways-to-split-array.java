class Solution {
    public int waysToSplitArray(int[] nums) {
        long[] p = new long[nums.length];
        long sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum = sum + nums[i];
            p[i] = sum;
        }
        int ans = 0;
        long tsum = p[p.length - 1];
        for (int i = 0; i < p.length - 1; i++) {
            if (tsum - p[i] <= p[i]) {
                ans++;
                // System.out.println(i+" "+p[i]+">"+(tsum-p[i]));
            }

        }
        // System.out.println(Arrays.toString(p));
        return ans;
    }
}