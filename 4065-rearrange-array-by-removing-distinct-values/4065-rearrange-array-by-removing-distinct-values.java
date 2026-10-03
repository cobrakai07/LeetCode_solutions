class Solution {
    public int fill(TreeMap<Integer,Integer> map, int[]arr, int i){
        Set<Integer> toBeRemoved = new HashSet<>();
        for(int key: map.keySet()){
            arr[i++]=key;
            int val = map.get(key);
            if(val-1==0)toBeRemoved.add(key);
            map.put(key,val-1);
        }
        for(int item: toBeRemoved){
            map.remove(item);
        }
        return i;
    }
    public int[] rearrangeArray(int[] nums) {
        TreeMap<Integer,Integer> map = new TreeMap<>();
        for(int i: nums){
            map.put(i, map.getOrDefault(i,0)+1);
        }
        System.out.println(map);
        int [] ans = new int[nums.length];
        int idx = 0;
        while(idx<nums.length){
            idx = fill(map,ans,idx);
        }
        return ans;
    }
}