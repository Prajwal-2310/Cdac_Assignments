import java.util.Scanner;;

public class SinglyGenericList<T> {

    static class Node<T>{

        private T data;
        private Node<T> next;


        public Node(T val){
            data = val;
            next = null;
        }
    }
        private Node<T> head;

        public SinglyGenericList(){
                head = null;
        }

        void display(){

            if (head == null) {
                System.out.println("Linked List is Empty");
                return ;
            }

            System.out.println("List: ");
            Node<T> trav = head;
            while (trav != null) {
                System.out.println(trav.data);
                trav = trav.next;
            }
            System.out.println();
        }

        void addLast(T val){
            
            Node<T> newNode = new Node<>(val);
            if (head == null) {
                head = newNode;
            }else{
                Node<T> trav = head;

                while(trav.next != null){
                    trav = trav.next;
                }   
                trav.next = newNode;
            }
        }

        void addFirst(T val){
            Node<T> newNode = new Node<>(val);
            newNode.next = head;
            head = newNode;
        }

        void addAtPos(T val, int pos){
            if (head == null || pos <= 1) {
                addFirst(val);
            }else{
                Node<T> newNode = new Node<>(val);

                Node<T> trav = head;

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

            Node<T> trav = head;

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
           Node<T> trav = head;
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

        SinglyGenericList<Integer> intList = new SinglyGenericList<>();

        intList.addLast(10);
        intList.addLast(20);
        intList.addLast(30);
        intList.addAtPos(40, 2);
        intList.addFirst(0);

        intList.display();

        intList.delAtFirst();
        intList.delAtLast();
        intList.delAtPos(2);

        System.out.println("Linked List With Integer is: ");
        intList.display();
       
        SinglyGenericList<String> stringList = new SinglyGenericList<>();

        stringList.addLast("Java");
        stringList.addLast("C++");
        stringList.addLast("Python");
        stringList.addAtPos("C-Sharp", 3);
        stringList.addFirst("DSA");

        System.out.println("Linked List With String is: ");
        stringList.display();

        stringList.delAtFirst();
        stringList.delAtLast();
        stringList.delAtPos(2);

        stringList.display();
        
        sc.close();
    }
}
