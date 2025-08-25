class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        if (n == 0 || k == 0) return new int[0];

        int[] ans = new int[n - k + 1];  // number of windows
        int idx = 0;

        Deque<Integer> dq = new ArrayDeque<>(); // store indices

        for (int i = 0; i < n; i++) {
            // 1. Remove indices out of window
            if (!dq.isEmpty() && dq.peekFirst() <= i - k)
                dq.pollFirst();

            // 2. Maintain decreasing order in deque
            while (!dq.isEmpty() && nums[dq.peekLast()] <= nums[i])
                dq.pollLast();

            // 3. Add current index
            dq.offerLast(i);

            // 4. Record max for current window
            if (i >= k - 1)
                ans[idx++] = nums[dq.peekFirst()];
        }
        return ans;
    }
}
