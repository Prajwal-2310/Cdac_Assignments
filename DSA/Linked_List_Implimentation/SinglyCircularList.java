import java.util.Scanner;

public class SinglyCircularList {
    
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

    public SinglyCircularList(){
        head = null;
    }

    public boolean isEmpty(){
        return head == null;
    }

    public void display(){
        System.out.println("List: ");
        if (isEmpty()) {
            System.out.println("List is Empty");
            return ;
        }
        Node trav = head;

        do{
            System.out.println(trav.data);
            trav = trav.next;
        }while(trav != head);
    }

    public void addFirst(int val){
        Node newNode = new Node(val);
        if (isEmpty()) {
            head = newNode;
            newNode.next = head;
            return ;
        }
        Node trav = head;
        while(trav.next != head)
            trav = trav.next;

        newNode.next = head;
        trav.next = newNode;
        head = newNode;
        
    }

    public void addLast(int val){
        Node newNode = new Node(val);

        if (isEmpty()) {
            head = newNode;
            newNode.next = head;
        }else{
            Node trav = head;

            while (trav.next != head) 
                trav = trav.next;
            

            trav.next = newNode;
            newNode.next = head;
        }  
    }

    public void addAtPos(int val, int pos){
        

        if (head == null || pos <= 1) {
            addFirst(val);
            return ;
        }else{
            Node newNode = new Node(val);
            Node trav = head;
            for(int i =1; i<pos -1; i++){
                if(trav.next == head)
                    break;

                trav = trav.next;
            }

            newNode.next = trav.next;
            trav.next = newNode;
        }
    }

    public void delFirst(){
        if (isEmpty()) {
            System.out.println("List Is Empty");
            return ;
        }
        if (head.next == head) {
            head = null;
            return ;
        }
        else{
            Node trav = head;
            while (trav.next != head) {
                trav = trav.next;
            }

            head = head.next;
            trav.next = head;
        }
    }

    public void delAtLast(){
        if (isEmpty()) {
            return ;
        }
        if (head.next == head) {
            head = null;
            return ;
        }

        Node trav = head;
        while (trav.next != head) 
                trav = trav.next;
        
        trav.next = head;
    }

    public void detAtPos(int pos){
        if(pos == 1)
            delFirst();
        
        if(head == null || pos < 1){
            System.out.println("Invalid");
        }

        Node trav = head, temp = null;

        for(int i=1; i<pos - 1; i++){
            temp = trav;
            trav = trav.next;

            if(trav.next == head){
                System.out.println("Invalid");
                return ;
            }
                

            temp.next = trav.next;
        }
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
