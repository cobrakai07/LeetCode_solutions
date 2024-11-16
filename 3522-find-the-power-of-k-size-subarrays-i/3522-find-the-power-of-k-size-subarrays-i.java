class Solution {
    public int[] resultsArray(int[] nums, int k) {
        int ans[]=new int[nums.length-k+1];
        for(int i=0; i<ans.length;i++){
            int pre=nums[i];
            boolean flag=true;
            label: for(int j=i+1,c=1; c<k; j++,c++){
                if(pre>=nums[j] || (nums[j]-pre)!=1){
                    flag=false;
                    break label;
                }else{
                    pre=nums[j];
                }
            }
            if(flag)ans[i]=pre;
            else ans[i]=-1;
        }
        return ans;
    }
}