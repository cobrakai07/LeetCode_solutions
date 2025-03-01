class Solution {
    public int[] applyOperations(int[] nums) {
        int n = nums.length;
        for(int i=0; i<n-1 ;i++){
            if(nums[i] == nums[i+1]){
                nums[i]=nums[i]*2;
                nums[i+1]=0;
            }
        }

        int s1=0, s2=0;

        List<Integer>list= new ArrayList<>();
        for(int i:nums){
            if(i!=0)list.add(i);
        }

        int it=0;
        for(;it<list.size();it++)nums[it]=list.get(it);
        while(it<n){
            nums[it++]=0;
        }

        return nums;
    }
}