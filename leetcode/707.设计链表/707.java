class MyLinkedList {
    private int _size; 
    private LinkedNode dummy_head;

    class LinkedNode{
        int val;
        LinkedNode next;
        LinkedNode(){}
        LinkedNode(int val){
            this.val = val; 
        }
        LinkedNode(int val, LinkedNode next){
            this.val = val;
            this.next = next;
        }
    }

    public MyLinkedList() {
        this._size = 0;
        this.dummy_head = new LinkedNode(0);
    }
    
    public int get(int index) {
        if(index < 0 || index > (_size - 1)){
            return -1;
        }
        LinkedNode cur = dummy_head.next;
        while(--index >= 0){
            cur = cur.next;
        }
        return cur.val;
    }
    
    public void addAtHead(int val) {
        LinkedNode newnode = new LinkedNode(val);
        newnode.next = dummy_head.next;
        dummy_head.next = newnode;
        _size++;
    }
    
    public void addAtTail(int val) {
        LinkedNode newnode = new LinkedNode(val);
        LinkedNode cur = dummy_head;
        while(cur.next != null){
            cur = cur.next;
        }
        cur.next = newnode;
        _size++;
    }
    
    public void addAtIndex(int index, int val) {
        if(index > _size) return;
        if(index < 0) index = 0;
        LinkedNode newnode = new LinkedNode(val);
        LinkedNode cur = dummy_head;
        while(--index >= 0){
            cur = cur.next;
        }
        newnode.next = cur.next;
        cur.next = newnode;
        _size++;
    }
    
    public void deleteAtIndex(int index) {
        if(index < 0 || index > (_size - 1)) return ;
        LinkedNode cur = dummy_head;
        while(--index >= 0){
            cur = cur.next;
            // index -= 1;
        }
        cur.next = cur.next.next;
        _size--;
    }
}

/**
 * Your MyLinkedList object will be instantiated and called as such:
 * MyLinkedList obj = new MyLinkedList();
 * int param_1 = obj.get(index);
 * obj.addAtHead(val);
 * obj.addAtTail(val);
 * obj.addAtIndex(index,val);
 * obj.deleteAtIndex(index);
 */