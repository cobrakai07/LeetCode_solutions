class Solution {
    public boolean predictTheWinner(int[] nums) {
        return canWin(nums, 0, nums.length - 1, 0, 0, true);
    }
    
    private boolean canWin(int[] nums, int left, int right, int score1, int score2, boolean player1Turn) {
        if (left > right) {
            return score1 >= score2;
        }
        
        if (player1Turn) {
            return canWin(nums, left + 1, right, score1 + nums[left], score2, false) || 
                   canWin(nums, left, right - 1, score1 + nums[right], score2, false);
        } else {

            return canWin(nums, left + 1, right, score1, score2 + nums[left], true) &&
                   canWin(nums, left, right - 1, score1, score2 + nums[right], true);
        }
    }
}
