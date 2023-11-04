class Solution {
    public int getLastMoment(int n, int[] left, int[] right) {
        int time=0;

        ArrayList<Character>r=new ArrayList<>();
        ArrayList<Character>l=new ArrayList<>();

        for(int i=0;i<=n;i++)
        {
            r.add('X');
            l.add('X');
        }

        for(int i=0;i<left.length;i++)
            l.set(left[i],'A');

        for(int i=0;i<right.length;i++)
            r.set(right[i],'A');
        

        int rpos=-1,lpos=-1;
        for(int i=0;i<r.size();i++)
        {
            if(r.get(i)=='A')
            {
                rpos=i;
                break;
            }
        }
        for(int i=l.size()-1;i>=0;i--)
        {
            if(l.get(i)=='A')
            {
                lpos=i;
                break;
            }

        }
        System.out.println(rpos);System.out.println(lpos);
        
        if(lpos==-1&&rpos==-1)return 0;
        int rtime=-1;
        boolean flag=false;

       if(rpos!=-1)
       {
           rtime=n-rpos;
           flag=true;
       }
        int ltime=lpos;
       // if(lpos==-1)return ltime;
        if(rpos==-1&&flag)return rtime;

        if(rtime>ltime)return rtime;
        else return ltime;
    
    }
}