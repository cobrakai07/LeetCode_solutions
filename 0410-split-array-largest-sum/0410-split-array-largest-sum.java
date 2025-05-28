class Solution {
    public boolean canSplit(int largest, int[] nums, int k){
        int subArray = 1;
        int currSum = 0;
        for (int i : nums) {
            if (currSum + i > largest) {
                subArray++;
                currSum = i;
            } else {
                currSum += i;
            }
        }
        return subArray <= k;
    }

    public int splitArray(int[] nums, int k) {
        int sum = 0;
        int max = 0;
        for (int i : nums) {
            max = Math.max(max, i);
            sum += i;
        }
        int l = max, h = sum, ans = sum;
        while (l <= h) {
            int mid = l + (h - l) / 2;
            if (canSplit(mid, nums, k)) {
                ans = mid;
                h = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return ans;
    }
}
