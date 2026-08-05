import java.util.HashMap;
import java.util.Map;

class LRUCache {
    // Custom Doubly Linked List Node to store key-value pairs
    private static class Node {
        int key;
        int value;
        Node prev;
        Node next;

        Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    private final int capacity;
    private final Map<Integer, Node> map;
    private final Node head; // Dummy head representing the Most Recently Used (MRU) side
    private final Node tail; // Dummy tail representing the Least Recently Used (LRU) side

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.map = new HashMap<>();
        
        // Initialize dummy head and tail to simplify edge case pointer manipulation
        this.head = new Node(0, 0);
        this.tail = new Node(0, 0);
        head.next = tail;
        tail.prev = head;
    }
    
    public int get(int key) {
        if (!map.containsKey(key)) {
            return -1;
        }
        
        Node node = map.get(key);
        // Move accessed node to the head (marking it as recently used)
        remove(node);
        insertAtHead(node);
        
        return node.value;
    }
    
    public void put(int key, int value) {
        if (map.containsKey(key)) {
            Node node = map.get(key);
            node.value = value; // Update value
            remove(node);
            insertAtHead(node);
        } else {
            if (map.size() >= capacity) {
                // Cache full: Evict the least recently used element (the one right before tail)
                Node lruNode = tail.prev;
                remove(lruNode);
                map.remove(lruNode.key);
            }
            
            Node newNode = new Node(key, value);
            map.put(key, newNode);
            insertAtHead(newNode);
        }
    }

    // Helper method to detach a node from its current neighbors
    private void remove(Node node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    // Helper method to insert a node right after the dummy head (MRU position)
    private void insertAtHead(Node node) {
        node.next = head.next;
        node.next.prev = node;
        head.next = node;
        node.prev = head;
    }
}