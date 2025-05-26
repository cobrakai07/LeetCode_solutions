import java.util.*;

class Solution {
    static final int MAX = 10000;
    static final boolean[] isPrime = sieve();

    // Generate prime numbers up to MAX
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

            for (int pos = 1; pos <= numLength(num); pos++) {
                int digitPlace = (int) Math.pow(10, pos - 1);

                // Increment digit
                if ((num / digitPlace) % 10 < 9) {
                    int next = num + digitPlace;
                    if (!isPrime[next] && dist[next] > cost + next) {
                        dist[next] = cost + next;
                        pq.offer(new int[]{next, dist[next]});
                    }
                }

                // Decrement digit
                if ((num / digitPlace) % 10 > 0 && num != 1) {
                    int next = num - digitPlace;
                    if (!isPrime[next] && dist[next] > cost + next) {
                        dist[next] = cost + next;
                        pq.offer(new int[]{next, dist[next]});
                    }
                }
            }
        }

        return dist[target] == Integer.MAX_VALUE ? -1 : dist[target] + start;
    }

    // Helper to count digits
    private int numLength(int n) {
        if (n >= 1000) return 4;
        if (n >= 100) return 3;
        if (n >= 10) return 2;
        return 1;
    }
}
