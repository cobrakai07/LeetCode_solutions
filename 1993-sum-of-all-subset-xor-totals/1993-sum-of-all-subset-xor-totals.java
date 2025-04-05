class Solution {
    public void fun(int i, int[]nums, List<Integer>ds, List<List<Integer>>set)
    {
        if(i==nums.length)
        {
            set.add(new ArrayList<>(ds));
            return;
        }

        ds.add(nums[i]);
        fun(i+1,nums,ds,set);
        ds.remove(ds.size()-1);
        fun(i+1,nums,ds,set);
    }
    public int subsetXORSum(int[] nums) {
        List<List<Integer>>set=new ArrayList<>();
        fun(0,nums,new ArrayList<>(),set);
        // System.out.println(set);
        int ans=0;
        Iterator<List<Integer>>it=set.iterator();
        while(it.hasNext())
        {
            List<Integer>list=it.next();
            int xor=0;
            for(int i: list)
            {
                xor=xor^i;
            }
            ans=ans+xor;
        }
        return ans;
    }
}