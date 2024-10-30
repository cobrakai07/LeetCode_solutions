import java.util.Arrays;

class Solution {
    public int minimumMountainRemovals(int[] nums) {
        int n = nums.length;

        // Step 1: Calculate LIS for each position
        int[] lis = new int[n];
        Arrays.fill(lis, 1);
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    lis[i] = Math.max(lis[i], lis[j] + 1);
                }
            }
        }

        // Step 2: Calculate LDS for each position
        int[] lds = new int[n];
        Arrays.fill(lds, 1);
        for (int i = n - 2; i >= 0; i--) {
            for (int j = n - 1; j > i; j--) {
                if (nums[i] > nums[j]) {
                    lds[i] = Math.max(lds[i], lds[j] + 1);
                }
            }
        }

        // Step 3: Calculate minimum removals needed for a valid mountain
        int minRemovals = Integer.MAX_VALUE;
        for (int i = 1; i < n - 1; i++) {
            // A valid peak must have both lis[i] > 1 and lds[i] > 1
            if (lis[i] > 1 && lds[i] > 1) {
                int mountainLength = lis[i] + lds[i] - 1;
                minRemovals = Math.min(minRemovals, n - mountainLength);
            }
        }

        return minRemovals;
    }
}
