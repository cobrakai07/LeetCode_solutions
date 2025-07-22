class Solution {
    public int maximumUniqueSubarray(int[] nums) {
        Set<Integer> set = new HashSet<>();
        int max = 0;
        int sum = 0;
        int i = 0, j = 0;
        while (j < nums.length) {
            // System.out.println(set+" before..");
            if (i == j) {
                sum = nums[i];
                set.add(nums[i]);
                j++;
            } else {
                if (set.contains(nums[j])) {
                    max = Math.max(max, sum);
                    while(i<j && set.contains(nums[j])){
                        set.remove(nums[i]);
                        sum=sum-nums[i];
                        i++;
                    }
                    sum += nums[j];
                    set.add(nums[j]);
                    j++;
                    // System.out.println(set+" after..loop");
                } else {
                    set.add(nums[j]);
                    sum += nums[j];
                    j++;
                }
            }
            // System.out.println(set+" after..");

        }
        max = Math.max(max, sum);
        return max;
    }
}