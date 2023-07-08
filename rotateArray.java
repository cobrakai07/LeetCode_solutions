class Solution {
    public void rotate(int[] nums, int k) {
        int arotate= k%nums.length;
        if(arotate==0)return;

        
        int tail=nums.length-arotate;

        int idx=tail;
        ArrayList<Integer>list =new ArrayList<>();
        while(idx<nums.length)
        {
            list.add(nums[idx]);
            idx++;
        }
        int idx2=0;
        while(idx2<=tail)
        {
            list.add(nums[idx2]);
            idx2++;
        }
        for(int i=0;i<nums.length;i++)
        {
            nums[i]=list.get(i);
        }
    }
}
