class Pair{
    char c;
    int f;
    Pair(char c,int f){
        this.f=f;
        this.c=c;
    }
}
class Solution {
    public int minimumPushes(String word) {

        int[]h=new int[26];

        for(char c: word.toCharArray())
            h[c-'a']++;
        
        List<Pair>list=new ArrayList<>();

        for(int i=0;i<26;i++){
            if(h[i]!=0){
                char asci=(char)(i+97);
                list.add(new Pair(asci,h[i]));
            }
        }

        Collections.sort(list,(a,b)->b.f-a.f);

        int[]arr={2,3,4,5,6,7,8,9};
        int idx=0;
        int m=0;
        int turn=1;
        while(idx<list.size()){
            
            for(int i=0;i<arr.length && idx<list.size() ;i++,idx++){
                m=m+(list.get(idx).f*turn);
            }
            turn ++;
        }
        return m;
        

    }
}