class Solution {
    public List<String> buildArray(int[] target, int n) {
        List<String>ans=new ArrayList<>();
        int idx=0;
        int num=1;
        while(idx<target.length&&num<=n)
        {
            if(target[idx]==num)
            {
                ans.add("Push");
                idx++;
            }
        
            else
            {
                ans.add("Push");
                ans.add("Pop");
            }

            num++;
        }
        return ans;
    }
}