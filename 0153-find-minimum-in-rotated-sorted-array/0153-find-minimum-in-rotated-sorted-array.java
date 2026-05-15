class Solution {
    public int findMin(int[] nums) {
        int low = 0;
        int high = nums.length - 1;

        while (low < high) {
            int mid = low + (high - low) / 2;

            if (nums[mid] > nums[high]) {
                // minimum is on right side
                low = mid + 1;
            } else {
                // minimum could be mid or left side
                high = mid;
            }
        }

        return nums[low];
    }
}