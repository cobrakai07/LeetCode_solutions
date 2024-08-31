class MyCircularDeque {
    ArrayDeque<Integer>q;
    int max;
    int curr;
    public MyCircularDeque(int k) {
        q=new ArrayDeque<>();
        max=k;
        curr=0;
    }
    
    public boolean insertFront(int value) {
        if(curr<max){q.offerFirst(value);curr++;return true;}
        return false;
    }
    
    public boolean insertLast(int value) {
        if(curr<max){q.offerLast(value);curr++;return true;}
        return false;
    }
    
    public boolean deleteFront() {
        if(curr>0){q.pollFirst();curr--;return true;}
        return false;
    }
    
    public boolean deleteLast() {
        if(curr>0){q.pollLast();curr--;return true;}
        return false;
    }
    
    public int getFront() {
        if(curr>0){return q.peekFirst();}
        return -1;
    }
    
    public int getRear() {
        if(curr>0){return q.peekLast();}
        return -1;
    }
    
    public boolean isEmpty() {
        return curr==0;
    }
    
    public boolean isFull() {
        return  curr==max;
    }
}

/**
 * Your MyCircularDeque object will be instantiated and called as such:
 * MyCircularDeque obj = new MyCircularDeque(k);
 * boolean param_1 = obj.insertFront(value);
 * boolean param_2 = obj.insertLast(value);
 * boolean param_3 = obj.deleteFront();
 * boolean param_4 = obj.deleteLast();
 * int param_5 = obj.getFront();
 * int param_6 = obj.getRear();
 * boolean param_7 = obj.isEmpty();
 * boolean param_8 = obj.isFull();
 */