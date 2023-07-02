class Solution {
    public boolean containsDuplicate(int[] nums) {
        HashMap<Integer,Integer>map= new HashMap<>();
        for(int x: nums)
        {
            if(map.containsKey(x))
            return true;
            else
            map.put(x,1);
        }
        return false;
    }
}