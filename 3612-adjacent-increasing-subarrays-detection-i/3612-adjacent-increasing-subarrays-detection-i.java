class Solution {
    public boolean hasIncreasingSubarrays(List<Integer> nums, int k) {
        int[]inc= new int[nums.size()];
        inc[0]=1;
        for(int i=1;i<nums.size();i++){
         if(nums.get(i-1)<nums.get(i)){
            inc[i]=inc[i-1]+1;
         }else{
            inc[i]=1;
         }
        }

        if(k==1)
            return  true;

        for(int i: inc){
            if(i>=k*2)return true;
        }

        List<Integer> list = new ArrayList<>();

        for(int i=1;i<inc.length;i++){
            if(inc[i-1]>=inc[i])
                list.add(inc[i-1]);
        }

        if(inc[inc.length-1]>inc[inc.length-2])
                list.add(inc[inc.length-1]);

        for(int i=0;i<list.size()-1;i++){
            if(list.get(i)>=k && list.get(i+1)>=k)return true;
        }
        // System.out.println(list);


       
        return false;
    }
}