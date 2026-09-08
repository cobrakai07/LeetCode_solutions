class Solution {
    public int dc(int n){
        String s = String.valueOf(n);
        return s.length();
    }
    public int countCommas(int n) {
        int ans = 0;
        int len = dc(n);
        while(len>=4){
            int smallest = (int)Math.pow(10,len-1);
            ans = ans+(n-smallest+1);
            n = (int)Math.pow(10,len-1)-1;
            // System.out.println(n);
            len--;
        }
        return ans;
    }
}