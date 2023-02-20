class LRUCache {
    ListNode sentinel;
    Map<Integer, ListNode> cache;
    int capacity;
    public LRUCache(int cap) {
        cache = new HashMap<>();
        sentinel = new ListNode(-1, -1);
        sentinel.prev = sentinel;
        sentinel.next = sentinel;
        capacity = cap;
    }
    
    public int get(int key) {
        if (!cache.containsKey(key)) {
            return -1;
        }
        ListNode curr = cache.get(key);
        if (curr.next != sentinel) {
            updateNode(curr);
        }
        return curr.val;
    }
    
    public void put(int key, int val) {
        if (cache.containsKey(key)) {
            cache.get(key).val = val;
            cache.put(key, updateNode(cache.get(key)));
        } else if (cache.size() < capacity) {
            cache.put(key, addNewNode(key, val));
        } else {
            delOldNode();
            cache.put(key, addNewNode(key, val));
        }
    }

    private ListNode addNewNode(int key, int value) {
        ListNode newNode = new ListNode(key, value);
        newNode.prev = sentinel.prev;
        sentinel.prev.next = newNode;
        newNode.next = sentinel;
        sentinel.prev = newNode;
        return newNode;
    }

    private void delOldNode() {
        cache.remove(sentinel.next.key);
        sentinel.next = sentinel.next.next;
        sentinel.next.prev = sentinel;
    }

    private ListNode updateNode(ListNode node) {
            node.next.prev = node.prev;
            node.prev.next = node.next;        
            sentinel.prev.next = node;
            node.prev = sentinel.prev;
            sentinel.prev = node;
            node.next = sentinel;
            return node;
    }

    class ListNode {
        public ListNode prev;
        public ListNode next;
        public int key;
        public int val;
        public ListNode(int k, int v) {
            key = k;
            val = v;
        }
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */