class Solution {
    public int[] closestPrimes(int left, int right) {

        int max = right;
        boolean[] isPrime = new boolean[max + 1];
        Arrays.fill(isPrime, true);
        isPrime[0] = false;
        isPrime[1] = false;

        for (int i = 2; i * i <= max; i++) {
            if (isPrime[i]) {
                for (int j = i * i; j <= max; j += i) {
                    isPrime[j] = false;
                }
            }
        }

        List<Integer> primes = new ArrayList<>();
        for (int i = Math.max(2, left); i <= right; i++) {
            if (isPrime[i]) {
                primes.add(i);
            }
        }


        if (primes.size() < 2) {
            return new int[]{-1, -1};
        }

        int[] result = new int[]{-1, -1};
        int minDiff = Integer.MAX_VALUE;
        for (int i = 0; i < primes.size() - 1; i++) {
            int diff = primes.get(i + 1) - primes.get(i);
            if (diff < minDiff) {
                minDiff = diff;
                result[0] = primes.get(i);
                result[1] = primes.get(i + 1);
            }
        }

        return result;
    }
}
