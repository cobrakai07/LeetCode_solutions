class Solution {
    public int lowerBound(int[] nums, int val) {
        int l = 0, h = nums.length - 1;
        int ans = -1;
        while (l <= h) {
            int m = l + (h - l) / 2;
            if (nums[m] >= val) {
                ans = m;
                h = m - 1;
            } else {
                l = m + 1;
            }
        }
        return ans;
    }

    public int upperBound(int[] nums, int val) {
        int l = 0, h = nums.length - 1;
        int ans = -1;
        while (l <= h) {
            int m = l + (h - l) / 2;
            if (nums[m] <= val) {
                ans = m;
                l = m + 1;
            } else {
                h = m - 1;
            }
        }
        return ans;
    }
    public int maximumBeauty(int[] nums, int k) {
         Arrays.sort(nums);
        int n = nums.length;
        int ans = 1;

        // Frequency of each number
        // Map<Integer, Integer> freq = new HashMap<>();
        // for (int x : nums)
        //     freq.put(x, freq.getOrDefault(x, 0) + 1);

        int minVal = nums[0], maxVal = nums[n - 1];
       for (int m = minVal; m <= maxVal; m++) {
            int low = lowerBound(nums, m - k);
            int high = upperBound(nums, m + k);

            // Handle cases when nothing found
            if (low == -1 || high == -1) continue;

            int range = (high - low + 1);
            // int countM = freq.getOrDefault(m, 0);
            // int f = Math.min(range, numOperations + countM);

            ans = Math.max(ans, range);
        }

        return ans; 
    }
}