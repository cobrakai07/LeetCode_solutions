class Solution {
    public static final int MOD = 1_000_000_007;
    long[][][]dp;
    public long fun(int i, int tight, int sum, int min_sum, int max_sum, String s){
        if(i==s.length())
            return (sum>=min_sum && sum<=max_sum)?1:0;
        
        if(dp[i][tight][sum]!=-1)
            return dp[i][tight][sum];
        
        long ans=0;

        int limit = (tight==1)?s.charAt(i)-'0':9;

        for(int d=0; d<=limit; d++){
            int newTight = ((tight==1)&&(d==limit))?1:0;
            ans+=(fun(i+1, newTight, sum+d, min_sum, max_sum, s)%MOD);
        }
        return dp[i][tight][sum]= ans;
    }
    public int count(String num1, String num2, int min_sum, int max_sum) {
        dp=new long[23][2][207];
        for(long[][]a: dp){
            for(long []b: a)
                Arrays.fill(b,-1);
        }

        long countNum1= fun(0,1,0,min_sum,max_sum,num1+"");
        for(long[][]a: dp){
            for(long []b: a)
                Arrays.fill(b,-1);
        }
        long countNum2= fun(0,1,0,min_sum,max_sum,num2+"");

        int sum=0;
        for(var d : num1.toCharArray())sum+=(d-'0');
        if(sum>=min_sum && sum<=max_sum)countNum1--;

        return (int)(((countNum2-countNum1)%MOD)+MOD)%MOD;
    }
}