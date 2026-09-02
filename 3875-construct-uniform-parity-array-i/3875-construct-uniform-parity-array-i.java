class Solution {
    public boolean uniformArray(int[] nums1) {
        Set<Integer> setEven = new HashSet<>();
        Set<Integer> setOdd = new HashSet<>();
        for(int i=0;i<nums1.length;i++){
            if(nums1[i]%2==0)setEven.add(i);
            else setOdd.add(i);
        }
        boolean isOdd = true;
        for(int i=0;i<nums1.length;i++){
            if(nums1[i]%2==0){
                if(setOdd.size()==0){
                    
                    isOdd = false;
                    break;
                }
            }
        }

        if(isOdd)return true;

        boolean isEven = true;
        for(int i=0;i<nums1.length;i++){
            if(nums1[i]%2==1){
                if(setEven.size()==0){
                    
                    isEven = false;
                    break;
                }
            }
        }

        if(isEven)return true;

        return false;
    }
}