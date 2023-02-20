class MyCalendar {
    private TreeMap<Integer, Integer> bookings;

    public MyCalendar() {
        bookings = new TreeMap<Integer, Integer>();
    }
    
    public boolean book(int start, int end) {
        //the nearest entry(time period) of start at early side
        Map.Entry<Integer, Integer> lower = bookings.floorEntry(start);
        if (lower != null && start < lower.getValue()) {
            return false;
        }
        //the nearest entry(time period) of start at later side
        Map.Entry<Integer, Integer> upper = bookings.ceilingEntry(start);        
        if (upper != null && end > upper.getKey()) {
            return false;
        }
        //add booking into calendar
        bookings.put(start, end);
        return true;
    }
}

/**
 * Your MyCalendar object will be instantiated and called as such:
 * MyCalendar obj = new MyCalendar();
 * boolean param_1 = obj.book(start,end);
 */