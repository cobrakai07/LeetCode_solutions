class Solution {

    private boolean checkPalindrome(int x) {
        String str = Integer.toString(x);
        return str.equals(new StringBuilder(str).reverse().toString());
    }

    private long add(int[] arr, int target) {
        long result = 0;
        for (int elem : arr) 
            result += Math.abs(elem - target);

        return result;
    }

    public long minimumCost(int[] nums) {
        Arrays.sort(nums);
        int midIndex = nums.length / 2;

        int mid;
        if (nums.length % 2 == 1) {
            mid = nums[midIndex];
            if (checkPalindrome(mid))
                return add(nums, mid);
        } 
        else {
            mid = (nums[midIndex] + nums[midIndex - 1]) / 2;
            if (checkPalindrome(mid))
                return add(nums, mid);
        }

        int p1 = mid + 1;
        int p2 = mid - 1;

        while (!(checkPalindrome(p1) && checkPalindrome(p2))) {
            if (!checkPalindrome(p1))
                p1++;
            if (!checkPalindrome(p2))
                p2--;
        }
        return Math.min(add(nums, p1), add(nums, p2));
    }
};