class Solution {
    public int maxScoreSightseeingPair(int[] values) {
        int maxValue = 0;
        int cur = 0;
        for(int i=0;i<values.length;i++) {
            maxValue = Math.max(maxValue,cur + values[i]);
            cur = Math.max(cur,values[i]) - 1;
        }
        return maxValue;
        
    }
}