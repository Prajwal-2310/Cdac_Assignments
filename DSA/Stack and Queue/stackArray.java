import java.util.Scanner;

public class stackArray {

    private int[] arr;
    private int top;

    public stackArray(int size){
        arr = new int[size];
        top = -1;
    }

    public void push(int val){
        if (isFull()) {
            System.out.println("Stack is Full");
            return ;
        }
        top++;
        arr[top] = val;
    }

    public void pop(){
        if (isEmpty()){ 
            System.out.println("Stack is Empty");
            return ;
        }
        top--;
    }

    public int peek(){
        if (isEmpty()) {
            System.out.println("Stack is Empty");
            return 0;
        }
            
        return arr[top];
    }

    public boolean isEmpty(){
        return top == -1;
    }

    public boolean isFull(){
        return top == arr.length - 1;
    }

    public void display(){
        if (isEmpty()) {
            System.out.println("Stack is Empty");
            return ;
        }

        System.out.println("Stack Elements are: ");

        for(int i = top; i >= 0; i--){
            System.out.print(arr[i]);
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the Size of Stack: ");
        int size = sc.nextInt();
        stackArray stack = new stackArray(size);

        int choice;
        do{
            System.out.println("1: Push");
            System.out.println("2: Pop");
            System.out.println("3: Peek");
            System.out.println("4: Display");
            System.out.println("Enter the Choice for Operation");
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter the Value: ");
                    int val = sc.nextInt();
                    stack.push(val);
                    break;

                case 2:
                    val = stack.peek();
                    stack.pop();
                    System.out.println("Popped Elements is: "+val);
                    break;

                case 3:
                    System.out.println("The Top Element is: "+stack.peek());
                    break;

                case 4:
                    stack.display();
                    break;
            
                default:
                    break;
            }
        }while(choice != 0);

        sc.close();
    }
    
}
