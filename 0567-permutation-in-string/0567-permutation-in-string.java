class Solution {
    public boolean fun(int idx1,int idx2,int sum,int[]hashArray,Map<Character,Integer>map, String s2)
    {
        while(idx1<=idx2)
        {
            if(hashArray[map.get(s2.charAt(idx1))]>0)
            {
                hashArray[map.get(s2.charAt(idx1))]-=1;
                sum--;
            } 
            idx1++;
        }

        if(sum==0)return true;
        else return false;
    }
    public boolean checkInclusion(String s1, String s2) {

        int[]hashArray=new int[26];
        Map<Character,Integer>map=new HashMap<>();

        int ascii=97;
        for(int i=0;i<26;i++,ascii++)
            map.put((char)ascii,i);

         for(int i=0;i<s1.length();i++)
            hashArray[map.get(s1.charAt(i))]+=1;

        int sum=0;
        for(int i=0;i<26;i++,ascii++)
             sum+=hashArray[i];
        
        int idx1=0;
        int idx2=s1.length()-1;

        

       for(int i=idx1,j=idx2;i<s2.length()&&j<s2.length();i++,j++)
       {
           int[] copiedArray = Arrays.copyOf(hashArray,26);
           if(fun(i,j,sum,copiedArray,map,s2))
           return true;
       }
        return false;


    }
}