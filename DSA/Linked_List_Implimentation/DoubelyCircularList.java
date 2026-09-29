import java.util.Scanner;

public class DoubelyCircularList {

    static class Node {

        private int data;
        private Node next;
        private Node prev;

        public Node() {
            data = 0;
            next = null;
            prev = null;
        }

        public Node(int val) {
            data = val;
            next = null;
            prev = null;
        }
    }

    private Node head;

    public DoubelyCircularList() {
        head = null;
    }

    public boolean isEmpty() {
        return head == null;
    }

    // =========================================================
    // DISPLAY FORWARD
    // =========================================================

    public void displayForward() {

        if (isEmpty()) {
            System.out.println("List is Empty");
            return;
        }

        Node trav = head;

        // ⭐ CHANGE: no trav != null
        do {
            System.out.println(trav.data);
            trav = trav.next;
        } while (trav != head);
    }

    // =========================================================
    // DISPLAY BACKWARD
    // =========================================================

    public void displayBackward() {

        if (isEmpty()) {
            System.out.println("List is Empty");
            return;
        }

        // ⭐ CHANGE: Last node is head.prev
        Node trav = head.prev;

        // ⭐ CHANGE: stop when we reach last node again
        do {
            System.out.println(trav.data);
            trav = trav.prev;
        } while (trav != head.prev);
    }

    // =========================================================
    // ADD FIRST
    // =========================================================

    public void addFirst(int val) {

        Node newNode = new Node(val);

        if (isEmpty()) {

            // ⭐ CHANGE: first node points to itself
            newNode.next = newNode;
            newNode.prev = newNode;

            head = newNode;

        } else {

            // ⭐ CHANGE: last node = head.prev
            Node last = head.prev;

            newNode.next = head;
            newNode.prev = last;

            // ⭐ CHANGE: connect last with new node
            last.next = newNode;

            // ⭐ CHANGE: old head points back to new node
            head.prev = newNode;

            head = newNode;
        }
    }

    // =========================================================
    // ADD LAST
    // =========================================================

    public void addLast(int val) {

        Node newNode = new Node(val);

        if (isEmpty()) {

            // ⭐ CHANGE
            newNode.next = newNode;
            newNode.prev = newNode;

            head = newNode;

        } else {

            // ⭐ CHANGE: no traversal required
            Node last = head.prev;

            newNode.next = head;
            newNode.prev = last;

            last.next = newNode;
            head.prev = newNode;
        }
    }

    // =========================================================
    // ADD AT POSITION
    // =========================================================

    public void addAtPos(int val, int pos) {

        if (pos <= 0) {
            System.out.println("Invalid Position");
            return;
        }

        if (pos == 1) {
            addFirst(val);
            return;
        }

        if (isEmpty()) {
            System.out.println("Invalid Position");
            return;
        }

        Node trav = head;

        // ⭐ CHANGE: no trav.next == null
        for (int i = 1; i < pos - 1; i++) {

            trav = trav.next;

            // ⭐ CHANGE: circular list comes back to head
            if (trav == head) {
                System.out.println("Invalid Position");
                return;
            }
        }

        Node newNode = new Node(val);

        Node temp = trav.next;

        newNode.next = temp;
        newNode.prev = trav;

        trav.next = newNode;

        // ⭐ CHANGE: temp can never be null
        temp.prev = newNode;
    }

    // =========================================================
    // DELETE FIRST
    // =========================================================

    public void delAtFirst() {

        if (isEmpty()) {
            System.out.println("List is Empty");
            return;
        }

        // ⭐ CHANGE: only one node
        if (head.next == head) {
            head = null;
            return;
        }

        // ⭐ CHANGE
        Node last = head.prev;

        head = head.next;

        // ⭐ CHANGE: maintain circular connection
        head.prev = last;
        last.next = head;
    }

    // =========================================================
    // DELETE LAST
    // =========================================================

    public void delAtLast() {

        if (isEmpty()) {
            System.out.println("List is Empty");
            return;
        }

        // ⭐ CHANGE: only one node
        if (head.next == head) {
            head = null;
            return;
        }

        // ⭐ CHANGE: last node
        Node last = head.prev;

        // ⭐ CHANGE: node before last
        Node secondLast = last.prev;

        // ⭐ CHANGE: connect secondLast with head
        secondLast.next = head;
        head.prev = secondLast;
    }

    // =========================================================
    // DELETE AT POSITION
    // =========================================================

    public void delAtPos(int pos) {

        if (isEmpty()) {
            System.out.println("List is Empty");
            return;
        }

        if (pos <= 0) {
            System.out.println("Invalid Position");
            return;
        }

        if (pos == 1) {
            delAtFirst();
            return;
        }

        Node trav = head;

        // ⭐ CHANGE: no trav == null
        for (int i = 1; i < pos; i++) {

            trav = trav.next;

            // ⭐ CHANGE: reached head again
            if (trav == head) {
                System.out.println("Invalid Position");
                return;
            }
        }

        // Connect previous node to next node
        trav.prev.next = trav.next;

        // Connect next node to previous node
        trav.next.prev = trav.prev;
    }

    // =========================================================
    // MAIN
    // =========================================================

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        DoubelyCircularList list = new DoubelyCircularList();

        boolean menu = true;

        while (menu) {

            System.out.println("\n1: Display Forward");
            System.out.println("2: Display Backward");
            System.out.println("3: Add First");
            System.out.println("4: Add Last");
            System.out.println("5: Add At Position");
            System.out.println("6: Delete At Last");
            System.out.println("7: Delete At First");
            System.out.println("8: Delete At Position");
            System.out.println("9: Exit");

            System.out.print("Enter Your Choice: ");
            int choice = sc.nextInt();

            switch (choice) {

                case 1:
                    list.displayForward();
                    break;

                case 2:
                    list.displayBackward();
                    break;

                case 3:
                    System.out.print("Enter The Data: ");
                    int val = sc.nextInt();
                    list.addFirst(val);
                    break;

                case 4:
                    System.out.print("Enter The Data: ");
                    val = sc.nextInt();
                    list.addLast(val);
                    break;

                case 5:
                    System.out.print("Enter The Data: ");
                    val = sc.nextInt();

                    System.out.print("Enter the Position: ");
                    int pos = sc.nextInt();

                    list.addAtPos(val, pos);
                    break;

                case 6:
                    list.delAtLast();
                    break;

                case 7:
                    list.delAtFirst();
                    break;

                case 8:
                    System.out.print("Enter the Position: ");
                    pos = sc.nextInt();

                    list.delAtPos(pos);
                    break;

                case 9:
                    menu = false;
                    break;

                default:
                    System.out.println("Invalid Choice");
                    break;
            }
        }

        sc.close();
    }
}