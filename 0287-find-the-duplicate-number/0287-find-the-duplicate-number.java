class Solution {
    public int findDuplicate(int[] nums) {
        Map<Integer,Integer>map=new HashMap<>();
        for(int key: nums)
        {
            if(map.get(key)==null)map.put(key,1);
            else return key;
        }
        return -1;
    }
}