class Solution {
    public boolean calTime(double w, int h,int []p){
        int curr=0;
        for(int i: p){
            curr+=Math.ceil(i/w);
            if(curr>h)return false;
        }
        // System.out.println(STR."\{curr}  \{w}");
        return true;
    }
    public int bs(int s, int e, int h, int[]p){
        if(s>e)return Integer.MAX_VALUE;
        int m=s+(e-s)/2;
        int currMin=Integer.MAX_VALUE;
        int minLeft=currMin;
        int minNot=currMin;
        if(calTime(m,h,p)){
            currMin= m;
            minLeft= bs(s,m-1,h,p);
        }else{
            minNot=bs(m+1,e,h,p);
        }
        return Math.min(currMin,Math.min(minNot,minLeft));
    }
    public int minEatingSpeed(int[] piles, int h) {
        int max=0;
        for(int i: piles){
            max=Math.max(i,max);
        }

        int s=1, e=max;

        return bs(s,e,h,piles);
    }
}