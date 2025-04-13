public class MyStack<T extends Comparable<T>> {
    private MyArrayList<T> list;

    public MyStack() {
        list = new MyArrayList<>();
    }


    public void push(T item) {
        list.addLast(item);
    }


    public T pop() {
        if (isEmpty()) throw new IllegalStateException("Stack is empty");
        T item = list.getLast();
        list.removeLast();
        return item;
    }

    public T peek() {
        if (isEmpty()) throw new IllegalStateException("Stack is empty");
        return list.getLast();
    }

    public boolean isEmpty() {
        return list.size() == 0;
    }

    public int size() {
        return list.size();
    }
}