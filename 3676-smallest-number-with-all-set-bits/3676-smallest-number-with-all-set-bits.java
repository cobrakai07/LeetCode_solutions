class Solution {
    boolean allSet(int n){
        while(n!=0){
            if((n&1)!=1)return false;
            n=n>>1;
        }
        return true;
    }
    public int smallestNumber(int n) {
        while(!allSet(n)){
            n++;
        }
        return n;
    }
}