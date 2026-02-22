class Solution {
    public int binaryGap(int n) {
        int maxGap = 0;
        int currGap =0;
        boolean start = false;
        while(n!=0){
            if((n&1)==1 && !start){
                start=true;
                currGap++;
            }else if((n&1)==1 && start){
                maxGap = Math.max(maxGap,currGap);
                start=true;
                currGap=1;
            }
            else if((n&1)==0 && start){
                currGap++;
            }
            n=n>>1;
            // System.out.println(Integer.toBinaryString(n));
        }
        return maxGap;
    }
}