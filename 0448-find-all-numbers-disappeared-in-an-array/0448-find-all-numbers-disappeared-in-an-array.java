class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        int[]arr= new int[nums.length];
        List<Integer>list= new ArrayList<>();
        for(int i: nums){
            if(i-1>=nums.length)continue;
            else arr[i-1]++;
        }
        for(int i=0; i<arr.length;i++){
            if(arr[i]==0)list.add(i+1);
        }
        return list;
    }
}