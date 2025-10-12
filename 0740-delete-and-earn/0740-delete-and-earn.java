class Solution {
    public int deleteAndEarn(int[] nums) {
        Arrays.sort(nums);
        
        // Step 1: aggregate same numbers
        List<Integer> unique = new ArrayList<>();
        List<Integer> points = new ArrayList<>();
        int sum = nums[0], prev = nums[0];
        
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == prev) {
                sum += nums[i];
            } else {
                unique.add(prev);
                points.add(sum);
                prev = nums[i];
                sum = nums[i];
            }
        }

        unique.add(prev);
        points.add(sum);

                // System.out.println(unique);
        // System.out.println(points);
        
        // Step 2: memo array
        int n = unique.size();
        int[] dp = new int[n];
        Arrays.fill(dp, -1);
        
        // Step 3: recursive call
        return fun(0, n, unique, points, dp);
    }
    
    private int fun(int i, int n, List<Integer> unique, List<Integer> points, int[] dp) {
        if (i >= n) return 0;
        if (dp[i] != -1) return dp[i];
        
        // Option 1: skip current
        int notPick = fun(i + 1, n, unique, points, dp);
        
        // Option 2: pick current
        int next = i + 1;
        if (next < n && unique.get(next) == unique.get(i) + 1) {
            next++; // skip adjacent number
        }
        int pick = points.get(i) + fun(next, n, unique, points, dp);
        
        return dp[i] = Math.max(pick, notPick);
    }
}
