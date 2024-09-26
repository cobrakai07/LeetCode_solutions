class MyCalendar {
    TreeSet<int[]>set;
    public MyCalendar() {
        set=new TreeSet<>((a,b)->{
            if(a[0]==b[0])
                return a[1]-b[1];
            return a[0]-b[0];
        });
    }
    
    public boolean book(int start, int end) {
        for(int[]a: set)
        {
            if (a[0] < end && start < a[1]) 
                return false;
        }
        set.add(new int[]{start,end});
        return true;
    }
}

/**
 * Your MyCalendar object will be instantiated and called as such:
 * MyCalendar obj = new MyCalendar();
 * boolean param_1 = obj.book(start,end);
 */