class Solution {
    public boolean isGood(int[] nums) {
        int max = 0;
        for (int i : nums) {
            max = Math.max(i, max);
        }
        int n = max;
        boolean[] arr = new boolean[n + 1];
        arr[0] = true;
        boolean flag = false;
        for (int i : nums) {
            if (i == max) {
                if (!arr[i]){
                    arr[i] = true;
                } 
                else{
                    if(flag)return false;
                    flag = true;
                }
            } else {
                if (arr[i])
                    return false;
                arr[i] = true;
            }
        }
        // System.out.println(Arrays.toString(arr));
        for (boolean i : arr) {
            if (!i)
                return false;
        }

        if (!flag)
            return false;

        return true;
    }
}