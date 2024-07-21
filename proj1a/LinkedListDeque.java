public class LinkedListDeque<T> implements Deque<T> {
    private class Node {
        public T item;
        public Node prev;
        public Node next;

        public Node() {
            this.item = null;
            this.prev = null;
            this.next = null;
        }

        public Node(T item) {
            this.item = item;
            this.prev = null;
            this.next = null;
        }

        public Node(T item, Node prev, Node next) {
            this.item = item;
            this.prev = prev;
            this.next = next;
        }
    }

    public Node sentinel;
    public int size;

    public LinkedListDeque() {
        this.sentinel = new Node();
        this.sentinel.next = this.sentinel;
        this.sentinel.prev = this.sentinel;
        this.size = 0;
    }


    @Override
    public void addFirst(T item) {
        Node newNode = new Node(item, null, this.sentinel.next);
        if (this.isEmpty()){
            this.sentinel.prev = newNode;
            newNode.next = null;
        }
        this.sentinel.next = newNode;
        this.size += 1;
    }

    @Override
    public void addLast(T item) {
        Node newNode = new Node(item, this.sentinel.prev, null);
        if (this.isEmpty()){
            this.sentinel.next = newNode;
            newNode.prev = null;
        }
        this.sentinel.prev = newNode;
        this.size += 1;
    }

    @Override
    public boolean isEmpty() {
        return this.size == 0;
    }

    @Override
    public int size() {
        return this.size;
    }

    @Override
    public void printDeque() {
        Node pointer = this.sentinel.next;
        while (pointer != null) {
            System.out.print(pointer.item + " ");
            pointer = pointer.next;
        }
    }

    @Override
    public T removeFirst() {
        Node removedNode = this.sentinel.next;
        if (removedNode == null) {
            return null;
        }
        this.sentinel.next = removedNode.next;
        this.size -= 1;

        removedNode.next = null;
        removedNode.prev = null;
        return removedNode.item;
    }

    @Override
    public T removeLast() {
        Node removedNode = this.sentinel.prev;
        if (removedNode == null) {
            return null;
        }
        this.sentinel.prev = removedNode.prev;
        this.size -= 1;

        removedNode.next = null;
        removedNode.prev = null;
        return removedNode.item;
    }

    @Override
    public T get(int index) {
        Node pointer= this.sentinel.next;
        int counter = 0;
        if (index <= this.size || index < 0) {
            throw new IndexOutOfBoundsException("Out of bounds");
        }

        while (index != counter) {
            pointer = pointer.next;
            counter++;
        }
        return pointer.item;
    }

}
