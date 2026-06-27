class Solution {
    public int maximumLength(int[] nums) {

        Map<Long, Integer> map = new HashMap<>();
        int one = 0;
        for (int i : nums) {
            if(i==1)one++;
            map.put(i * 1L, map.getOrDefault(i*1L, 0) + 1);
        }

        one = one%2==0 && one!=0 ?one-1: one;
        int max = Math.max(one,1);

        for (long key : map.keySet()) {
            if (key == 1)
                continue;

            int curr = 0;
            while (map.get(key) != null) {
         
                long sq = 1L * key * key;

                if(map.get(key)<2){
                    curr++;
                    break ;
                }

                if(map.get(sq)!=null){
                    curr+=2;
                }else{
                    curr++;
                }
                
                key = sq;            
            }
            
            max = Math.max(max, curr);
        }

        return max;
    }
}