import java.util.*;

class Solution {
    public long fun(int i, int[] arr, Map<Integer, Integer> mp, long[] dp) {
        if (i >= arr.length) return 0;
        if (dp[i] != -1) return dp[i];

        // Pick current value
        long pick = (long) arr[i] * mp.get(arr[i]);

        int next = i + 1;
        // Skip all numbers that are consecutive to arr[i]
        while (next < arr.length &&( arr[next] == arr[i] + 2 || arr[next] == arr[i] + 1)) {
            next++;
        }

        pick += fun(next, arr, mp, dp);

        // Not pick current value
        long npick = fun(i + 1, arr, mp, dp);

        return dp[i] = Math.max(pick, npick);
    }

    public long maximumTotalDamage(int[] power) {
        Map<Integer, Integer> mp = new HashMap<>();
        for (int p : power) {
            mp.put(p, mp.getOrDefault(p, 0) + 1);
        }

        int[] arr = new int[mp.size()];
        int idx = 0;
        for (int k : mp.keySet()) arr[idx++] = k;
        Arrays.sort(arr);

        long[] dp = new long[arr.length];
        Arrays.fill(dp, -1);

        return fun(0, arr, mp, dp);
    }
}
