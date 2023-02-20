class LRUCache {
    class Node {
        private Node prev;
        private Node next;
        private int k;
        private int v;

        private Node(int key, int val) {
            k = key;
            v = val;
        }
    }

    private Map<Integer, Node> map;
    private Node head;  //sentinel
    private Node tail;  //sentinel
    private int capacity;

    public LRUCache(int cap) {
        map = new HashMap<>();
        head = new Node(-1, -1);
        tail = new Node(-1, -1);
        head.next = tail;
        tail.prev = head;
        capacity = cap;
    }
    
    public int get(int key) {
        if (map.containsKey(key)) {  
            //remove cur from linked list
            Node cur = map.get(key);
            cur.prev.next = cur.next;
            cur.next.prev = cur.prev;
            //put cur before tail
            cur.prev = tail.prev;
            cur.prev.next = cur;
            cur.next = tail;
            tail.prev = cur;
            return cur.v;            
        }
        return -1;
    }
    
    public void put(int key, int value) {
        if (map.containsKey(key)) { 
            //remove cur from linked list
            Node cur = map.get(key);
            cur.v = value;
            cur.prev.next = cur.next;
            cur.next.prev = cur.prev;
            //put cur before tail
            cur.prev = tail.prev;
            cur.prev.next = cur;
            cur.next = tail;
            tail.prev = cur;
        } else {
            Node cur = new Node(key, value);
            //put cur before tail
            cur.prev = tail.prev;
            cur.prev.next = cur;
            cur.next = tail;
            tail.prev = cur;
            //update map and control size
            map.put(key, cur);
            if (map.size() > capacity) {
                Node removed = head.next;
                head.next = removed.next;
                removed.next.prev = head;
                map.remove(removed.k);
            }
        }
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */