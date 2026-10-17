public class ListOperation {

    public class Node{
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
    //private int count;

    public ListOperation() {
        head = null;
    }

    public boolean isEmpty(){
        return head == null;
    }

    public void addFirst(int val){
        Node newNode = new Node(val);
        newNode.next = head;
        head = newNode;
        //count++;
    }

    public void display(){
        if (isEmpty()) {
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

    public void findMinMax(){
        
        if (isEmpty()) {
            System.out.println("Liat is Empty");
            return ;
        }
        Node trav = head;
        int max = head.data;
        int min = head.data;
        while (trav != null){ 
            if (trav.data > max) 
                max = trav.data;
            

            if (trav.data < min) 
                min = trav.data;
            trav = trav.next;  
        }   
        System.out.println("Maximum Elements is: "+max);
        System.out.println("Minimum Elements is: "+min);
    }

    public void sum(){
        if (isEmpty()) {
            System.out.println("List is Empty");
            return ;
        }

        Node trav = head;
        int sum = 0;
        while (trav != null) {
            sum += trav.data;

            trav = trav.next;
        }
        System.out.println("The Sum of Linked List: "+sum);
    }

    public void search(int key){
        if (isEmpty()) {
            System.out.println("List is Empty");
            return ;
        }

        Node trav = head;
        int i=1;
        while (trav != null) {
            if (trav.data == key) {
                System.out.println("key Found At Position: "+i);
                return ;
            }
            trav = trav.next;
            i++;
        }
        System.out.println("Key Not Found");
    }

    public void reverseDisplay(Node h){
        if(h == null)
            return ;
        
        reverseDisplay(h.next);
        System.out.print(h.data+" -> ");
    }

    public void reverseDisplay(){
        System.out.println("List: ");
        reverseDisplay(head);
    }

    public void reverse(){
        if (isEmpty()) {
            System.out.println("List is Empty");
            return ;
        }
        Node oldHead = head;
        head = null;

        while (oldHead != null) {
            Node temp = oldHead;
            oldHead = oldHead.next;
            temp.next = head;
            head = temp;
        }
        display();
    }
    
    public void middleNode(){
        Node slow = head, fast = head;

        while (fast != null && fast.next != null) {

            slow = slow.next;
            fast = fast.next.next;
            
        }
        System.out.println("Middle Element is: "+ slow.data);
    }
    
    public void findNodeFromEnd(int n){
         if (isEmpty()) {
            System.out.println("List is Empty");
            return ;
        }
        Node slow = head;
        Node fast = head;

        for(int i=0; i<n; i++){

            if(fast == null){
                System.out.println("Invalis n");
                return ;
            }

            fast = fast.next;
        }
        
        while (fast != null) {
            slow = slow.next;
            fast = fast.next;
        }

        System.out.println(n +"th node From tha end is: "+slow.data);

    }

    public void isSorted(){
        if (isEmpty()) {
            System.out.println("List is Empty");
            return ;
        }

        Node trav = head;
        boolean flag = true;

        while (trav.next != null) {
            if (trav.data > trav.next.data) {
                flag = false;
                break;
            }else{
                trav = trav.next;
            }
        }

        if (flag) {
            System.out.println("List is Sorted");
        }else
            System.out.println("List is Not Sorted");
    }

    public void removeDuplicate(){
        if (isEmpty()) {
            System.out.println("List is Empty");
            return ;
        }

        Node trav = head;
        while (trav != null && trav.next != null) {
            if (trav.data == trav.next.data) {
                trav.next = trav.next.next;
            }else{
                trav = trav.next;
            } 
        }
        display();
    }
    public static void main(String[] args) {
        ListOperation n = new ListOperation();

        n.addFirst(70);
        n.addFirst(60);
        n.addFirst(60);
        n.addFirst(50);
        n.addFirst(40);
        
        n.display();
        //n.findMinMax();
        //n.sum();
        //n.search(40);
        //System.out.println("Count is: "+n.count);
        //n.reverse();
        //n.reverseDisplay();
        //n.middleNode();
        //n.findNodeFromEnd(3);
        //n.isSorted();
        n.removeDuplicate();
        
    }
}
