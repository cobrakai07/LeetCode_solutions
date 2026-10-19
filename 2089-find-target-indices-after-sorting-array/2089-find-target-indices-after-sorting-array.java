class Solution {
    public int binarySearch(int [] nums, int target){
        int s = 0, e = nums.length-1;
        int idx = -1;
        while(s<=e){
            int m = s+(e-s)/2;
            if(nums[m]==target){
                idx = m;
                e = m-1;
            }
            if(nums[m]<target){
                s = m+1;
            }else{
                e = m-1;
            }
        }
        return idx;
    }
    public List<Integer> targetIndices(int[] nums, int target) {
        Arrays.sort(nums);
        
        int idx = binarySearch(nums,target);
        if(idx==-1 )return new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        while(idx<nums.length && nums[idx] == target){
            list.add(idx++);
        }

        return list;
    }
}