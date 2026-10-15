class Solution {
    public int sumCounts(List<Integer> nums) {
        int ans = 0;
        int n = nums.size();
        for (int i = 0; i < n; i++) {

            for (int j = i; j < n; j++) {
                Set<Integer> set = new HashSet<>();
                int sum = 0;
                
                for (int k = i; k <= j; k++) {
                    set.add(nums.get(k));
                }
                ans = ans + set.size()*set.size();
            }

        }
        return ans;
    }
}