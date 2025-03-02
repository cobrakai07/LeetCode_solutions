class Solution {
    public int[][] mergeArrays(int[][] nums1, int[][] nums2) {
        List<int[]>list= new ArrayList<>();
        int p1=0,p2=0;
        while(p1<nums1.length && p2<nums2.length){
            if(nums1[p1][0]<nums2[p2][0]){
                list.add(nums1[p1]);
                p1++;
            }else if(nums1[p1][0]>nums2[p2][0]){
                list.add(nums2[p2]);
                p2++;
            }else{
                nums1[p1][1]+=nums2[p2][1];
                list.add(nums1[p1]);
                p1++;p2++;
            }
        }

        while(p1<nums1.length){list.add(nums1[p1]);p1++;}
        while(p2<nums2.length){list.add(nums2[p2]);p2++;}

        int[][]ans=new int[list.size()][2];
        for(int i=0;i<list.size();i++)
            ans[i]=list.get(i);
        
        return ans;
        
    }
}