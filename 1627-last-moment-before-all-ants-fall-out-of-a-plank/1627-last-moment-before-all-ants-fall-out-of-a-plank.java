class Solution {
    public int getLastMoment(int n, int[] left, int[] right) {
        
        int min=Integer.MAX_VALUE;
        for(int i=0;i<right.length;i++)
        {
            if(right[i]<min)
            min=right[i];
        }
        int max=Integer.MIN_VALUE;
        for(int i=0;i<left.length;i++)
        {
            if(left[i]>max)
            max=left[i];
        }
        
        int rpos=-1,lpos=-1;
        if(min!=Integer.MAX_VALUE)
            rpos=min;
        
        if(max!=Integer.MIN_VALUE)
            lpos=max;
        
        
        if(lpos==-1&&rpos==-1)return 0;

        int rtime=-1;
        boolean flag=false;

       if(rpos!=-1)
       {
           rtime=n-rpos;
           flag=true;
       }
       
        int ltime=lpos;
        if(rpos==-1&&flag)return rtime;
        if(rtime>ltime)return rtime;
        else return ltime;
    
    }
}