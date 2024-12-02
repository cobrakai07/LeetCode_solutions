class Solution {
    public int smallestNumber(int n) {
        for(int i=n; i<Integer.MAX_VALUE;i++){
            int num=i;
            int setBitCount=0;
            int bitCount=0;
            while(num!=0){
                int set=((num&1)==1)?1:0;
                setBitCount+=set;
                bitCount++;
                num=num>>1;
            }
            if(bitCount==setBitCount)return i;
        }
        return -1;
    }
}