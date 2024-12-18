class Solution {
    public int[] finalPrices(int[] prices) {
        int ans[]=new int[prices.length];
        for(int i=0;i<prices.length;i++){
            int data=prices[i];
            boolean flag=false;
            for(int j=i+1;j<prices.length;j++){
                if(data>=prices[j]){
                    data=prices[j];
                    flag=true;
                    break;
                }
            }
            if(flag)
            ans[i]=prices[i]-data;
            else
            ans[i]=prices[i];
        }
        return ans;
    }
}