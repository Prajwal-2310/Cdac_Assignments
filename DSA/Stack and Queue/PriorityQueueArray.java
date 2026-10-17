import java.util.Scanner;

public class PriorityQueueArray {

    static class Item {
        int data;
        int priority;

        Item(int data, int priority) {
            this.data = data;
            this.priority = priority;
        }
    }

    private Item[] queue;
    private int rear;
    private int size;

    public PriorityQueueArray(int size) {
        this.size = size;
        queue = new Item[size];
        rear = -1;
    }

    public void enqueue(int data, int priority) {

        if (rear == size - 1) {
            System.out.println("Priority Queue is Full");
            return;
        }

        rear++;

        queue[rear] = new Item(data, priority);

        System.out.println(data + " inserted with priority " + priority);
    }

    public void dequeue() {

        if (rear == -1) {
            System.out.println("Priority Queue is Empty");
            return;
        }

        // Find highest priority
        int highest = 0;

        for (int i = 1; i <= rear; i++) {
            if (queue[i].priority < queue[highest].priority) {
                highest = i;
            }
        }

        System.out.println(
                queue[highest].data +
                " removed with priority " +
                queue[highest].priority
        );

        // Shift elements
        for (int i = highest; i < rear; i++) {
            queue[i] = queue[i + 1];
        }

        rear--;
    }

    public void peek() {

        if (rear == -1) {
            System.out.println("Priority Queue is Empty");
            return;
        }

        int highest = 0;

        for (int i = 1; i <= rear; i++) {
            if (queue[i].priority < queue[highest].priority) {
                highest = i;
            }
        }

        System.out.println(
                "Element: " + queue[highest].data +
                ", Priority: " + queue[highest].priority
        );
    }

    public void display() {

        if (rear == -1) {
            System.out.println("Priority Queue is Empty");
            return;
        }

        for (int i = 0; i <= rear; i++) {
            System.out.println(
                    "Data: " + queue[i].data +
                    " | Priority: " + queue[i].priority
            );
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter size: ");
        int size = sc.nextInt();

        PriorityQueueArray pq = new PriorityQueueArray(size);

        int choice;

        do {
            System.out.println("\n===== PRIORITY QUEUE =====");
            System.out.println("1. Enqueue");
            System.out.println("2. Dequeue");
            System.out.println("3. Peek");
            System.out.println("4. Display");
            System.out.println("0. Exit");

            System.out.print("Enter choice: ");
            choice = sc.nextInt();

            switch (choice) {

                case 1:
                    System.out.print("Enter data: ");
                    int data = sc.nextInt();

                    System.out.print("Enter priority: ");
                    int priority = sc.nextInt();

                    pq.enqueue(data, priority);
                    break;

                case 2:
                    pq.dequeue();
                    break;

                case 3:
                    pq.peek();
                    break;

                case 4:
                    pq.display();
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