import java.util.Scanner;

public class OfficePrinterQueue {

    public static class Job {
        int jobId;
        String empName;
        int pages;

        Job(int jobId, String empName, int pages) {
            this.jobId = jobId;
            this.empName = empName;
            this.pages = pages;
        }
    }

    public static class Node {
        Job job;
        Node next;

        Node(Job job) {
            this.job = job;
            next = null;
        }
    }

    private Node front;
    private Node rear;
    private int count = 0;

    public OfficePrinterQueue() {
        front = null;
        rear = null;
        count = 0;
    }

    // Add Job at Rear
    public void enqueue(Job job) {

        Node newNode = new Node(job);

        if (rear == null) {
            front = rear = newNode;
        } else {
            rear.next = newNode;
            rear = newNode;
        }

        count++;
    }

    // Remove Job From Front
    public Job dequeue() {

        if (front == null) {
            return null;
        }

        Job job = front.job;

        front = front.next;

        if (front == null) {
            rear = null;
        }

        count--;

        return job;
    }

    // View First Job
    public Job peek() {

        if (front == null) {
            return null;
        }

        return front.job;
    }

    // Check if Queue is Empty
    public boolean isEmpty() {
        return front == null;
    }

    // Return Queue Size
    public int size() {
        return count;
    }

    // Cancel Job
    public boolean cancel(int jobId) {

        if (isEmpty()) {
            return false;
        }

        // Cancel first job
        if (front.job.jobId == jobId) {

            front = front.next;

            if (front == null) {
                rear = null;
            }

            count--;

            return true;
        }

        Node prev = front;
        Node curr = front.next;

        while (curr != null) {

            if (curr.job.jobId == jobId) {

                prev.next = curr.next;

                // If deleting last node
                if (curr == rear) {
                    rear = prev;
                }

                count--;

                return true;
            }

            prev = curr;
            curr = curr.next;
        }

        return false;
    }

    // Print Schedule
    public void printSchedule() {

        Node temp = front;

        int currentTime = 0;

        while (temp != null) {

            Job job = temp.job;

            // 1 page = 6 seconds
            int printingTime = job.pages * 6;

            currentTime += printingTime;

            System.out.println(
                "Job " + job.jobId +
                " | Employee: " + job.empName +
                " | Pages: " + job.pages +
                " | Finish Time: " + currentTime + " seconds"
            );

            temp = temp.next;
        }
    }

    // Display Queue
    public void display() {

        Node temp = front;

        if (temp == null) {
            System.out.println("Queue is Empty");
            return;
        }

        while (temp != null) {

            System.out.println(
                "Job ID: " + temp.job.jobId +
                ", Employee: " + temp.job.empName +
                ", Pages: " + temp.job.pages
            );

            temp = temp.next;
        }
    }

    // Main Method
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        OfficePrinterQueue queue = new OfficePrinterQueue();

        int choice;

        do {

            System.out.println("\n===== OFFICE PRINTER QUEUE =====");
            System.out.println("1. Add Job");
            System.out.println("2. Print Job (Dequeue)");
            System.out.println("3. View Next Job");
            System.out.println("4. Cancel Job");
            System.out.println("5. Display Queue");
            System.out.println("6. Print Schedule");
            System.out.println("7. Queue Size");
            System.out.println("8. Check Empty");
            System.out.println("0. Exit");

            System.out.print("Enter choice: ");
            choice = sc.nextInt();

            switch (choice) {

                case 1:

                    System.out.print("Enter Job ID: ");
                    int id = sc.nextInt();

                    sc.nextLine();

                    System.out.print("Enter Employee Name: ");
                    String name = sc.nextLine();

                    System.out.print("Enter Number of Pages: ");
                    int pages = sc.nextInt();

                    Job job = new Job(id, name, pages);

                    queue.enqueue(job);

                    System.out.println("Job added successfully.");

                    break;

                case 2:

                    Job removed = queue.dequeue();

                    if (removed == null) {
                        System.out.println("Queue is empty.");
                    } else {
                        System.out.println(
                            "Printing Job " + removed.jobId +
                            " of " + removed.empName
                        );
                    }

                    break;

                case 3:

                    Job next = queue.peek();

                    if (next == null) {
                        System.out.println("Queue is empty.");
                    } else {
                        System.out.println(
                            "Next Job: " + next.jobId +
                            " | Employee: " + next.empName +
                            " | Pages: " + next.pages
                        );
                    }

                    break;

                case 4:

                    System.out.print("Enter Job ID to cancel: ");
                    int cancelId = sc.nextInt();

                    if (queue.cancel(cancelId)) {
                        System.out.println("Job cancelled successfully.");
                    } else {
                        System.out.println("Job not found.");
                    }

                    break;

                case 5:

                    queue.display();

                    break;

                case 6:

                    System.out.println("\n===== PRINT SCHEDULE =====");

                    queue.printSchedule();

                    break;

                case 7:

                    System.out.println("Queue Size: " + queue.size());

                    break;

                case 8:

                    if (queue.isEmpty()) {
                        System.out.println("Queue is empty.");
                    } else {
                        System.out.println("Queue is not empty.");
                    }

                    break;

                case 0:

                    System.out.println("Program terminated.");

                    break;

                default:

                    System.out.println("Invalid choice.");
            }

        } while (choice != 0);

        sc.close();
    }
}