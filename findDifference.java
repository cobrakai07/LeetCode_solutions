class Solution {
    public List<List<Integer>> findDifference(int[] nums1, int[] nums2) {
         List<List<Integer>> ans=new ArrayList<>();
         List<Integer>list1=new ArrayList<>();
         List<Integer> list2=new ArrayList<>();
         HashMap<Integer,Integer>map1=new HashMap<>();
         HashMap<Integer,Integer>map2=new HashMap<>();

         for(int x: nums2)
         {
             map1.put(x,1);
         }

        for(int x: nums1)
        {
           if(!map1.containsKey(x)&&(!list1.contains(x)))
               list1.add(x);
            map2.put(x,1);
        }

        for(int x: nums2)
        {
            if(!map2.containsKey(x)&&(!list2.contains(x)))
               list2.add(x);
        }

        ans.add(list1);
        ans.add(list2);

        return ans;
    }
}
