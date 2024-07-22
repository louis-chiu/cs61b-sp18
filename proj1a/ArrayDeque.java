@SuppressWarnings("unchecked")
public class ArrayDeque<T> {
    private T[] items;
    private int indexFront;
    private int indexBack;
    private int size;

    public ArrayDeque() {
        items = (T[]) new Object[8];
        this.size = 0;
        this.indexFront = 4;
        this.indexBack = 5;
    }

    private void resize(int newSize) {
        T[] newItems = (T[]) new Object[newSize];

        if (this.indexFront > this.indexBack) {
            /* indexFront is in right hand side of indexBack */
            int numOfEleAfterIdxFront = this.items.length - this.indexFront - 1;
            System.arraycopy(this.items, getPointerIndexAfterMoveToRight(this.indexFront),
                    newItems, 1, numOfEleAfterIdxFront);
            System.arraycopy(this.items, 0, newItems, numOfEleAfterIdxFront + 1, this.indexBack);
        } else {
            /* indexFront is in left hand side of indexBack */
            System.arraycopy(this.items, getIndexOfFirst(),
                    newItems, 1, this.size);
        }
        this.indexFront = 0;
        this.indexBack = this.size + 1;
        this.items = newItems;
    }

    public void addFirst(T item) {
        if (((double) this.size) / this.items.length >= 0.25) {
            resize(this.items.length * 2);
        }

        this.items[this.indexFront] = item;
        this.indexFront = getPointerIndexAfterMoveToLeft(this.indexFront);
        this.size++;
    }

    public void addLast(T item) {
        if (((double) this.size) / this.items.length >= 0.25) {
            resize(this.items.length * 2);
        }

        this.items[this.indexBack] = item;
        this.indexBack = getPointerIndexAfterMoveToRight(this.indexBack);
        this.size++;
    }

    public boolean isEmpty() {
        return this.size == 0;
    }

    public int size() {
        return this.size;
    }

    public void printDeque() {
        for (int i = this.indexFront + 1; i < this.indexBack; i++) {
            System.out.println(this.items[i] + " ");
        }
    }

    public T removeFirst() {
        if (this.items.length > 8 && ((double) this.size) / this.items.length < 0.25) {
            this.resize(this.items.length / 2);
        }
        T removedItem = this.items[getIndexOfFirst()];
        this.items[getIndexOfFirst()] = null;
        this.indexFront = getPointerIndexAfterMoveToRight(this.indexFront);
        this.size -= 1;
        return removedItem;
    }

    public T removeLast() {
        if (this.items.length > 8 && ((double) this.size) / this.items.length < 0.25) {
            this.resize(this.items.length / 2);
        }
        T removedItem = this.items[getIndexOfLast()];
        this.items[getIndexOfLast()] = null;
        this.indexBack = getPointerIndexAfterMoveToLeft(this.indexBack);
        this.size -= 1;
        return removedItem;
    }

    public T get(int index) {
        return this.items[getPointerIndexAfterMoveToRight(this.getIndexOfFirst(), index)];
    }

    /**
     * Get the index of the first element.
     * @return index
     */
    private int getIndexOfFirst() {
        return getPointerIndexAfterMoveToRight(this.indexFront);
    }

    /**
     * Get the index of the last element.
     * @return index
     */
    private int getIndexOfLast() {
        return getPointerIndexAfterMoveToLeft(this.indexBack);
    }

    /**
     * Get the next index after pointer move to left circularly.
     * @param index current index of pointer
     * @return next index
     */
    private int getPointerIndexAfterMoveToLeft(int index) {
        return (index - 1 + this.items.length) % this.items.length;
    }

    /**
     * Get the next index after pointer move to left circularly.
     * @param index current index of pointer
     * @param numberOfSteps the number of move steps
     * @return next index
     */
    private int getPointerIndexAfterMoveToLeft(int index, int numberOfSteps) {
        return (index - numberOfSteps + this.items.length) % this.items.length;
    }

    /**
     * Get the next index after pointer move to right circularly.
     * @param index current index of pointer
     * @return next index
     */
    private int getPointerIndexAfterMoveToRight(int index) {
        return (index + 1) % this.items.length;
    }

    /**
     * Get the next index after pointer move to right circularly.
     * @param index current index of pointer
     * @param numberOfSteps the number of move steps
     * @return next index
     */
    private int getPointerIndexAfterMoveToRight(int index, int numberOfSteps) {
        return (index + numberOfSteps) % this.items.length;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < this.size(); i++) {
            T t = this.get(i);
            sb.append(t);
            if (i != this.size() - 1) {
                sb.append(", ");
            }
        }
        return sb.toString();
    }
}
