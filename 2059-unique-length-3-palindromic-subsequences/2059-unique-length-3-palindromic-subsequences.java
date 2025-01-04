class Solution {
    public int fun(String s,char ch)
    {
        int arr[]=new int[2];
        Arrays.fill(arr,-1);
        arr[0]=s.indexOf(ch);
        arr[1]=s.lastIndexOf(ch);
        if(arr[0]==-1||arr[1]==-1)return 0;
        Set<Character>set=new HashSet<>();
        for(int i=arr[0]+1;i<arr[1];i++)
            set.add(s.charAt(i));
        return set.size();
    }
    public int countPalindromicSubsequence(String s) {
        int ans=0;
        for(char ch='a';ch<='z';ch++)
            ans+=fun(s,ch);
        return ans;
    }
}