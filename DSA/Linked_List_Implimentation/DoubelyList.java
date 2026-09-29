import java.util.Scanner;

public class DoubelyList {
    
    static class Node{
        private int data;
        private Node next;
        private Node prev;

        public Node(){
            data = 0;
            next = null;
            prev = null;
        }

        public Node(int val){
            data = val;
            next = null;
            prev = null;
        }
    }

    private Node head;

    public DoubelyList(){
        head = null;
    }

    public boolean isEmpty(){
        return head == null;
    }

    public void displayForward(){
        
        System.out.println("List: ");
        if (isEmpty()) 
            System.out.println("List is Empty");

        Node trav = head;
        while (trav != null) {
            System.out.println(trav.data);
            trav = trav.next;
        }
    }

    public void displayBackward(){
         if (isEmpty()) {
            System.out.println("List is Empty");
            return ;
         }
            

         Node trav = head;
         while (trav.next != null ) 
            trav = trav.next;
         
         while (trav != null) {
            System.out.println(trav.data);
            trav = trav.prev;
         }
    }

    public void addFirst(int val){
        Node newNode = new Node(val);

        if(isEmpty()){
            head = newNode;
        }else{
            newNode.next = head;

            head.prev = newNode;

            head = newNode;
        }
    }

    public void addLast(int val){
        Node newNode = new Node(val);

        if (isEmpty()) {
            head = newNode;
        }else{
            Node trav = head;
            while (trav.next != null) 
                trav = trav.next;
            
            trav.next = newNode;

            newNode.prev = trav;
        }
    }

    public void addAtPos(int val, int pos){
        if (isEmpty()) {
            addFirst(val);
        }
        if(pos == 1 || pos < 1){
            addFirst(val);
            return ;
        }
            else{
            Node newNode = new Node(val);

            Node trav = head;
            for(int i=1; i<pos - 1; i++){
                if(trav.next == null)
                    break;
            
                trav = trav.next;
            }

            Node temp = trav.next;
            newNode.next = temp;
            newNode.prev = trav;

            trav.next = newNode;

            if(temp != null){
                temp.prev = newNode;
            }
        }
    }

    public void delAtFirst(){
        if (isEmpty()) {
            System.out.println("List is Empty");
            return ;
        }

        if(head.next == null){
            head = null;
        }else{
            head = head.next;

            head.prev = null;
        }
    }

    public void delAtLast(){
         if (isEmpty()) {
            System.out.println("List is Empty");
            return ;
        }

        if(head.next == null){
            head = null;
        }else{
            Node trav = head;
            while (trav.next != null) 
                trav = trav.next;
            
            trav.prev.next = null;
        }
    }

    public void delAtPos(int pos){
        if (isEmpty()) 
            System.out.println("List is Empty");

        if(pos <= 0){
            System.out.println("Invalid Position");
            return;
        }

        if(pos == 1){
            delAtFirst();
            return;
        }
        
        Node trav = head;

        for(int i = 1; i<pos ; i++){
            if (trav == null) 
                System.out.println("Invaid");
            
            trav = trav.next;
        }

        trav.prev.next = trav.next;

        if (trav.next != null) {
            trav.next.prev = trav.prev;
        }
    }

    public static void main(String[] args) {
         Scanner sc = new Scanner(System.in);

        DoubelyList list = new DoubelyList();
       

        boolean menu = true;
        while(menu){
            System.out.println("1: Display Forward");
            System.out.println("2: Display Backward");
            System.out.println("3: AddFirst");
            System.out.println("4: AddLast");
            System.out.println("5: Add At Posiotion");
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
                    break;
            }
        }
        sc.close();
    }
}
