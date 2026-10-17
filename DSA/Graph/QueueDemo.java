public class QueueDemo<T> {
    private Object arr[];
    private int rear;
    private int front;

    public QueueDemo(int size){
        arr = new Object[size];
        front = 0;
        rear = -1;
    }

    public void offer(T val){
        rear++;
        arr[rear] = val;
    }

    @SuppressWarnings("unchecked")
    public T poll(){
        return (T) arr[front++];
    }

    public boolean isEmpty(){
        return rear < front;
    }
}
