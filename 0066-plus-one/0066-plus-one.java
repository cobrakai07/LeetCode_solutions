class Solution {
    public int[] plusOne(int[] digits) {
        boolean carry = false;
        int[] ans = new int[digits.length];
        int num1 = digits[digits.length-1] + 1;
        if (num1 > 9) {
            ans[digits.length-1] = num1 % 10;
            carry = true;
        } else {
            ans[digits.length-1] = num1;
        }
        
        for (int i = digits.length - 2; i >= 0; i--) {
            if (carry) {
                int num = digits[i] + 1;
                if (num > 9) {
                    ans[i] = num % 10;
                    carry = true;
                } else {
                    ans[i] = num;
                    carry = false;
                }
            } else {
                int num = digits[i];
                ans[i] = num;
            }
        }

        if(carry){
            int[] aans = new int[ans.length+1];
            for(int i=1;i<aans.length;i++)
                aans[i]=ans[i-1];
            aans[0]=1;
            return aans;
        }

        return ans;
    }
}