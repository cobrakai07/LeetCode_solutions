

record P(int id, long f) {}

class Solution {
    public long[] mostFrequentIDs(int[] nums, int[] freq) {
        long[] ans = new long[nums.length];
        PriorityQueue<P> pq = new PriorityQueue<>((a, b) -> {
            if (b.f() != a.f()) {
                return Long.compare(b.f(), a.f());
            } else {
                return Integer.compare(a.id(), b.id());
            }
        });
        Map<Integer, Long> mp = new HashMap<>();
        
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            long newFreq = mp.getOrDefault(num, 0L) + freq[i];
            mp.put(num, newFreq);
            pq.offer(new P(num, newFreq));

            // Remove outdated elements from the top
            while (pq.peek().f() != mp.get(pq.peek().id())) {
                pq.poll();
            }

            ans[i] = pq.peek().f();
        }

        return ans;
    }
}
