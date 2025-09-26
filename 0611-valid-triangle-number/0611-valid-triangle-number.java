import java.util.*;

class Solution {
    public int binary_search(int i, int j, int[] arr) {
        int l = j + 1, h = arr.length - 1;
        int smallerThan = arr[i] + arr[j];
        int ans = -1;
        
        while (l <= h) {
            int m = l + (h - l) / 2;
            if (arr[m] < smallerThan) {
                ans = m;      // valid index
                l = m + 1;    // try to go further right
            } else {
                h = m - 1;
            }
        }
        return ans; // -1 if none found
    }

    public int triangleNumber(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        int ans = 0;

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int ub = binary_search(i, j, nums);
                if (ub != -1 && ub > j) {
                    ans += (ub - j); // all indices j+1..ub
                }
            }
        }
        return ans;
    }
}
