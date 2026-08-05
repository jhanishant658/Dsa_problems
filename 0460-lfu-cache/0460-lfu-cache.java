import java.util.HashMap;
import java.util.Map;

class LFUCache {
    // नोड स्ट्रक्चर: इसमें key, value और उसकी frequency स्टोर होगी
    private static class Node {
        int key, value, freq;
        Node prev, next;

        Node(int key, int value) {
            this.key = key;
            this.value = value;
            this.freq = 1; // शुरुआत में फ्रीक्वेंसी 1 होगी
        }
    }

    // Doubly Linked List: एक जैसी फ्रीक्वेंसी वाले नोड्स को रखने के लिए
    private static class DoublyLinkedList {
        Node head, tail;
        int size;

        DoublyLinkedList() {
            head = new Node(0, 0);
            tail = new Node(0, 0);
            head.next = tail;
            tail.prev = head;
            size = 0;
        }

        void addFirst(Node node) {
            node.next = head.next;
            node.next.prev = node;
            head.next = node;
            node.prev = head;
            size++;
        }

        void remove(Node node) {
            node.prev.next = node.next;
            node.next.prev = node.prev;
            size--;
        }

        Node removeLast() {
            if (size == 0) return null;
            Node lruNode = tail.prev;
            remove(lruNode);
            return lruNode;
        }
    }

    private final int capacity;
    private int minFreq;
    private final Map<Integer, Node> cache;
    private final Map<Integer, DoublyLinkedList> freqMap; 

    public LFUCache(int capacity) {
        this.capacity = capacity;
        this.minFreq = 0;
        this.cache = new HashMap<>();
        this.freqMap = new HashMap<>();
    }

    public int get(int key) {
        if (!cache.containsKey(key)) {
            return -1;
        }
        Node node = cache.get(key);
        updateFrequency(node); 
        return node.value;
    }

    public void put(int key, int value) {
        if (capacity <= 0) return;

        if (cache.containsKey(key)) {
            Node node = cache.get(key);
            node.value = value;
            updateFrequency(node);
            return;
        }

      
        if (cache.size() >= capacity) {
            DoublyLinkedList minFreqList = freqMap.get(minFreq);
            Node toRemove = minFreqList.removeLast(); 
            cache.remove(toRemove.key);
        }

        
        Node newNode = new Node(key, value);
        cache.put(key, newNode);
        minFreq = 1; 
        
        freqMap.computeIfAbsent(1, k -> new DoublyLinkedList()).addFirst(newNode);
    }

    
    private void updateFrequency(Node node) {
        int oldFreq = node.freq;
        DoublyLinkedList oldList = freqMap.get(oldFreq);
        oldList.remove(node);

        if (oldFreq == minFreq && oldList.size == 0) {
            minFreq++;
        }

        node.freq++;
        freqMap.computeIfAbsent(node.freq, k -> new DoublyLinkedList()).addFirst(node);
    }
}