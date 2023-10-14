class Solution {
    public int minBitFlips(int start, int goal) {
        int count=0;
        for(int i=0;i<32;i++)
        {
            int mask=(1<<i);
            if(((start & mask)==0 && (goal & mask)!=0) || ((start & mask)!=0 && (goal & mask)==0))
                count++;

        }
        return count;
    }
}