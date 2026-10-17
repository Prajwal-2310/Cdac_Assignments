import java.util.Scanner;

public class DequeArray {

    private int[] deque;
    private int front;
    private int rear;
    private int size;

    public DequeArray(int size) {
        this.size = size;
        deque = new int[size];

        front = -1;
        rear = -1;
    }

    public boolean isEmpty() {
        return front == -1;
    }

    public boolean isFull() {
        return (rear + 1) % size == front;
    }

    // Insert at front
    public void insertFront(int value) {

        if (isFull()) {
            System.out.println("Deque is Full");
            return;
        }

        if (isEmpty()) {
            front = 0;
            rear = 0;
        }
        else {
            front = (front - 1 + size) % size;
        }

        deque[front] = value;

        System.out.println(value + " inserted at front");
    }

    // Insert at rear
    public void insertRear(int value) {

        if (isFull()) {
            System.out.println("Deque is Full");
            return;
        }

        if (isEmpty()) {
            front = 0;
            rear = 0;
        }
        else {
            rear = (rear + 1) % size;
        }

        deque[rear] = value;

        System.out.println(value + " inserted at rear");
    }

    // Delete from front
    public void deleteFront() {

        if (isEmpty()) {
            System.out.println("Deque is Empty");
            return;
        }

        System.out.println(deque[front] + " deleted from front");

        if (front == rear) {
            front = -1;
            rear = -1;
        }
        else {
            front = (front + 1) % size;
        }
    }

    // Delete from rear
    public void deleteRear() {

        if (isEmpty()) {
            System.out.println("Deque is Empty");
            return;
        }

        System.out.println(deque[rear] + " deleted from rear");

        if (front == rear) {
            front = -1;
            rear = -1;
        }
        else {
            rear = (rear - 1 + size) % size;
        }
    }

    public void getFront() {

        if (isEmpty()) {
            System.out.println("Deque is Empty");
            return;
        }

        System.out.println("Front: " + deque[front]);
    }

    public void getRear() {

        if (isEmpty()) {
            System.out.println("Deque is Empty");
            return;
        }

        System.out.println("Rear: " + deque[rear]);
    }

    public void display() {

        if (isEmpty()) {
            System.out.println("Deque is Empty");
            return;
        }

        int i = front;

        while (true) {

            System.out.print(deque[i] + " ");

            if (i == rear)
                break;

            i = (i + 1) % size;
        }

        System.out.println();
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter deque size: ");
        int size = sc.nextInt();

        DequeArray dq = new DequeArray(size);

        int choice;

        do {

            System.out.println("\n===== DEQUE MENU =====");
            System.out.println("1. Insert Front");
            System.out.println("2. Insert Rear");
            System.out.println("3. Delete Front");
            System.out.println("4. Delete Rear");
            System.out.println("5. Get Front");
            System.out.println("6. Get Rear");
            System.out.println("7. Display");
            System.out.println("0. Exit");

            System.out.print("Enter choice: ");
            choice = sc.nextInt();

            switch (choice) {

                case 1:
                    System.out.print("Enter value: ");
                    dq.insertFront(sc.nextInt());
                    break;

                case 2:
                    System.out.print("Enter value: ");
                    dq.insertRear(sc.nextInt());
                    break;

                case 3:
                    dq.deleteFront();
                    break;

                case 4:
                    dq.deleteRear();
                    break;

                case 5:
                    dq.getFront();
                    break;

                case 6:
                    dq.getRear();
                    break;

                case 7:
                    dq.display();
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