class Solution {
    public void print(String s){
         System.out.println(s);
    }
    public int binarySearch(int e, int val, int [] arr){
        int s = 0;
        int idx = -1;
        int storeE = e;
        e = Math.min(e,arr.length-1);
        // print("====");
      
        // print(s+","+e);
        while(s<=e){
            int m = s+(e-s)/2;
            if(arr[m]<=val){
                e = m -1;
                idx = m;
            }else{
                s = m+1;
            }
        }
        
        // print(idx+"---"+(storeE-idx));
        return idx==-1?0:storeE-idx;
    }
    public int maxDistance(int[] nums1, int[] nums2) {
        int maxDistance = 0;
        for(int j=0;j<nums2.length;j++){
            maxDistance = Math.max(maxDistance, binarySearch(j,nums2[j],nums1));
        }
        return maxDistance;
    }
}