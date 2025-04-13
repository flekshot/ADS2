import java.util.Iterator;

public class MyLinkedList<T extends Comparable<T>> implements MyList<T> {
    private class MyNode {
        T element;
        MyNode next;
        MyNode prev;

        MyNode(T element) {
            this.element = element;
        }
    }

    private MyNode head;
    private MyNode tail;
    private int size;

    public MyLinkedList() {
        head = null;
        tail = null;
        size = 0;
    }

    @Override
    public void add(T item) {
        addLast(item);
    }

    @Override
    public void add(int index, T item) {
        if (index < 0 || index > size) throw new IndexOutOfBoundsException();
        if (index == 0) {
            addFirst(item);
        } else if (index == size) {
            addLast(item);
        } else {
            MyNode node = getNode(index);
            MyNode newNode = new MyNode(item);
            newNode.prev = node.prev;
            newNode.next = node;
            node.prev.next = newNode;
            node.prev = newNode;
            size++;
        }
    }

    @Override
    public void addFirst(T item) {
        MyNode newNode = new MyNode(item);
        if (size == 0) {
            head = tail = newNode;
        } else {
            newNode.next = head;
            head.prev = newNode;
            head = newNode;
        }
        size++;
    }

    @Override
    public void addLast(T item) {
        MyNode newNode = new MyNode(item);
        if (size == 0) {
            head = tail = newNode;
        } else {
            newNode.prev = tail;
            tail.next = newNode;
            tail = newNode;
        }
        size++;
    }

    @Override
    public void set(int index, T item) {
        MyNode node = getNode(index);
        node.element = item;
    }

    @Override
    public T get(int index) {
        return getNode(index).element;
    }

    @Override
    public T getFirst() {
        if (size == 0) throw new IllegalStateException("List is empty");
        return head.element;
    }

    @Override
    public T getLast() {
        if (size == 0) throw new IllegalStateException("List is empty");
        return tail.element;
    }

    @Override
    public void remove(int index) {
        if (index < 0 || index >= size) throw new IndexOutOfBoundsException();
        if (index == 0) {
            removeFirst();
        } else if (index == size - 1) {
            removeLast();
        } else {
            MyNode node = getNode(index);
            node.prev.next = node.next;
            node.next.prev = node.prev;
            size--;
        }
    }

    @Override
    public void removeFirst() {
        if (size == 0) throw new IllegalStateException("List is empty");
        head = head.next;
        if (head == null) {
            tail = null;
        } else {
            head.prev = null;
        }
        size--;
    }

    @Override
    public void removeLast() {
        if (size == 0) throw new IllegalStateException("List is empty");
        tail = tail.prev;
        if (tail == null) {
            head = null;
        } else {
            tail.next = null;
        }
        size--;
    }

    @Override
    public void sort() {
        if (size <= 1) return;
        Object[] array = toArray();
        for (int i = 0; i < size - 1; i++) {
            for (int j = 0; j < size - i - 1; j++) {
                T a = (T) array[j];
                T b = (T) array[j + 1];
                if (a.compareTo(b) > 0) {
                    Object temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }
        clear();
        for (Object item : array) {
            add((T) item);
        }
    }

    @Override
    public int indexOf(Object object) {
        int index = 0;
        for (MyNode node = head; node != null; node = node.next) {
            if (object == null && node.element == null) return index;
            if (object != null && object.equals(node.element)) return index;
            index++;
        }
        return -1;
    }

    @Override
    public int lastIndexOf(Object object) {
        int index = size - 1;
        for (MyNode node = tail; node != null; node = node.prev) {
            if (object == null && node.element == null) return index;
            if (object != null && object.equals(node.element)) return index;
            index--;
        }
        return -1;
    }

    @Override
    public boolean exists(Object object) {
        return indexOf(object) != -1;
    }

    @Override
    public Object[] toArray() {
        Object[] result = new Object[size];
        int i = 0;
        for (MyNode node = head; node != null; node = node.next) {
            result[i++] = node.element;
        }
        return result;
    }

    @Override
    public void clear() {
        head = tail = null;
        size = 0;
    }

    @Override
    public int size() {
        return size;
    }

    private MyNode getNode(int index) {
        if (index < 0 || index >= size) throw new IndexOutOfBoundsException();
        MyNode node;
        if (index < size / 2) {
            node = head;
            for (int i = 0; i < index; i++) node = node.next;
        } else {
            node = tail;
            for (int i = size - 1; i > index; i--) node = node.prev;
        }
        return node;
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            private MyNode current = head;

            @Override
            public boolean hasNext() {
                return current != null;
            }

            @Override
            public T next() {
                T item = current.element;
                current = current.next;
                return item;
            }
        };
    }
}