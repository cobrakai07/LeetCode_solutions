class Solution {
    public int pivotIndex(int[] nums) {
        int[]p1=new int [nums.length];
        int[]p2=new int [nums.length];
        int sum=0;
        for(int i=0;i<nums.length;i++){
            sum=sum+nums[i];
            p1[i]=sum;
        }

        sum=0;
        for(int i=nums.length-1;i>=0;i--){
            sum=sum+nums[i];
            p2[i]=sum;
        }

        System.out.println(Arrays.toString(p1));
                System.out.println(Arrays.toString(p2));
        for(int i=0;i<nums.length;i++){
            if(i==0){
                if(nums.length==1 || p2[1]==0)return 0;
            }
            else if(i==nums.length-1){
                if(p1[nums.length-2]==0)return i;
            }else{
                if(p1[i-1]==p2[i+1])return i;
            }
        }
        return -1;
    }
}