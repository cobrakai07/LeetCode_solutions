class MyCalendarTwo {
    Map<Integer, Integer> mp = new TreeMap<>();  // Use TreeMap to keep events sorted by time

    public MyCalendarTwo() {}

    public boolean book(int start, int end) {
        mp.put(start, mp.getOrDefault(start, 0) + 1);  // Increment for new event start
        mp.put(end, mp.getOrDefault(end, 0) - 1);      // Decrement for event end

        int activeBooking = 0;

        for (int key : mp.keySet()) {
            activeBooking += mp.get(key);  // Count how many events are currently ongoing

            if (activeBooking >= 3) {  // If there are 3 or more overlapping events
                // Undo the changes as this booking is not allowed
                mp.put(start, mp.getOrDefault(start, 0) - 1);
                mp.put(end, mp.getOrDefault(end, 0) + 1);
                return false;
            }
        }

        return true;
    }
}

/**
 * Your MyCalendarTwo object will be instantiated and called as such:
 * MyCalendarTwo obj = new MyCalendarTwo();
 * boolean param_1 = obj.book(start,end);
 */
