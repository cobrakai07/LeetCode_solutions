import java.util.*;

class Solution {
    static final int MAX = 1000000;  // adjust based on expected max nums[i]
    static int[] spf = computeSPF();

    // Precompute smallest prime factor (SPF) for every number up to MAX
    static int[] computeSPF() {
        int[] spf = new int[MAX + 1];
        for (int i = 2; i <= MAX; i++) {
            if (spf[i] == 0) {  // i is prime
                for (int j = i; j <= MAX; j += i) {
                    if (spf[j] == 0) spf[j] = i;
                }
            }
        }
        return spf;
    }

    public int minOperations(int[] nums) {
        int n = nums.length, min_operations = 0;
        for (int i = n - 2; i >= 0; i--) {
            while (nums[i] > nums[i + 1]) {
                int lpf = spf[nums[i]];
                if (lpf == nums[i]) return -1;  // prime, can't reduce further
                nums[i] = lpf;
                min_operations++;
            }
        }
        return min_operations;
    }
}
