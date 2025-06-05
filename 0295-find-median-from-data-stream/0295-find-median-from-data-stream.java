class MedianFinder {
    TreeSet<Integer> maxHeap;
    TreeSet<Integer> minHeap;
    List<Integer> nums;

    public MedianFinder() {
        nums = new ArrayList<>();

        maxHeap = new TreeSet<>((a, b) -> {
            if (!nums.get(a).equals(nums.get(b))) 
                return Integer.compare(nums.get(b), nums.get(a)); // Descending
            return Integer.compare(a, b); // Tie breaker
        });

        minHeap = new TreeSet<>((a, b) -> {
            if (!nums.get(a).equals(nums.get(b))) 
                return Integer.compare(nums.get(a), nums.get(b)); // Ascending
            return Integer.compare(a, b);
        });
    }

    public void addNum(int num) {
        nums.add(num);
        int i = nums.size() - 1;

        minHeap.add(i);
        maxHeap.add(minHeap.pollFirst());

        // Balance the heaps
        if (maxHeap.size() > minHeap.size()) {
            minHeap.add(maxHeap.pollFirst());
        }
    }

    public double findMedian() {
        if ((nums.size() & 1) == 1) {
            return nums.get(minHeap.first());
        }
        return (nums.get(minHeap.first()) + nums.get(maxHeap.first())) / 2.0;
    }
}
