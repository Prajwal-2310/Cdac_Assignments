import java.util.Scanner;;

public class SinglyList {

    static class Node{

        private int data;
        private Node next;

        public Node(){
            data = 0;
            next = null;
        }

        public Node(int val){
            data = val;
            next = null;
        }
    }
        private Node head;

        public SinglyList(){
            head = null;
        }

        void display(){

            if (head == null) {
                System.out.println("Linked List is Empty");
                return ;
            }

            System.out.println("List: ");
            Node trav = head;
            while (trav != null) {
                System.out.println(trav.data);
                trav = trav.next;
            }
            System.out.println();
        }

        void addLast(int val){
            
            Node newNode = new Node(val);
            if (head == null) {
                head = newNode;
            }else{
                Node trav = head;

                while(trav.next != null){
                    trav = trav.next;
                }   
                trav.next = newNode;
            }
        }

        void addFirst(int val){
            Node newNode = new Node(val);
            newNode.next = head;
            head = newNode;
        }

        void addAtPos(int val, int pos){
            if (head == null || pos <= 1) {
                addFirst(val);
            }else{
                Node newNode = new Node(val);

                Node trav = head;

                for(int i=1; i<pos-1; i++){
                    trav = trav.next;
                }
                newNode.next = trav.next;
                trav.next = newNode;
                
            }
        }

        void delAtLast(){
            if(head == null){
                System.out.println("The List is Empty");
                return ;
            }

            if (head.next == null) {
                head = null;
                return ;
            }

            Node trav = head;

            while (trav.next.next != null) {
                trav = trav.next;
            }

            trav.next = null;
        }

        void delAtFirst(){
            if(head == null){
                System.out.println("List is Empty");
                return ;
            }

            head = head.next;
        }

        void delAtPos(int pos){

            if(head == null || pos < 1){
                System.out.println("List is Empty Or Invalid Position");
                return ;
            }

            if(pos == 1){
                delAtFirst();
                return ;
            }
           Node trav = head;
            for(int i = 1; i < pos - 1 && trav.next != null; i++){
                trav = trav.next;
            }

            if(trav.next == null){
                System.out.println("Invalid Position");
                return;
            }

            trav.next = trav.next.next;
        }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        SinglyList list = new SinglyList();
       

        boolean menu = true;
        while(menu){
            System.out.println("1: Display");
            System.out.println("2: AddFirst");
            System.out.println("3: AddLast");
            System.out.println("4: Add At Posiotion");
            System.out.println("5: Delete At Last");
            System.out.println("6: Delete At First");
            System.out.println("7: Delete At Position");
            System.out.println("8: Exit");

            System.out.print("Enter Your Choice: ");
            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    list.display();
                    break;

                case 2:
                    System.out.print("Enter The Data: ");
                    int val = sc.nextInt();
                    list.addFirst(val);
                    break;
                
                case 3: 
                    System.out.print("Enter The Data: ");
                    val = sc.nextInt();
                    list.addLast(val);
                    break;

                case 4:
                    System.out.print("Enter The Data: ");
                    val = sc.nextInt();
                    System.out.print("Enter the Position: ");
                    int pos = sc.nextInt();
                    list.addAtPos(val, pos);
                    break;

                case 5:
                    list.delAtLast();
                    break;

                case 6:
                    list.delAtFirst();
                    break;

                case 7:
                    System.out.print("Enter the Position: ");
                    pos = sc.nextInt();
                    list.delAtPos(pos);
                    break;

                case 8:
                    menu = false;
                    break;
                default:
                    break;
            }
        }
        sc.close();
    }
}
