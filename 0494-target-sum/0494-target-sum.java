class Solution {
    public int fun(int i, int t, int s, int []arr){
        if(i==arr.length){
            if(t==s)return 1;
            else return 0;
        }

        int pos=fun(i+1, t-arr[i], s,arr);
        int neg=fun(i+1, t+arr[i], s,arr);

        return pos+neg;


    }
    public int findTargetSumWays(int[] nums, int target) {
        return fun(0,0,target,nums);
    }
}