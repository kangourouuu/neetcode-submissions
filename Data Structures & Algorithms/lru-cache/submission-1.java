class LRUCache {
    int capacity;
    Node head = new Node(-1, -1);
    Node tail = new Node(-1, -1);
    Map<Integer, Node> map = new HashMap<>();

    class Node {
        int key;
        int val;
        Node prev;
        Node next;

        Node (int key, int val) {
            this.key = key;
            this.val = val;
        }
    }

    public LRUCache(int capacity) {
        this.capacity = capacity;
        head.next = tail;
        tail.prev = head;
    }
    
    public int get(int key) {
        if (!map.containsKey(key)) return -1;
        update(map.get(key));
        return map.get(key).val;
    }
    
    public void put(int key, int value) {
        if (map.containsKey(key)) {
            Node existedNode = map.get(key);
            existedNode.val = value;
            update(existedNode);
        } else {
            Node newNode = new Node(key, value);
            add(newNode);
            map.put(key, newNode);  
            if (map.size() > capacity) {
                Node lastNode = tail.prev;
                delete(lastNode);
                map.remove(lastNode.key);
            }
        }
        
    }

    private void update(Node node) {
        delete(node);
        add(node);
    }

    private void delete(Node oldNode) {
        Node prevNode = oldNode.prev;
        Node nextNode = oldNode.next;
        
        prevNode.next = nextNode;
        nextNode.prev = prevNode;
    }

    private void add(Node newNode) {
        Node nextNode = head.next;
        head.next = newNode;
        newNode.next = nextNode;
        newNode.prev = head;
        nextNode.prev = newNode;
    }
}
