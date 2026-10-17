import java.util.*;

public class QueueArray {
    private int[] queue;
    private int front;
    private int rear;

    public QueueArray(int size){
        queue = new int [size];
        front = -1;
        rear = -1;
    }

    public boolean isEmpty(){
        return front == -1;
    }

    public boolean isFull(){
        return rear == queue.length -1;
    }

    public void enqueue(int val){
        if (isFull()) {
            System.out.println("Queue is Full");
            return ;
        }

        if (front == -1) {
            front = 0;
        }

        rear++;
        queue[rear] = val;

        System.out.println(val+" added in Queue");
    }

    public void dequeue(){
        if (isEmpty() || front > rear) {
            System.out.println("Queue is Empty");
            return ;
        }
        System.out.println(queue[front] +" Dequeued Successfully");
        front++;

        if (front > rear) {
            front = -1;
            rear = -1;
        }
    }

    public void peek(){
        if (isEmpty()) {
            System.out.println("Queue is Empty");
            return ;
        }

        System.out.println("Front Element: "+queue[front]);
    }

    public void display(){
        if (isEmpty()) {
            System.out.println("Queue is Empty");
            return; 
        }

        for(int i = front; i<= rear; i++){
            System.out.println(queue[i]+" ");
        }
        System.out.println();
    }

      public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter queue size: ");
        int size = sc.nextInt();

        QueueArray q = new QueueArray(size);

        int choice;

        do {

            System.out.println("\n===== QUEUE MENU =====");
            System.out.println("1. Enqueue");
            System.out.println("2. Dequeue");
            System.out.println("3. Peek");
            System.out.println("4. Display");
            System.out.println("5. Check Empty");
            System.out.println("6. Check Full");
            System.out.println("0. Exit");

            System.out.print("Enter your choice: ");
            choice = sc.nextInt();

            switch (choice) {

                case 1:
                    System.out.print("Enter value: ");
                    int value = sc.nextInt();
                    q.enqueue(value);
                    break;

                case 2:
                    q.dequeue();
                    break;

                case 3:
                    q.peek();
                    break;

                case 4:
                    q.display();
                    break;

                case 5:
                    if (q.isEmpty())
                        System.out.println("Queue is Empty");
                    else
                        System.out.println("Queue is not Empty");
                    break;

                case 6:
                    if (q.isFull())
                        System.out.println("Queue is Full");
                    else
                        System.out.println("Queue is not Full");
                    break;

                case 0:
                    System.out.println("Exiting...");
                    break;

                default:
                    System.out.println("Invalid choice");
            }

        } while (choice != 0);

        sc.close();
    }
}
