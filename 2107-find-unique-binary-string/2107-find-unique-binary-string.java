class Solution {
    String ans="";
    private void fun(int idx,HashSet<String>set,char[]arr)
    {
        if(idx==arr.length)
        {
            if(!set.contains(new String(arr)))
              ans=new String(arr);
            return;
        }

        arr[idx]='1';
        fun(idx+1,set,arr);
        arr[idx]='0';
        fun(idx+1,set,arr); 
    }
    public String findDifferentBinaryString(String[] nums) {
        char arr[]=new char[nums.length];
        HashSet<String>set=new HashSet<>();
        for(String s: nums)
            set.add(s);
        fun(0,set,arr);
        return ans;
    }
}
