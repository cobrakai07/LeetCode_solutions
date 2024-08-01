class Pair{
    int v;
    int m;
    Pair(int v, int m){
        this.v=v;
        this.m=m;
    }
}
class MinStack {
    Stack<Pair>s;
    public MinStack() {
        s= new Stack<>();
    }
    
    public void push(int val) {
        if(s.isEmpty()){
            s.push(new Pair(val,val));
        }else{
            int min=Math.min(s.peek().m, val);
            s.push(new Pair(val,min));
        }
    }
    
    public void pop() {
        s.pop();
    }
    
    public int top() {
       return s.peek().v;
    }
    
    public int getMin() {
       return  s.peek().m;
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */