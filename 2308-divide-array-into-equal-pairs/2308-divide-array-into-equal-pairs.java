class Solution {
    public boolean divideArray(int[] nums) {
        if(nums.length%2!=0)return false;
        int []hash = new int[501];
        for(int i: nums){
            hash[i]++;
        }
        for(int i=0; i<501; i++){
            if(hash[i]%2!=0)return false;
        }
        return true;

    }
}