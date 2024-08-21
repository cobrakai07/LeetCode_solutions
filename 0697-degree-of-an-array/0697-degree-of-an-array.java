class Info{
    int sIdx;
    int eIdx;
    Info(int sIdx){
        this.sIdx=sIdx;
        this.eIdx=sIdx;
    }
    public void setLastIndex(int i){
        this.eIdx=i;
    }
    public String toString(){
        return this.sIdx+","+this.eIdx;
    }
}
class Solution {
    public int findShortestSubArray(int[] nums) {

        Map<Integer,Integer>mp=new HashMap<>();
        
        for(int i: nums){
            mp.put(i,mp.getOrDefault(i,0)+1);
        }
        int max=-1;
        for(int k: mp.keySet()){
            max=Math.max(max,mp.get(k));
        }

        
        Map<Integer,Info>map=new HashMap<>();

        for(int i=0; i<nums.length ;i++){
              
            if(map.get(nums[i])==null){
                Info info = new Info(i);
                map.put(nums[i],info);
            }else{
                Info info =map.get(nums[i]);
                info.setLastIndex(i);
                map.put(nums[i],info);
            }
            // System.out.println(map);
        }

        int min=Integer.MAX_VALUE;
      

        for(int key : mp.keySet()){
            if(max==mp.get(key)){
                Info info = map.get(key);
                min=Math.min(min, info.eIdx-info.sIdx+1);
            }
        }

        return min;
    }
}