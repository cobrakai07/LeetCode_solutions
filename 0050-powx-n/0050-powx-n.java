class Solution {
    public double myPow(double x, int n) {
        double ans = 1;

        if(x == 0 || x == 1) return x;

        if(n < 0){
            x = 1/x;
            n = -(n+1);    //for Integer.MIN_VALUE // making it positive will lead to overflow
            ans = ans * x; // adjusting the one lost value in case of Integer.MIN_VALUE;
        }

     
        while(n > 0) {
            if(n % 2 == 1) {
                ans = ans * x;
                n = n-1;
            }
            else {
                n = n/2;
                x = x * x;
            }
        }

        return ans;
    }
}