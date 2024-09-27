class MyCalendar {
    Map<Integer,Integer>mp=new TreeMap<>();
    public MyCalendar() {
        
    }
    
    public boolean book(int start, int end) {
        mp.put(start, mp.getOrDefault(start, 0) + 1);  
        mp.put(end, mp.getOrDefault(end, 0) - 1);      
        int activeBooking = 0;

        for (int key : mp.keySet()) {
            activeBooking += mp.get(key);

            if (activeBooking >= 2) { 
                mp.put(start, mp.getOrDefault(start, 0) - 1);
                mp.put(end, mp.getOrDefault(end, 0) + 1);
                return false;
            }
        }

        return true;
    }
}

/**
 * Your MyCalendar object will be instantiated and called as such:
 * MyCalendar obj = new MyCalendar();
 * boolean param_1 = obj.book(start,end);
 */