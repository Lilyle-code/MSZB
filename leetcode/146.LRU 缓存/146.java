class LRUCache {
    private static class Node{
        int key, value;
        Node pre, next;
        Node(int k, int v){
            this.key = k;
            this.value = v;
        }
    }
    private final int capacity;
    private final Map<Integer, Node> map = new HashMap<>();
    private final Node dummynode = new Node(0, 0);
    public LRUCache(int capacity){
        this.capacity = capacity;
        dummynode.next = dummynode;
        dummynode.pre = dummynode;
    }
    public int get(int key){
        Node node = getNode(key);
        return node == null ? -1: node.value;
    }
    public void put(int key, int value){
        Node node = getNode(key);
        if(node != null){
            node.value = value;
            return;
        }
        node = new Node(key, value);
        map.put(key, node);
        pushFirst(node);
        if(map.size() > capacity){
            remove(dummynode.pre);
        }
    }
    private Node getNode(int key){
        if(map.containsKey(key)){
            Node node = map.get(key);
            remove(node);
            pushFirst(node);
            // map.remove(key);
            return node;
        }
        return null;
    }
    private void remove(Node node){
        node.pre.next = node.next;
        node.next.pre = node.pre;
        map.remove(node.key);
    }
    private void pushFirst(Node node){
        node.pre = dummynode;
        node.next = dummynode.next;
        node.pre.next = node;
        node.next.pre = node;
        map.put(node.key,node);
    }
}
