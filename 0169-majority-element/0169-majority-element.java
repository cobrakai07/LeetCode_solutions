class Solution {
    public int majorityElement(int[] nums) {
        int c=0;
        int el=-1;
        for(int i: nums){
            if(c==0){
                c=1;
                el=i;
            }else if(el==i)c++;
            else c--;
        }
        return el;
    }
}