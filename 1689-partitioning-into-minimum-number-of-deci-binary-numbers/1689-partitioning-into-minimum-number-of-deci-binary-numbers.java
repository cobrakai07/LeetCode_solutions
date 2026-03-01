class Solution {
    public int minPartitions(String n) {
        int ans = 0;
        for(char c : n.toCharArray()){
            int num = c-'0';
            ans = Math.max(ans,num);
        }
        return ans;
    }
}