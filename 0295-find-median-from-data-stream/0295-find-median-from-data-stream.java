class MedianFinder {
    PriorityQueue<Integer> left;
     PriorityQueue<Integer> right;
    public MedianFinder() {
        left=new  PriorityQueue<Integer>(Collections.reverseOrder());
        right=new  PriorityQueue<Integer>();
    }
    
    public void addNum(int num) {

      
        if(left.isEmpty() || left.peek()>=num){
            left.add(num);
        }
        else{
            right.add(num);
        }

        if(left.size()>right.size()+1){
            right.add(left.remove());
        }
        else if(left.size()<right.size()){
            left.add(right.remove());
        
             
        }
    }
    
    public double findMedian() {
        if(left.size()>right.size()){
            return (double)left.peek();
        }
        
        else{
            return ((double)left.peek()+(double)right.peek())/2.0;
        }
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */