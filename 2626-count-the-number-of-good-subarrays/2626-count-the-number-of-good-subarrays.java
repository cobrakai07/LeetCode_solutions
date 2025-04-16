class Solution {
    public long countGood(int[] nums, int k) {
        Map<Integer, Integer> freq = new HashMap<>();
        long ans = 0;
        long pairs = 0;
        int left = 0;

        for (int right = 0; right < nums.length; right++) {
            int count = freq.getOrDefault(nums[right], 0);
            pairs += count; // Add the number of new pairs formed with nums[right]
            freq.put(nums[right], count + 1);

            while (pairs >= k) {
                ans += nums.length - right; // All subarrays from [left...right] to [left...end] are good
                int leftCount = freq.get(nums[left]);
                pairs -= leftCount - 1; // Remove pairs involving nums[left]
                freq.put(nums[left], leftCount - 1);
                left++;
            }
        }

        return ans;
    }
}
