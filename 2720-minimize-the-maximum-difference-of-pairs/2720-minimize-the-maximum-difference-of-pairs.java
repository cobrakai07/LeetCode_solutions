class Solution {
    public boolean validDiff(int n, int p, int[]nums){
        for(int i=0, j=1;i<nums.length;){
   
            if(Math.abs(nums[i]-nums[(j)%nums.length])<=n){
                i+=2;
                j+=2;
                p--;
            }else{
                i++;j++;
            }
               
        }
  
        return p<=0;
    }
    public int minimizeMax(int[] nums, int p) {
        Arrays.sort(nums);
        int md = Math.abs(nums[0]-nums[nums.length-1]);
        int s =0, e =md;
        int min =Integer.MAX_VALUE;
        while(s<=e){
            int m = s+(e-s)/2;
            // System.out.println(m+" [[");
            if(validDiff(m,p,nums)){

                // System.out.println(m);
                min=Math.min(min,m);
                e=m-1;
            }else{
                s=m+1;
            }
        }
        
        return min;
    }
}