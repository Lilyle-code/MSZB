class MyLinkedList {
public:
    struct LinkedNode {
        int val;
        LinkedNode* next;
        LinkedNode() :val(NULL), next(nullptr) {}
        LinkedNode(int x) :val(x), next(nullptr) {}
        LinkedNode(int x, LinkedNode* y) : val(x), next(y) {}
    };

    MyLinkedList() {
        _dummy = new LinkedNode(0);
        _size = 0;
    }

    int get(int index) {
        if (index < 0 || index >(_size - 1)) {
            return -1;
        }
        LinkedNode* cur = _dummy->next;
        while (index--) {
            cur = cur->next;
        }
        return cur->val;
    }

    void addAtHead(int val) {
        LinkedNode* newnode = new LinkedNode(val);
        newnode->next = _dummy->next;
        _dummy->next = newnode;
        _size++;
    }

    void addAtTail(int val) {
        LinkedNode* newnode = new LinkedNode(val);
        LinkedNode* cur = _dummy;
        while (cur->next != nullptr) {
            cur = cur->next;
        }
        cur->next = newnode;
        _size++;
    }

    void addAtIndex(int index, int val) {
        if (index > _size) return;
        if (index < 0) index = 0;
        LinkedNode* newnode = new LinkedNode(val);
        LinkedNode* cur = _dummy;
        while (index--) {
            cur = cur->next;
        }
        newnode->next = cur->next;
        cur->next = newnode;
        _size++;
    }

    void deleteAtIndex(int index) {
        if (index > (_size - 1) || index < 0) {
            return;
        }
        LinkedNode* tmp = new LinkedNode();
        LinkedNode* cur = _dummy;
        while (index--) {
            cur = cur->next;
        }
        tmp = cur->next;
        cur->next = cur->next->next;
        delete tmp;
        _size--;
    }
private:
    LinkedNode* _dummy;
    int _size;
};

/**
 * Your MyLinkedList object will be instantiated and called as such:
 * MyLinkedList* obj = new MyLinkedList();
 * int param_1 = obj->get(index);
 * obj->addAtHead(val);
 * obj->addAtTail(val);
 * obj->addAtIndex(index,val);
 * obj->deleteAtIndex(index);
 */