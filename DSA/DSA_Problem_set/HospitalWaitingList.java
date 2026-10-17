import java.util.Scanner;

public class HospitalWaitingList {
    public class Node{
        private String data;
        private Node next;
        private Node prev;

        public Node(String data){
            this.data = data;
            next = null;
            prev = null;
        }
    }

    int waiting ;
    private Node head;

    public HospitalWaitingList(){
        head = null;
        waiting = 0;
    }

    public void addNormal(String val){
        Node newNode = new Node(val);
        if (head == null) {
            head = newNode;
        }else{
            Node trav = head;
            while (trav.next != null) {
                trav = trav.next;
            }

            trav.next = newNode;
            newNode.prev = trav;
        }
        waiting++;
    }

    public void addEmergency(String val){
        Node newNode = new Node(val);

        if (head == null) {
            head = newNode;
        }else{
            newNode.next = head;
            head.prev = newNode;
            head = newNode;
        }
        waiting++;
    }

    public void callNext(){
        if (head == null) {
            return ;
        }

        if (head.next == null) {
            head = null;
        }else{
            head = head.next;

            head.prev = null;
        }
        waiting--;
    }

    public void leave(String val){
        if (head == null) {
            return;
        }

        Node trav = head;

        // Find the patient
        while (trav != null) {

            if (trav.data.equalsIgnoreCase(val)) {

                // Case 1: Patient is the first node
                if (trav == head) {
                    head = trav.next;

                    if (head != null) {
                        head.prev = null;
                    }
                }

                // Case 2: Patient is somewhere after head
                else {
                    trav.prev.next = trav.next;

                    // If patient is not the last node
                    if (trav.next != null) {
                        trav.next.prev = trav.prev;
                    }
                }

                waiting--;
                return;
            }

            trav = trav.next;
        }
    }

    public void display(){
        if (head == null) 
            return ;

        Node trav = head;
        while (trav != null) {
            System.out.println(trav.data);
            trav = trav.next;
        }
    }

    public void displayReverse(){
        if (head == null) 
            return ;
        
        Node trav = head;
        while (trav.next != null) {
            trav = trav.next;
        }

        while (trav != null) {
            System.out.println(trav.data);
            trav = trav.prev;
        }
    }

    public int waiting(){
        return waiting;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        HospitalWaitingList ls = new HospitalWaitingList();
        int choice;
    do {

        System.out.println("=============Hospital Waiting List=============");
        System.out.println("1: Add Noraml Patient");
        System.out.println("2: Add Emergency Patient");
        System.out.println("3: Call By Doctor");
        System.out.println("4: Patient Leaving");
        System.out.println("5: Display");
        System.out.println("6: Display Reverse");
        System.out.println("7: Waiting List");
        System.out.println("8: Exit");

        System.out.print("Enter Your Choice: ");
        choice = sc.nextInt();

        switch (choice) {
            case 1:
                System.out.print("Enter Patient Name: ");
                String name = sc.next();
                ls.addNormal(name);
                break;

            case 2:
                System.out.print("Enter Patient Name: ");
                name = sc.next();
                ls.addEmergency(name);
                break;

            case 3:
                ls.callNext();
                break;

            case 4:
                System.out.print("Enter Tha name Of Patient Who is Leaving: ");
                name = sc.next();
                ls.leave(name);
                break;

            case 5:
                System.out.println("Patient List");
                ls.display();
                break;

            case 6:
                System.out.println("Reverse Patient List");
                ls.displayReverse();
                break;

            case 7:
                int wait = ls.waiting;
                System.out.println("Waiting Number: "+wait);
                break;
            case 8:
                break;
            
            default:
                break;
        }
        
    } while (choice != 8);

        sc.close();
    }
}
