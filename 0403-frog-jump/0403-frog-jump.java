class Solution {
    Map<Integer, Integer> map = new HashMap<>();
    Boolean[][] dp;

    public boolean dfs(int idx, int lastJump, int[] stones) {
        if (idx == stones.length - 1)
            return true;

        if (dp[idx][lastJump] != null)
            return dp[idx][lastJump];

        for (int jump = lastJump - 1; jump <= lastJump + 1; jump++) {
            if (jump <= 0) continue;

            int nextPos = stones[idx] + jump;
            if (map.containsKey(nextPos)) {
                if (dfs(map.get(nextPos), jump, stones))
                    return dp[idx][lastJump] = true;
            }
        }

        return dp[idx][lastJump] = false;
    }

    public boolean canCross(int[] stones) {
        for (int i = 0; i < stones.length; i++)
            map.put(stones[i], i);

        dp = new Boolean[stones.length][stones.length + 1];
        return dfs(0, 0, stones);
    }
}
