class Solution {
    public boolean canConstruct(String s, int k) {
        if(s.length()<k)return false;
        int[]hash=new int[26];
        for(char c: s.toCharArray())
        {
            hash[c-'a']++;
        }
        int count=0;
        for(int i: hash)
        {
            if(i%2!=0)count++;
        }
        if(count>k)return false;
        return true;
    }
}