class Solution {
    public boolean isPowerOfFour(int n) {
      
        
        int temp=n;
        int count=0;
        while(n>3)
        {
            n=n/4;
            count++;
        }
     
        int result=(int)Math.pow(4,count);
        if(temp!=result)return false;
        else return true;

    }
}