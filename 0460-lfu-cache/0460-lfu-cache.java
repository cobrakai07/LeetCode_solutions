class Node {
    int key, value, freq;
    Node prev, next;

    Node(int k, int v) {
        key = k;
        value = v;
        freq = 1;
    }
}

class LFUCache {
    int capacity, size, minFreq;
    Map<Integer, Node> nodeMap;
    Map<Integer, LinkedHashSet<Node>> freqMap;

    public LFUCache(int capacity) {
        this.capacity = capacity;
        this.size = 0;
        this.minFreq = 0;
        this.nodeMap = new HashMap<>();
        this.freqMap = new HashMap<>();
    }

    public int get(int key) {
        Node node = nodeMap.get(key);
        if (node == null) return -1;
        updateFreq(node);
        return node.value;
    }

    public void put(int key, int value) {
        if (capacity == 0) return;

        Node node;
        if (nodeMap.containsKey(key)) {
            node = nodeMap.get(key);
            node.value = value;
            updateFreq(node);
        } else {
            if (size == capacity) {
                removeLFUNode();
            }
            node = new Node(key, value);
            nodeMap.put(key, node);
            freqMap.computeIfAbsent(1, k -> new LinkedHashSet<>()).add(node);
            minFreq = 1;
            size++;
        }
    }

    private void updateFreq(Node node) {
        int freq = node.freq;
        LinkedHashSet<Node> set = freqMap.get(freq);
        set.remove(node);
        if (set.isEmpty() && freq == minFreq) {
            minFreq++;
        }
        node.freq++;
        freqMap.computeIfAbsent(node.freq, k -> new LinkedHashSet<>()).add(node);
    }

    private void removeLFUNode() {
        LinkedHashSet<Node> set = freqMap.get(minFreq);
        Node node = set.iterator().next();
        set.remove(node);
        if (set.isEmpty()) {
            freqMap.remove(minFreq);
        }
        nodeMap.remove(node.key);
        size--;
    }
}

/**
 * Your LFUCache object will be instantiated and called as such:
 * LFUCache obj = new LFUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key, value);
 */
