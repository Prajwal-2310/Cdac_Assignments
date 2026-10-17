public class Stack<T> {

    private Object[] arr;
    private int top;

    public Stack(int size) {
        arr = new Object[size];
        top = -1;
    }

    public void push(T val) {
        top++;
        arr[top] = val;
    }

    @SuppressWarnings("unchecked")
    public T pop() {
        return (T) arr[top--];
    }

    public boolean isEmpty() {
        return top == -1;
    }
}