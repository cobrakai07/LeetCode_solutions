class Solution {
    public int digit(int n){
        int min = 10;
        int max = -1;

        while(n!=0){
            int r = n%10;
            min = Math.min(r,min);
            max = Math.max(r,max);
            n = n/10;
        }
        return max-min;
    }
    public int maxDigitRange(int[] nums) {
        Map<Integer,Integer> map =  new HashMap<>();
        int max = -1;
        for(int i: nums){
            int  num = digit(i);
            max = Math.max(num,max);
            map.put(num,map.getOrDefault(num,0)+i);
        }
        return map.get(max);
    }
}