import java.util.Scanner;

public class CircularQueue {

    private int[] queue;
    private int front;
    private int rear;
    private int size;

    public CircularQueue(int size) {
        this.size = size;
        queue = new int[size];

        front = -1;
        rear = -1;
    }

    // Enqueue
    public void enqueue(int value) {

        // Queue is full
        if ((rear + 1) % size == front) {
            System.out.println("Queue is Full");
            return;
        }

        // First element
        if (front == -1) {
            front = 0;
            rear = 0;
        }
        else {
            rear = (rear + 1) % size;
        }

        queue[rear] = value;

        System.out.println(value + " inserted into queue");
    }

    // Dequeue
    public void dequeue() {

        // Queue is empty
        if (front == -1) {
            System.out.println("Queue is Empty");
            return;
        }

        int value = queue[front];

        // Only one element was present
        if (front == rear) {
            front = -1;
            rear = -1;
        }
        else {
            front = (front + 1) % size;
        }

        System.out.println(value + " removed from queue");
    }

    // Peek
    public void peek() {

        if (front == -1) {
            System.out.println("Queue is Empty");
            return;
        }

        System.out.println("Front element: " + queue[front]);
    }

    // Display
    public void display() {

        if (front == -1) {
            System.out.println("Queue is Empty");
            return;
        }

        System.out.println("Queue elements:");

        int i = front;

        while (true) {

            System.out.print(queue[i] + " ");

            if (i == rear) {
                break;
            }

            i = (i + 1) % size;
        }

        System.out.println();
    }

    // Check Empty
    public boolean isEmpty() {
        return front == -1;
    }

    // Check Full
    public boolean isFull() {
        return (rear + 1) % size == front;
    }


    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter queue size: ");
        int size = sc.nextInt();

        CircularQueue q = new CircularQueue(size);

        int choice;

        do {

            System.out.println("\n===== CIRCULAR QUEUE MENU =====");
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
                    System.out.println("Invalid Choice");
            }

        } while (choice != 0);

        sc.close();
    }
}
