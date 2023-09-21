import java.util.Arrays;
class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
         int []arr=new int[nums1.length+nums2.length];
        for(int i=0;i<nums1.length;i++)
        {
            arr[i]=nums1[i];
        }
        int j=nums1.length;
        for(int i=0;i<nums2.length;i++)
        {
            arr[j++]=nums2[i]; 
        }
        Arrays.sort(arr);
        int oddeven=arr.length;
        if(oddeven%2!=0)
        {
            int output=(arr.length/2);
            double res1=arr[output];
            return res1;
        }
        else
        {
            int output=(arr.length/2);
            double b1=arr[output-1];
            double b2=arr[output];
            double b3=(b1+b2)/2;
            return b3;
        }
    }
}