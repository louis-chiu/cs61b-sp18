public class LinkedListDeque<T> {
    private class Node {
        private T item;
        private Node prev;
        private Node next;

        Node() {
            this.item = null;
            this.prev = null;
            this.next = null;
        }

        Node(T item) {
            this.item = item;
            this.prev = null;
            this.next = null;
        }

        Node(T item, Node prev, Node next) {
            this.item = item;
            this.prev = prev;
            this.next = next;
        }
    }

    private Node sentinel;
    private int size;

    /**
     * When the linkedList
     * - Empty: the `sentinel.next` and `sentinel.prev` will point to sentinel itself.
     * - Else:
     * - the `sentinel.next` points to the front node.
     * - the `sentinel.prev` points to the back node.
     */
    public LinkedListDeque() {
        this.sentinel = new Node();
        this.sentinel.next = this.sentinel;
        this.sentinel.prev = this.sentinel;
        this.size = 0;
    }


    public void addFirst(T item) {
        Node nextNode = this.sentinel.next;
        Node newNode = new Node(item, null, nextNode);
        if (this.isEmpty()) {
            this.sentinel.prev = newNode;
            newNode.next = null;
        } else {
            nextNode.prev = newNode;
        }
        this.sentinel.next = newNode;
        this.size += 1;
    }

    public void addLast(T item) {
        Node prevNode = this.sentinel.prev;
        Node newNode = new Node(item, prevNode, null);
        if (this.isEmpty()) {
            this.sentinel.next = newNode;
            newNode.prev = null;
        } else {
            prevNode.next = newNode;
        }
        this.sentinel.prev = newNode;
        this.size += 1;
    }

    public boolean isEmpty() {
        return this.size == 0;
    }

    public int size() {
        return this.size;
    }

    public void printDeque() {
        Node pointer = this.sentinel.next;
        while (pointer != null) {
            System.out.print(pointer.item + " ");
            pointer = pointer.next;
        }
        System.out.println();
    }

    public T removeFirst() {
        Node removedNode = this.sentinel.next;
        if (this.isEmpty()) {
            return null;
        }
        this.sentinel.next = removedNode.next;
        this.size -= 1;

        // release removeNode reference
        removedNode.prev = null;

        Node nextNode = removedNode.next;
        if (nextNode != null) {
            nextNode.prev = null;
            removedNode.next = null;
        }
        return removedNode.item;
    }

    public T removeLast() {
        Node removedNode = this.sentinel.prev;
        if (this.isEmpty()) {
            return null;
        }
        this.sentinel.prev = removedNode.prev;
        this.size -= 1;

        // release removedNode reference
        removedNode.next = null;

        Node prevNode = removedNode.prev;
        if (prevNode != null) {
            prevNode.next = null;
            removedNode.prev = null;
        }
        return removedNode.item;
    }

    public T get(int index) {
        if (this.isEmpty() || index >= this.size || index < 0) {
            return null;
        }

        Node pointer = this.sentinel.next;
        int counter = 0;

        while (index != counter) {
            pointer = pointer.next;
            counter++;
        }
        return pointer.item;
    }

    public T getRecursive(int index) {
        if (this.isEmpty() || index >= this.size || index < 0) {
            return null;
        }
        Node firstNode = this.sentinel.next;

        return getTheNextNode(firstNode, index).item;
    }

    private Node getTheNextNode(Node node, int distanceIndex) {
        if (distanceIndex == 0) {
            return node;
        }
        return getTheNextNode(node.next, distanceIndex - 1);
    }

}
