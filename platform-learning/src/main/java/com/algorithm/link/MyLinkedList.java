package com.algorithm.link;

class MyLinkedList {

    public static class SinglyListNode {
        private int value;
        private SinglyListNode next;

        public SinglyListNode(int value) {
            this.value = value;
        }

        public int getValue() {
            return value;
        }

        public void setValue(int value) {
            this.value = value;
        }

        public SinglyListNode getNext() {
            return next;
        }

        public void setNext(SinglyListNode next) {
            this.next = next;
        }
    }

    private SinglyListNode head;
    private SinglyListNode tail;
    private int size;

    /**
     * Get the value of the index-th node in the linked list. If the index is invalid, return -1.
     */
    public int get(int index) {
        if (index < 0 || index >= size) {
            return -1;
        }
        SinglyListNode cur = head;
        for (int i = 0; i < index; i++) {
            cur = cur.getNext();
        }
        return cur.getValue();
    }

    /**
     * Add a node of value val before the first element of the linked list. After the insertion, the new node will be the first node of the linked list.
     */
    public void addAtHead(int val) {
        SinglyListNode cur = new SinglyListNode(val);
        if (size == 0) {
            head = cur;
            tail = cur;
        } else {
            cur.setNext(head);
            head = cur;
        }
        size++;
    }

    /**
     * Append a node of value val to the last element of the linked list.
     */
    public void addAtTail(int val) {
        SinglyListNode cur = new SinglyListNode(val);
        if (size == 0) {
            head = cur;
            tail = cur;
        } else {
            tail.setNext(cur);
            tail = cur;
        }
        size++;
    }

    /**
     * Add a node of value val before the index-th node in the linked list. If index equals to the length of linked list, the node will be appended to the end of linked list. If index is greater than the length, the node will not be inserted.
     */
    public void addAtIndex(int index, int val) {
        SinglyListNode cur = new SinglyListNode(val);
        // add head
        if (size == 0) {
            head = cur;
            tail = cur;
        } else if (index <= 0) {
            cur.setNext(head);
            head = cur;
        } else if (index == size) {
            tail.setNext(cur);
            tail = cur;
        } else {
            SinglyListNode nodePrev = getNodePrev(index - 1);
            cur.setNext(nodePrev.getNext());
            nodePrev.setNext(cur);
        }
        size++;
    }

    /**
     * Delete the index-th node in the linked list, if the index is valid.
     */
    public void deleteAtIndex(int index) {
        if (index < 0 || index >= size) {
            return;
        }
        SinglyListNode delCurNode = null;
        if (index == 0) {
            // del head
            delCurNode = head;
            head = head.getNext();
        } else if (index == size - 1) {
            // del tail
            SinglyListNode prevNode = getNodePrev(index - 1);
            delCurNode = prevNode.getNext();
            prevNode.setNext(null);
            tail = prevNode;
        } else {
            SinglyListNode prevNode = getNodePrev(index - 1);
            SinglyListNode nextNode = prevNode.getNext().getNext();
            delCurNode = prevNode.getNext();
            prevNode.setNext(nextNode);
        }
        size--;
    }

    // 获取插入节点的前一个节点
    public SinglyListNode getNodePrev(int index) {
        if (index < 0 || index >= size) {
            return null;
        }
        SinglyListNode cur = head;
        for (int i = 0; i < index; i++) {
            cur = cur.getNext();
        }
        return cur;
    }
}
