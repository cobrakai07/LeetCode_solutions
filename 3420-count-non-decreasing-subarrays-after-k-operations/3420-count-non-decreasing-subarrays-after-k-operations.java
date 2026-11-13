
class Solution {
    public long countNonDecreasingSubarrays(int[] nums, int k) {
        int n = nums.length;
        long ans = 0;
        long cost = 0;

        // {height, count, sum}
        Deque<long[]> q = new ArrayDeque<>();

        int left = n - 1;

        for (int right = n - 1; right >= 0; right--) {

            long height = nums[right];
            long count = 1;
            long sum = nums[right];

            // Merge blocks whose height is <= current height
            while (!q.isEmpty() && q.peekFirst()[0] <= height) {
                long[] block = q.pollFirst();

                cost -= block[0] * block[1] - block[2];

                count += block[1];
                sum += block[2];
            }

            q.offerFirst(new long[]{height, count, sum});
            cost += height * count - sum;

            // Shrink the window from the left
            while (cost > k) {
                long[] block = q.peekLast();

                cost -= block[0] - nums[left];
                block[0] = Math.max(block[0], nums[left]);
                block[1]--;
                block[2] -= nums[left];

                if (block[1] == 0) {
                    q.pollLast();
                }

                left--;
            }

            ans += left - right + 1;
        }

        return ans;
    }
}
