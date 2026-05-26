class Solution {
    public int numberOfSpecialChars(String word) {
        Set<Character>s=new HashSet<>();
        Set<Character>S=new HashSet<>();
        for(char c: word.toCharArray())
        {
             int a=(int)c;
            if(a>=65&&a<=90)
                    s.add(c);
            else S.add(c);
        }
        int ans=0;
        // System.out.println(s);System.out.println(S);
        Iterator<Character>it=S.iterator();
        while(it.hasNext())
        {
            char ss=it.next();
            // System.out.println(ss);
            int cc=(int)+ss-32;
            char a=(char)cc;
            
            if(s.contains(a))ans++;
        }
        return ans;
    }
}