class Solution {
    public static final int MOD = 1_000_000_007;
    public int makeStableArray(int one, int zero, int lastUsed, int reset, int limit, int[][][][]dp){
        if(one<0 || zero<0){
            return 0;
        }
        if(one == 0 && zero == 0){
            return 1;
        }

        if(dp[one][zero][lastUsed+1][reset]!=-1)return dp[one][zero][lastUsed+1][reset];

        int addOne = 0;
        int addZero = 0;

        if(reset!=limit){
            if(lastUsed==-1){
                 addOne = makeStableArray(one-1,zero,1,reset+1,limit,dp);
                 addZero = makeStableArray(one,zero-1,0,reset+1,limit,dp);
            }else{
                if(lastUsed==1){
                     addOne = makeStableArray(one-1,zero,lastUsed,reset+1,limit,dp);
                     addZero = makeStableArray(one,zero-1,0,1,limit,dp);
                }else{
                     addOne = makeStableArray(one-1,zero,1,1,limit,dp);
                     addZero = makeStableArray(one,zero-1,lastUsed,reset+1,limit,dp);
                }
            }
            
        }else{
           if(lastUsed==1){
                     addZero = makeStableArray(one,zero-1,0,1,limit,dp);
            }else{
                     addOne = makeStableArray(one-1,zero,1,1,limit,dp);
            }
        }
        

        return dp[one][zero][lastUsed+1][reset] = (addZero + addOne)%MOD;
    }
    public int numberOfStableArrays(int zero, int one, int limit) {

        int[][][][]dp = new int[one+1][zero+1][3][limit+1];
        for(int [][][]a: dp){
            for(int[][]b: a){
                for(int []c: b){
                    Arrays.fill(c,-1);
                }
            }
        }
        return makeStableArray(one,zero,-1,0,limit,dp);
    }
}