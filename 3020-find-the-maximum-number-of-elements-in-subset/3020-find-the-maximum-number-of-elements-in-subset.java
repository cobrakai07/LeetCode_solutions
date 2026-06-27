class Solution {
    public int maximumLength(int[] nums) {

        Map<Long, Integer> map = new HashMap<>();
        int one = 0;
        for (int i : nums) {
            if(i==1)one++;
            map.put(i * 1L, map.getOrDefault(i*1L, 0) + 1);
        }
        // System.out.println(map);
        one = one%2==0 && one!=0 ?one-1: one;
        int max = Math.max(one,1);

        for (long key : map.keySet()) {
            if (key == 1)
                continue;
            ///////////
            boolean flag = true;
            boolean addOne = false;
            int curr = 0;
            while (map.get(key) != null) {
                // System.out.println(key + " --X," + curr);
                long sq = 1L * key * key;

                if(map.get(key)<2){
                    // System.out.println("--cree-");
                    curr++;
                    break ;
                }

                if(map.get(sq)!=null){
                    curr+=2;
                }else{
                    curr++;
                }
                
                key = sq;
                // System.out.println(key + " --XX," + curr+"---");
                
            }
            // System.out.println(curr + "--,,-");
            
            max = Math.max(max, curr);
        }

        return max;
    }
}