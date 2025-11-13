class Solution {
    public int pivotInteger(int n) {
        if(n==1)return 1;
        int[]arr= new int[n];
        for(int i=0,num=1;i<n;i++,num++){
            arr[i]=num;
        }
        for(int i=1;i<n;i++){
            arr[i]=arr[i]+arr[i-1];
        }
        int ts=arr[n-1];
        for(int i=1;i<n;i++){
            if(arr[i]==(ts-arr[i-1]))return i+1;
        }
        return -1;
    }
}