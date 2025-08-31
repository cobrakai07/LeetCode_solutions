class Solution {
    public int getLeastFrequentDigit(int n) {
        int[]hash= new int[10];
        while(n>0){
           hash[n%10]++;
           n=n/10;
        }
       
       int min = Integer.MAX_VALUE;
       for(int i=0;i<10;i++){
        if(hash[i]!=0)
            min= Math.min(min,hash[i]);
       }

       for(int i=0;i<10;i++){
        if(min==hash[i])return i;
       }

        return 0;
    }
}