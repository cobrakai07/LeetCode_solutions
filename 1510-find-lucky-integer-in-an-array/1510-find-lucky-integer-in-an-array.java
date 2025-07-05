class Solution {
    public int findLucky(int[] arr) {
        int[]hash= new int[501];
        for(int i: arr)hash[i]++;
        for(int i=500;i>=1;i--){
            if(hash[i]==i)return i;
        }
        return -1;
    }
}