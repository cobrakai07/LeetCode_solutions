class Solution {
    public int maxIncreasingSubarrays(List<Integer> nums) {
        int[]inc= new int[nums.size()];
        inc[0]=1;
        for(int i=1;i<nums.size();i++){
         if(nums.get(i-1)<nums.get(i)){
            inc[i]=inc[i-1]+1;
         }else{
            inc[i]=1;
         }
        }
       

        List<Integer> list = new ArrayList<>();

        for(int i=1;i<inc.length;i++){
            if(inc[i-1]>=inc[i])
                list.add(inc[i-1]);
        }

        if(inc[inc.length-1]>inc[inc.length-2])
                list.add(inc[inc.length-1]);

        int max  = 1;
        max=Math.max(list.get(0)/2,max);
        for(int i=1;i<list.size();i++){
            max=Math.max(list.get(i)/2,max);
            max=Math.max(list.get(i-1)/2,max);
            if(list.get(i-1)<=list.get(i)){
                max=Math.max(list.get(i-1),max);
            }
            if(list.get(i-1)>list.get(i)){
                max=Math.max(list.get(i),max);
            }
        }
        // System.out.println(list);


       
        return max;
    }
}