class Solution {
    public int repeatedStringMatch(String a, String b) {
        if(a.length()>b.length()){
            if(a.contains(b))return 1;
            String str=a+a;
            if(str.contains(b))return 2;
            return -1;
        }else if(a.length()==b.length()){
            String str=a;
            if(str.contains(b))return 1;
            str=str+a;
            if(str.contains(b))return 2;
            return -1;
        }

        String em="";
        int ans=0;
        while(em.length()<=b.length()+4){
            em=a+em;
            ans++;
             if(em.contains(b))return ans;
        }
        if(em.contains(b))return ans;
        return -1;


    }
}