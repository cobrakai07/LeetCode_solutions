class Solution {
    
    public boolean cal(int n, int[] nums, int t) {
        int sum = 0;
        for (int i : nums) {
            sum += Math.ceil((double) i / n); 
            if (sum > t) return false; 
        }
        return true; 
    }

    public int smallestDivisor(int[] nums, int threshold) {
        int min = 1; 
        int max = 0;
        
        
        for (int i : nums) {
            max = Math.max(max, i);
        }


        int result = max; 
        while (min <= max) {
            int mid = min + (max - min) / 2;
            if (cal(mid, nums, threshold)) {
                result = mid; 
                max = mid - 1; 
            } else {
                min = mid + 1; 
            }
        }

        return result;
    }
}
