class Solution {
    public int earliestTime(int[][] tasks) {
        int m = Integer.MAX_VALUE;
        for(int a[]: tasks){
            m= Math.min(a[0]+a[1],m);
        }
        return m;
    }
}