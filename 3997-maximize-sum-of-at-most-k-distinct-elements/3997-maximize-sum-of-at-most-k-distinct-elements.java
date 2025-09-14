class Solution {
    public int[] maxKDistinct(int[] nums, int k) {
        Set<Integer>set = new HashSet<>();
        for(int i: nums)set.add(i);
        List<Integer>list = new ArrayList<>(set);
        List<Integer>ansl = new ArrayList<>();
        Collections.sort(list);
        // int ans[]= new int[k];
        for(int i=list.size()-1,j=0;k>0&&i>=0;i--,k--)
            ansl.add(list.get(i));
        int ans []= new int[ansl.size()];
        for(int i=0;i<ansl.size();i++)
            ans[i]=ansl.get(i);
        return ans;
    }
}