class Solution {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        Arrays.sort(nums);
        Map<String, List<Integer>> memo = new HashMap<>();
        return dfs(0, -1, nums, memo);
    }

    private List<Integer> dfs(int i, int prevIdx, int[] nums, Map<String, List<Integer>> memo) {
        if (i == nums.length) return new ArrayList<>();

        String key = i + "," + prevIdx;
        if (memo.containsKey(key)) return memo.get(key);

        List<Integer> notPick = dfs(i + 1, prevIdx, nums, memo);

        List<Integer> pick = new ArrayList<>();
        if (prevIdx == -1 || nums[i] % nums[prevIdx] == 0) {
            pick = new ArrayList<>(dfs(i + 1, i, nums, memo));
            pick.add(0, nums[i]);
        }

        List<Integer> result = pick.size() > notPick.size() ? pick : notPick;
        memo.put(key, result);
        return result;
    }
}
