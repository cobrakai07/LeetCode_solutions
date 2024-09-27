class MyCalendarThree {
    Map<Integer, Integer> mp = new TreeMap<>();
    
    public MyCalendarThree() {
    }

    public int book(int start, int end) {

        mp.put(start, mp.getOrDefault(start, 0) + 1);
        mp.put(end, mp.getOrDefault(end, 0) - 1);

        int activeBooking = 0, maxBooking = 0;
    //   System.out.println(mp);
        for (int key : mp.keySet()) {
            activeBooking += mp.get(key);
            maxBooking = Math.max(maxBooking, activeBooking);
        }

        return maxBooking;
    }
}
