class Solution {
    public List<Integer> intersection(int[][] nums) {

       List<Integer> list= new ArrayList<>();
       Map <Integer,Integer> map= new HashMap<>();

        for (int[] arr : nums)
         {
            for (int num : arr)
             {
               if(!map.containsKey(num))
                {
                    map.put(num,1);
                }
                else
                {
                    int x=map.get(num)+1;
                    map.put(num,x); 
                }
            }
        }
        
        for(int key: map.keySet())
        {
           if(map.get(key)==nums.length)
              list.add(key);
        }
        Collections.sort(list);
        return list;
    }
}
