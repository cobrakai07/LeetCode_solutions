class Solution {
    public int missingInteger(int[] nums) {
        int max = 0;
        int sum = nums[0];
        int i = 1;
        int n = nums.length;

        if(n==1)return nums[0]+1;

        Set<Integer> set = new HashSet<>();
        for (int ii : nums)
            set.add(ii);

        

        int val = nums[i];
        while (i < n && val - 1 == nums[i - 1]) {
            i++;
            sum += val;
            if(i==n)break;
            val = nums[i];
        }

        while(true){
            if(!set.contains(sum))return sum;
            sum++;
        }


    }
}