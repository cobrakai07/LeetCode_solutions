class Solution {
    public int sumOfUnique(int[] nums) {
        int [] bucket = new int [101];
        for(int i: nums){
            bucket[i]++;
        }
        int c=0;
        // System.out.println(Arrays.toString(bucket));
        for(int i=0; i< bucket.length; i++){
            if(bucket[i]==1)c=c+i;
        }
        return c;
    }
}