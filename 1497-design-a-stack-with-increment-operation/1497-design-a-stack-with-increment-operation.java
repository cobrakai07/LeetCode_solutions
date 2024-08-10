class Node{
    int val;
    Node next;
    Node(int v){
        this.val=v;
    }
}
class MyLinkedList{
    Node head;
    Node tail;
    int size;
    int csize;

    MyLinkedList(int size){
        head=new Node(-1);
        tail=new Node(-1);
        head.next=tail;
        this.size=size;
        this.csize=0;
    }

    public void push(int val){
        if(csize<size){
            Node n = new Node (val);
            Node nh=head.next;
            head.next=n;
            n.next=nh;
            csize++;
        }
    }

    public int pop(){
        if(head.next.val==-1)return -1;
        int ans = head.next.val;
        Node nh=head.next.next;
        head.next=nh;
        csize--;

        // this.print();
        return ans;
    }

    public void inc(int k, int v){
        int skip= csize-k;
        if(skip<=0)skip=0;
        Node temp=head.next;
        while(temp.val!=-1 && skip!=0){
            temp=temp.next;
            skip--;
        }

        while(temp.val!=-1){
            temp.val=temp.val+v;
            temp=temp.next;
        }
         
    }
    public void print(){
        Node t=head;
        while(t!=null){
            System.out.print(t.val+" -> ");
            t=t.next;
        }
        System.out.println();
    }
}
class CustomStack {
    MyLinkedList ll;
    public CustomStack(int maxSize) {
        ll= new MyLinkedList(maxSize);
    }
    
    public void push(int x) {
        ll.push(x);
        // ll.print();
    }
    
    public int pop() {
        return ll.pop();
    }
    
    public void increment(int k, int val) {
        ll.inc(k,val);
        // ll.print();
    }
}

/**
 * Your CustomStack object will be instantiated and called as such:
 * CustomStack obj = new CustomStack(maxSize);
 * obj.push(x);
 * int param_2 = obj.pop();
 * obj.increment(k,val);
 */