class Solution {
    boolean isZero(int []nums, int[][] queries, int k){
        int diff[]= new int[nums.length];
        for(int i=0;i<=k;i++){
            int l=queries[i][0], r=queries[i][1], val=queries[i][2];
            diff[l]-=val;
            if(r+1<nums.length)
                diff[r+1]+=val;
        }
        for(int i=1;i<diff.length;i++){
            diff[i]=diff[i]+diff[i-1];
        }
        for(int i=0;i<nums.length;i++){
            if(nums[i]+diff[i]>0)return false;
        }
        return true;
    }
    int binarySearch(int []nums, int [][]queries){
        int ans = Integer.MAX_VALUE;
        int l=0, h=queries.length-1;
        while(l<=h){
            int m = l+(h-l)/2;
            // System.out.println(l+","+h+","+m);
            if(isZero(nums,queries,m)){
                ans = m;
                h=m-1;
            }else{
                l=m+1;
            }
        }
        return ans==Integer.MAX_VALUE?-1:ans+1;
    }
    public int minZeroArray(int[] nums, int[][] queries) {
        int sum =0;
        for(int i: nums)sum+=i;
        if(sum==0)return 0;
        return binarySearch(nums,queries);
    }
}