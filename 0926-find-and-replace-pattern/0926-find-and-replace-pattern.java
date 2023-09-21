class Solution {
    public List<String> findAndReplacePattern(String[] words, String pattern) {
        List<String>ans= new ArrayList<>();
        for(int i=0;i<words.length;i++)
        {
            Map<Character,Character>map=new HashMap<>();
            boolean flag=true;
            String str=words[i];
            for(int j=0;j<words[i].length();j++)
            {
                if(map.get(str.charAt(j))==null)
                {
                    if(map.containsValue(pattern.charAt(j)))
                    {
                        flag=false;
                        break;
                    }
                    else
                    {
                        map.put(str.charAt(j),pattern.charAt(j));
                    }
                }
                else
                {
                   char chk= map.get(str.charAt(j));
                   if(chk!=pattern.charAt(j))
                   {
                        flag=false;
                        break;
                   }
                }
            }

            if(flag)
            {
                ans.add(words[i]);
            }

        }

        return ans;
    }
}