class Solution {
    public int[] productExceptSelf(int[] nums) {

        int pre[]= new int[nums.length];
        int post[]= new int[nums.length];
        int ans[]= new int[nums.length];

        int product1=1,product2=1;

        pre[0]=1;
        for(int i=1;i<nums.length;i++)
        {
            product1=nums[i-1]*product1;
            pre[i]=product1;
        }

        post[nums.length-1]=1;
        for(int i=nums.length-2;i>=0;i--)
        {
            product2=nums[i+1]*product2;
            post[i]=product2;
        }


        for(int i=0;i<nums.length;i++)
        {
            ans[i]=pre[i]*post[i];
        }
        
          return ans;
    }
}
