class Solution {
    public int[] leftRightDifference(int[] nums) {
        int n = nums.length;
        int[] pre = new int[n];
        int [] post = new int[n];
        for(int i=1;i<n;i++){
            pre[i]=pre[i-1]+nums[i-1];
        }
        for(int i=n-2;i>=0;i--){
            post[i]=post[i+1]+nums[i+1];
        }

        int [] ans = new int[n];
        for(int i=0;i<n;i++){
            ans[i]= Math.abs(pre[i]-post[i]);
        }
        // System.out.println(Arrays.toString(pre));
        //  System.out.println(Arrays.toString(post));
        return ans;
    }
}