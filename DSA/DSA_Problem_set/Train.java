import java.util.Scanner;

class Coach {

    String id;
    String type;
    Coach next;

    public Coach(String id, String type) {
        this.id = id;
        this.type = type;
        this.next = null;
    }
}


public class Train {

    private Coach head;
    private Coach tail;
    private int count;


    // Constructor
    public Train() {

        head = new Coach("ENGINE", "ENGINE");

        tail = head;

        count = 0;
    }


    // Attach coach at the end
    public void attach(String id, String type) {

        // Check duplicate ID
        if (search(id) != null) {
            System.out.println("Duplicate coach ID");
            return;
        }

        Coach newNode = new Coach(id, type);

        tail.next = newNode;

        tail = newNode;

        count++;
    }


    // Insert coach after a particular coach
    public boolean insertAfter(
            String afterId,
            String id,
            String type) {

        // Check duplicate ID
        if (search(id) != null) {
            System.out.println("Duplicate coach ID");
            return false;
        }

        Coach temp = head;

        // Find afterId
        while (temp != null) {

            if (temp.id.equals(afterId)) {

                Coach newNode = new Coach(id, type);

                // Connect new node to next node
                newNode.next = temp.next;

                // Connect current node to new node
                temp.next = newNode;

                // If inserted after tail
                if (temp == tail) {
                    tail = newNode;
                }

                count++;

                return true;
            }

            temp = temp.next;
        }

        return false;
    }


    // Detach coach
    public boolean detach(String id) {

        // Engine cannot be detached
        if (id.equals("ENGINE")) {
            return false;
        }


        Coach prev = head;


        // Find previous node
        while (prev.next != null &&
               !prev.next.id.equals(id)) {

            prev = prev.next;
        }


        // Coach not found
        if (prev.next == null) {
            return false;
        }


        Coach deleteNode = prev.next;


        // If deleting tail
        if (deleteNode == tail) {
            tail = prev;
        }


        // Remove node
        prev.next = deleteNode.next;

        count--;

        return true;
    }


    // Find position of coach
    public int position(String id) {

        Coach temp = head.next;

        int pos = 1;


        while (temp != null) {

            if (temp.id.equals(id)) {
                return pos;
            }

            temp = temp.next;

            pos++;
        }

        return -1;
    }


    // Count coaches of a particular type
    public int countType(String type) {

        Coach temp = head.next;

        int countType = 0;


        while (temp != null) {

            if (temp.type.equals(type)) {
                countType++;
            }

            temp = temp.next;
        }

        return countType;
    }


    // Display train
    public void display() {

        Coach temp = head;

        while (temp != null) {

            System.out.print(temp.id);

            if (temp.next != null) {
                System.out.print(" -> ");
            }

            temp = temp.next;
        }

        System.out.println();
    }


    // Search coach
    private Coach search(String id) {

        Coach temp = head;

        while (temp != null) {

            if (temp.id.equals(id)) {
                return temp;
            }

            temp = temp.next;
        }

        return null;
    }


    // Total coaches excluding ENGINE
    public int totalCoaches() {
        return count;
    }


    // Reverse coaches while keeping ENGINE first
    public void reverseCoaches() {

        if (head.next == null) {
            return;
        }


        Coach oldFirst = head.next;

        Coach prev = null;
        Coach current = head.next;


        while (current != null) {

            Coach next = current.next;

            current.next = prev;

            prev = current;

            current = next;
        }


        // Connect ENGINE to new first coach
        head.next = prev;


        // Old first coach becomes tail
        tail = oldFirst;
    }


    // Main
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        Train train = new Train();

        int choice;


        do {

            System.out.println("\n===== TRAIN COACH MANAGEMENT =====");

            System.out.println("1. Attach Coach");
            System.out.println("2. Insert Coach After");
            System.out.println("3. Detach Coach");
            System.out.println("4. Display Train");
            System.out.println("5. Find Position");
            System.out.println("6. Count Coach Type");
            System.out.println("7. Total Coaches");
            System.out.println("8. Reverse Coaches");
            System.out.println("9. Exit");

            System.out.print("Enter choice: ");

            choice = sc.nextInt();


            switch (choice) {


                case 1:

                    System.out.print("Enter Coach ID: ");
                    String id = sc.next();

                    System.out.print("Enter Coach Type: ");
                    String type = sc.next();

                    train.attach(id, type);

                    break;


                case 2:

                    System.out.print(
                            "Insert after Coach ID: ");

                    String afterId = sc.next();


                    System.out.print(
                            "Enter New Coach ID: ");

                    String newId = sc.next();


                    System.out.print(
                            "Enter Coach Type: ");

                    String newType = sc.next();


                    if (train.insertAfter(
                            afterId,
                            newId,
                            newType)) {

                        System.out.println(
                                "Coach inserted successfully");

                    } else {

                        System.out.println(
                                "Coach could not be inserted");
                    }

                    break;


                case 3:

                    System.out.print(
                            "Enter Coach ID to detach: ");

                    String deleteId = sc.next();


                    if (train.detach(deleteId)) {

                        System.out.println(
                                "Coach detached successfully");

                    } else {

                        System.out.println(
                                "Coach could not be detached");
                    }

                    break;


                case 4:

                    train.display();

                    break;


                case 5:

                    System.out.print(
                            "Enter Coach ID: ");

                    String searchId = sc.next();


                    int pos = train.position(searchId);


                    if (pos == -1) {

                        System.out.println(
                                "Coach not found");

                    } else {

                        System.out.println(
                                "Coach " + searchId +
                                " is at position " + pos);
                    }

                    break;


                case 6:

                    System.out.print(
                            "Enter Coach Type: ");

                    String searchType = sc.next();


                    System.out.println(
                            "Count = " +
                            train.countType(searchType));

                    break;


                case 7:

                    System.out.println(
                            "Total Coaches = " +
                            train.totalCoaches());

                    break;


                case 8:

                    train.reverseCoaches();

                    System.out.println(
                            "Coaches reversed");

                    break;


                case 9:

                    System.out.println(
                            "Program terminated");

                    break;


                default:

                    System.out.println(
                            "Invalid choice");
            }


        } while (choice != 9);


        sc.close();
    }
}