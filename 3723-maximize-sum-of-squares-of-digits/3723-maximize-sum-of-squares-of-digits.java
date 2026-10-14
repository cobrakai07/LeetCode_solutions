class Solution {
    public String maxSumOfSquares(int num, int sum) {
        StringBuilder sb = new StringBuilder();
        int[] arr = {9,8,7,6,5,4,3,2,1,0};
        int idx = 0;
        int currSum = 0;
        while(num!=0 && idx<10){
            if(currSum+arr[idx]<=sum){
                sb.append(arr[idx]+"");
                currSum+=arr[idx];
                num--;
            }else{
                idx++;
            }
        }
        // System.out.println(currSum);
        return currSum<sum ? "": sb.toString();
    }
}