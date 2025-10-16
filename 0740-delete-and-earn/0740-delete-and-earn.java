class Solution {
    public int fun(int i, int[]arr, Map<Integer,Integer>mp, int[]dp){
        if(i>arr.length-1)return 0;
        if(dp[i]!=-1)return dp[i];
        int pick = 0, npick = 0;
        
        int nextIdx = i+1 < arr.length ?( arr[i]+1 == arr[i+1]? i+2 : i+1 ) : i+1;
        pick = arr[i]*mp.get(arr[i]) + fun(nextIdx,arr,mp,dp);
        npick = fun(i+1, arr, mp,dp);
        return dp[i] = Math.max(pick,npick);
    }
    public int deleteAndEarn(int[] nums) {
        Map<Integer,Integer>mp = new HashMap<>();
        int size=0;
        for(int i: nums){
            if(mp.get(i)==null)size++;
            mp.put(i, mp.getOrDefault(i,0)+1);
        }
        int[]arr = new int[size];
        int idx=0;
        for(int k: mp.keySet()){
            arr[idx++]=k;
        }
        Arrays.sort(arr);
        int[]dp= new int[arr.length];
        Arrays.fill(dp,-1);
        return fun(0,arr,mp,dp);

    }
}