class Solution {
    public int countHillValley(int[] nums) {
        int ans = 0;
        int n = nums.length;

        // Remove consecutive duplicates (they don't affect hills/valleys)
        List<Integer> arr = new ArrayList<>();
        arr.add(nums[0]);
        for (int i = 1; i < n; i++) {
            if (nums[i] != nums[i - 1]) {
                arr.add(nums[i]);
            }
        }

       
        for (int i = 1; i < arr.size() - 1; i++) {
            if (arr.get(i) > arr.get(i - 1) && arr.get(i) > arr.get(i + 1)) {
                ans++; // hill
            } else if (arr.get(i) < arr.get(i - 1) && arr.get(i) < arr.get(i + 1)) {
                ans++; // valley
            }
        }

        return ans;
    }
}
