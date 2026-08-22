class Solution {
    public boolean fun(int n){
        int num = n;
        int sum=0;
        long p=1;
        while(num!=0){
            int r = num%10;
            sum+=r;
            p*=r;
            num/=10;
        }
        p+=sum;
        return  n%p==0;
    }
    public boolean checkDivisibility(int n) {
        return fun(n);
    }
}