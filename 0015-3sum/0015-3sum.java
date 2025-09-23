class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(nums);

        int n = nums.length;
        int i = 0;
        int j = 0;
        int k = n - 1;

        while (i < n) {

            j = i + 1;
            k = n - 1;

            while (j < k && j < n) {
                if (nums[i] + nums[j] + nums[k] > 0)
                    k--;
                else if (nums[i] + nums[j] + nums[k] < 0)
                    j++;
                else {
                    ans.add(List.of(nums[i], nums[j], nums[k]));
                    int temp = nums[j];
                    while (j < n && nums[j] == temp)
                        j++;
                    temp = nums[k];
                    while (k >= 0 && nums[k] == temp)
                        k--;
                }
            }
            int temp = nums[i];
            while (i < n && nums[i] == temp)
                i++;
        }

        return ans;
    }
}