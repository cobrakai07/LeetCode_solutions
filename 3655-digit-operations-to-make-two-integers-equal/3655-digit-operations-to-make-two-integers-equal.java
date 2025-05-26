import java.util.*;

class Solution {
    static final int MAX = 10000;
    static final boolean[] isPrime = sieve();

    static boolean[] sieve() {
        boolean[] prime = new boolean[MAX];
        Arrays.fill(prime, true);
        prime[0] = prime[1] = false;
        for (int p = 2; p * p < MAX; p++) {
            if (prime[p]) {
                for (int i = p * p; i < MAX; i += p) {
                    prime[i] = false;
                }
            }
        }
        return prime;
    }

    public int minOperations(int start, int target) {
        if (isPrime[start]) return -1;

        int[] dist = new int[MAX];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[start] = 0;

        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));
        pq.offer(new int[]{start, 0});

        while (!pq.isEmpty()) {
            int[] curr = pq.poll();
            int num = curr[0], cost = curr[1];
            char[] digits = String.valueOf(num).toCharArray();

            for (int i = 0; i < digits.length; i++) {
                char original = digits[i];

                // Increment digit
                if (digits[i] < '9') {
                    digits[i]++;
                    int next = Integer.parseInt(new String(digits));
                    if (!isPrime[next] && dist[next] > cost + next) {
                        dist[next] = cost + next;
                        pq.offer(new int[]{next, dist[next]});
                    }
                    digits[i] = original; // revert
                }

                // Decrement digit
                if (digits[i] > '0') {
                    digits[i]--;
                    int next = Integer.parseInt(new String(digits));
                    if (!isPrime[next] && dist[next] > cost + next) {
                        dist[next] = cost + next;
                        pq.offer(new int[]{next, dist[next]});
                    }
                    digits[i] = original; // revert
                }
            }
        }

        return dist[target] == Integer.MAX_VALUE ? -1 : dist[target] + start;
    }
}
