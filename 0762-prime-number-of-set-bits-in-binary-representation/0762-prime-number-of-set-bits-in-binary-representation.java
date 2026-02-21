class Solution {
    static int MAX = 33;     
    static boolean[] isPrime;        

    static {
        isPrime = buildSieve(MAX); 
    }

    public static boolean[] buildSieve(int n) {
        boolean[] prime = new boolean[n];
        Arrays.fill(prime, true);

        if (n > 0) prime[0] = false;
        if (n > 1) prime[1] = false;

        for (int i = 2; i * i < n; i++) {
            if (prime[i]) {
                for (int j = i * i; j < n; j += i) {
                    prime[j] = false;
                }
            }
        }
        return prime;
    }
    
    public int countSetBits(int n){
        int count = 0;
        while(n!=0){
            n = n&(n-1);
            count ++;
        }
        return count;
    }
    
    public int countPrimeSetBits(int left, int right) {

        int ans = 0;

        while(left<=right){
            // int setBits = Integer.bitCount(left);
            if(isPrime[countSetBits(left)])ans++;
            left++;
        }

        return ans;

    }
}