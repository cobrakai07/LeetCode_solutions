class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(nums);

        int i = 0, j = 0, k = 0, l = 0;
        int n = nums.length;

        while (i < n) {
            j = i + 1;
            
            while (j < n) {
                k = j + 1;
                l = n - 1;

                while (k < l) {
                    long sum = (nums[i]*1L) + nums[j] + nums[k] + nums[l];
                    if ( sum > target) {
                        l--;
                    } else if (sum < target) {
                        k++;
                    } else {
                        ans.add(List.of(nums[i], nums[j], nums[k], nums[l]));
                        int temp = nums[k];
                        while (k < n && nums[k] == temp)
                            k++;
                        temp = nums[l];
                        while (l >= 0 && nums[l] == temp)
                            l--;
                    }
                }
                int temp = nums[j];
                while (j < n && temp == nums[j])
                    j++;
            }

            int temp = nums[i];
            while (i < n && temp == nums[i])
                i++;
        }

        return ans;
    }
}