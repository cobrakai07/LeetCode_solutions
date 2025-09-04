class Solution {
    public int findClosest(int x, int y, int z) {
        int d1= z<x?x-z:z-x;
        int d2 = z<y?y-z:z-y;
        double s1=1.0/d1;
        double s2=1.0/d2;
        return s1==s2?0:s1>s2?1:2;
    }
}