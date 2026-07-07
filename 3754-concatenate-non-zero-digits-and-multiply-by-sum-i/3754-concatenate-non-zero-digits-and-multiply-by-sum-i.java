class Solution {
    public long sumAndMultiply(int n) {
        long ans = 0;
        StringBuilder sb = new StringBuilder();
        int sum = 0;
        while(n!=0){
            int rem = n%10;
            if(rem!=0)sb.append(rem);
            sum = sum+rem;
            n=n/10;
        }
        sb.reverse();
        if(sb.length()==0)return 0;
        int nn = Integer.parseInt(sb.toString());
        return 1L*nn*sum;
    }
}