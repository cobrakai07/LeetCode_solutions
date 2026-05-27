class Solution {
    public int numberOfSpecialChars(String word) {
       Map<Character,Integer>mp=new HashMap<>();
        Map<Character,Integer>mp1=new HashMap<>();
        Set<Character>s=new HashSet<>();
        char[] cr= word.toCharArray();
        for(int i=0;i<cr.length;i++)
        {
            int a=(int)cr[i];
            if(a>=65&&a<=90)
            {
                if(mp.get(cr[i])==null)
                     mp.put(cr[i],i);  
                
            }            
        }
        // System.out.println(mp);
        
        // int[]ans=new int[26];
        
         for(int i=0;i<cr.length;i++)
         {
              int a=(int)cr[i];
            if(a>=97&&a<=122)
            {
                if(mp1.get(cr[i]-32)!=null)
                     mp1.put(cr[i],i); 
                else
                    mp1.put(cr[i],i);
                
            }  
         }
        // System.out.println(mp);
        // System.out.println(mp1);
        int ans=0;
        for(char c: mp.keySet())
        {
            int as=(int)c+32;
            char nk=(char)as;
            
            if(mp1.get(nk)!=null&&mp1.get(nk)<mp.get(c)){
                ans++;
                // System.out.println(mp1.get(nk)+"<"+mp.get(c));
            }
        }
        return ans;
    }
}
