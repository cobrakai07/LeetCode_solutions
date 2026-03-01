class Solution {
    public int minPartitions(String n) {
        int ans = 0;
        for(int i =0; i<n.length(); i++){
            char c = n.charAt(i);
            int num = c-'0';
            ans = Math.max(ans,num);
        }
        return ans;
    }
}