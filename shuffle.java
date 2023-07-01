class Solution {

    public int[] shuffle(int[] nums, int n) {
        int []arr=new int [2*n];
        int idx=0,idx1=0,idx2=n;
        while(idx1<n&&idx2<2*n)
        {
            arr[idx++]=nums[idx1++];
            arr[idx++]=nums[idx2++];
        }
        return arr;
    }
}