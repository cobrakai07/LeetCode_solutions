class Solution {
    public int minBitFlips(int start, int goal) {
        int xor = start ^ goal;
        // return Integer.bitCount(xor);
        int c=0;
        while(xor!=0){
            xor=xor&(xor-1);
            c++;
        }
        return c;
    }
}