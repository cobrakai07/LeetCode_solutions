class Solution {

    void merge(int[] arr, int left, int middle, int right){

        //(important***)divide subarrays as you have divide them in sort function 

        int n1=middle-left+1;
        int n2=right-middle;
        int arr1[]=new int[n1];
        int arr2[]= new int[n2];

        for(int i=left,idx=0;i<=middle;i++,idx++)
            arr1[idx]=arr[i];
        for(int i=middle+1,idx=0;i<=right;i++,idx++)
            arr2[idx]=arr[i];
        
        int k=left;
        int p1=0,p2=0;
        while(p1<arr1.length && p2<arr2.length){
            if(arr1[p1]<arr2[p2])
                arr[k++]=arr1[p1++];
            else
                arr[k++]=arr2[p2++];
        }

        while(p1<arr1.length)
            arr[k++]=arr1[p1++];
        while(p2<arr2.length)
            arr[k++]=arr2[p2++];
    }
    
    void sort(int arr[], int l, int r)
    {
        if (l < r) // dont make it equals to
        {
            int m = l + (r - l) / 2;
            sort(arr, l, m);
            //left to middle --> one subarray
            sort(arr, m + 1, r);
            //middle + 1 to right --> one subarray
            merge(arr, l, m, r);
        }
    }
 
    public int[] sortArray(int[] nums) {
        sort(nums,0,nums.length-1);
        return nums;
    }
}