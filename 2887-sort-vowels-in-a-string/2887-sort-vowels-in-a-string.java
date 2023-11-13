class Solution {
    public String sortVowels(String s) {

        List<Character>list=new ArrayList<>();
        List<Integer>idx=new ArrayList<>();

        char[]str=s.toCharArray();
        for(int i=0;i<s.length();i++)
        {
            if(str[i]=='a'||str[i]=='e'||str[i]=='i'||str[i]=='o'||str[i]=='u'||str[i]=='A'||str[i]=='E'||str[i]=='I'||str[i]=='O'||str[i]=='U')
            {
                list.add(str[i]);
                idx.add(i);
            }
        }

        Collections.sort(list);
  
        
        for(int i=0;i<idx.size();i++)
        {
            str[idx.get(i)]=list.get(i);
        }

        return new String(str);

    }
}