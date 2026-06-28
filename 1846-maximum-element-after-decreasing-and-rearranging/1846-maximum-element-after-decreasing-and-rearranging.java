class Solution {
    public int maximumElementAfterDecrementingAndRearranging(int[] arr) {
        int ans = 0;
        Arrays.sort(arr);
        if(arr[0]!=1){
            arr[0]=1;
        }
        for(int i = 1; i< arr.length; i++){
            if(Math.abs(arr[i]-arr[i-1])>1){
                arr[i]= arr[i-1]+1;
            }
        }

        int max = 0;
        
        for(int i: arr)max = Math.max(i,max);

        // System.out.println(Arrays.toString(arr));
        return max;
    }
}