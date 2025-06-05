class Solution {
    TreeSet<Integer> maxHeap,minHeap;
    public double[] medianSlidingWindow(int[] nums, int k) {
    maxHeap = new TreeSet<>((a, b) -> {
            if (nums[a] != nums[b]) return Integer.compare(nums[b], nums[a]); // Max-heap behavior
            return Integer.compare(a, b); // Break ties by index
        });

    minHeap = new TreeSet<>((a, b) -> {
            if (nums[a] != nums[b]) return Integer.compare(nums[a], nums[b]); // Min-heap behavior
            return Integer.compare(a, b); // Break ties by index
        });

        double[] res = new double[nums.length - k + 1];
        int ans=0;
        for (int i = 0; i < nums.length; i++) {

            if(i>=k){
                minHeap.remove(i-k);
                maxHeap.remove(i-k);
            }

            minHeap.add(i);
            maxHeap.add(minHeap.pollFirst());

            balance();

            if(i>=k-1)res[ans++]=getMedian(nums,k);

           
        }

        return res;
    }

    private Double getMedian(int[]nums, int k){
        if(k%2==0)return ((double)nums[minHeap.first()]
        +nums[maxHeap.first()])/2;

        return  ((double)nums[minHeap.first()]);
    }

    private void balance() {
        
            if(maxHeap.size()>minHeap.size())
            minHeap.add(maxHeap.pollFirst());
        
    }}