class LRUCache {
    int capacity;
    Node head = new Node(-1, -1);
    Node tail = new Node(-1, -1);
    Map<Integer, Node> map = new HashMap<>();

    class Node {
        int key;
        int value;
        Node next;
        Node prev;

        Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    public LRUCache(int capacity) {
        this.capacity = capacity;
        head.next = tail;
        tail.prev = head;
    }
    
    public int get(int key) {
        if (!map.containsKey(key)) return -1;
        Node existingNode = map.get(key);
        update(existingNode);
        return existingNode.value;
    }
    
    public void put(int key, int value) {
        if (map.containsKey(key)) {
            Node existingNode = map.get(key);
            existingNode.value = value;
            update(existingNode);
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

    private void delete(Node node) {
        Node nextNode = node.next;
        Node prevNode = node.prev;

        nextNode.prev = prevNode;
        prevNode.next = nextNode;
    }

    private void add(Node node) {
        Node nextNode = head.next;
        
        node.next = nextNode;
        node.prev = head;

        head.next = node;
        nextNode.prev = node;

    }
}
