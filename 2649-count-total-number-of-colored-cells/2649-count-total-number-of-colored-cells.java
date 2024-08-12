class Solution {
    public long coloredCells(int n) {
        long sum=1L;
        if(n==1)return sum;
        for(int i=2;i<=n;i++){
            sum+=(long)(4L*(long)(i-1));
        }
        return sum;
    }
}