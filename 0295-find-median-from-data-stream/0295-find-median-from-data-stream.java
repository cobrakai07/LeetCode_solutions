class MedianFinder {

    PriorityQueue<Integer>minHeap;
    PriorityQueue<Integer>maxHeap;

    public MedianFinder() {
        minHeap = new PriorityQueue<>((a,b)->Integer.compare(a,b));
        maxHeap = new PriorityQueue<>((a,b)->Integer.compare(b,a));
    }
    
    public void addNum(int num) {
        minHeap.offer(num);
        maxHeap.offer(minHeap.poll());

        if(maxHeap.size()>minHeap.size()){
            minHeap.offer(maxHeap.poll()); 
        }
    }
    
    public double findMedian() {
        if(((minHeap.size()+maxHeap.size())&1)==1)return minHeap.peek()/1.0;
        return (minHeap.peek()+maxHeap.peek())/2.0;
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */