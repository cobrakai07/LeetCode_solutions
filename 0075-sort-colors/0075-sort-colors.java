class Solution {
    public int fun(int i,int color, int c, int[]arr)
    {
        int j=-1;
        for(j=i;c!=0;j++,c--)
        {
            arr[j]=color;
        }
        return j;
    }
    public void sortColors(int[] nums) {
        int z=0,o=0,t=0;
        for(int i: nums)
        {
            if(i==0)z++;
            else if(i==1)o++;
            else t++;
        }
        int idx=fun(0,0,z,nums);
        idx=fun(idx,1,o,nums);
        idx=fun(idx,2,t,nums);
    }
}