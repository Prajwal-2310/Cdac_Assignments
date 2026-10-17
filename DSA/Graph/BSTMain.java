import java.util.Scanner;

public class BSTMain {
    static class Node{
        private int value;
        private Node left;
        private Node right;


        public Node(){
            value = 0;
            left = null;
            right = null;
        }

        public Node(int value){
            this.value = value;
            this.left = null;
            this.right = null;
        }

        public int getValue(){
            return value;
        }
    }

    private Node root;
    public BSTMain(){
        root = null;
    }

    public void add(int val){
        Node newNode = new Node(val);
        if (root == null) 
            root = newNode;
        else{
            Node trav = root;
            while (true) {
                if(val < trav.value){
                    if (trav.left != null) 
                        trav = trav.left;
                    else{
                        trav.left = newNode;
                        break;
                    }
                }else{
                    if (trav.right != null) 
                        trav = trav.right;
                    else{
                        trav.right = newNode;
                        break;
                    }
                    
                }
            }
            
        }
    }

    public void preorder(Node trav){
        if (trav == null) 
            return ;
        System.out.print(trav.value+" ");
        preorder(trav.left);
        preorder(trav.right);
    }
    
    public void preorder(){
        preorder(root);
        System.out.println();
    }

    public void inorder(Node trav){
        if (trav == null) 
            return ;
        inorder(trav.left);
        System.out.print(trav.value+" ");
        inorder(trav.right);
    }

    public void inorder(){
        inorder(root);
        System.out.println();
    }

    public void postorder(Node trav){
        if (trav == null) 
            return ;
        postorder(trav.left);
        postorder(trav.right);
        System.out.print(trav.value+" ");
    }

    public void postorder(){
        postorder(root);
        
    }

    // Height of Full Tree
    public int height(Node trav){
        if (trav == null) {
            return -1;
        }

        int h1 = height(trav.left);
        int h2 = height(trav.right);
        int max = h1 > h2 ? h1 : h2;
        return max + 1; 
    }

    public int height(){
        return height(root);
    }

    //Height of perticular node
    
    public int heightOfNode(Node trav, int key){
        if (trav == null) {
            return -1;
        }

        if (trav.value == key) {
            return height(trav);
        }

        int h = heightOfNode(trav.left, key);
        if (h != -1) 
            return h;
        

        return heightOfNode(trav.right, key);
    }

    public int heightOfNode(int key){
        return heightOfNode(root, key);
    }

    public Node bfs(int key){
        QueueDemo<Node> q = new QueueDemo<>(15);
        q.offer(root);
        while (!q.isEmpty()) {
            Node trav = q.poll();
            if (key == trav.value) {
                return trav;
            }
            if (trav.left != null) {
                q.offer(trav.left);
            }
            if (trav.right != null) {
                q.offer(trav.right);
            }
        }
        return null;
    }

    public Node dfs(int key){
        Stack<Node> s = new Stack<>(15);
        s.push(root);
        while (!s.isEmpty()) {
            Node trav = s.pop();
            if (key == trav.value) {
                return trav;
            }
            if (trav.left != null) {
                s.push(trav.left);
            }
            if (trav.right != null) {
                s.push(trav.right);
            }
        }
        return null;
    }

    public Node binarySearch(int key){
        Node trav = root;
        while (trav != null) {
            if (key == trav.value) {
                return trav;
            }
            if (key < trav.value) 
                trav = trav.left;
            else
                trav = trav.right;
        }
        return null;
    }

    public Node[] binarySearchWithParent(int key){
        Node trav = root, parent = null;
        while (trav != null) {
            if (key == trav.value) {
                return new Node[] {trav, parent};
            }
            parent = trav;
            if (key < trav.value) 
                trav = trav.left;
            else
                trav = trav.right;
        }
        return new Node[]{null, null};
    }

    public void delete(int val){
        Node trav, parent;
        //Find the Node to be deleted with parent
        Node[] arr = binarySearchWithParent(val);
        trav = arr[0];
        parent = arr[1];
        //If node is not found
        if (trav == null) {
            System.out.println("Node is Not Found");
            return ;
        }
        
        if (trav.left != null && trav.right != null) {
            parent = trav;
            Node succ = trav.right;
            while (succ.left != null) {
                parent = succ;
                succ = succ.left;
            }
            //Override data of node with succ data
            trav.value = succ.value;
            //mark succ node to be deleted
            trav = succ;
        }

        // If the Node has only right Child
        if (trav.left == null) {
            if (trav == root) {
                root = trav.right;
            }else if(trav == parent.left)
                parent.left = trav.right;
            else
                parent.right = trav.right;
        }else if (trav.right == null) {
            // If the Node has only Left Child
            if (trav == root) {
                root = trav.left;
            }else if(trav == parent.left)
                parent.left = trav.left;
            else
                parent.right = trav.left;
        }

    }

    public void delete1(int val){
        Node trav, parent;
        Node[] arr = binarySearchWithParent(val);

        trav = arr[0];
        parent = arr[1];

        if (root == null) {
            System.out.println("Tree is Empty");
            return ;
        }

        if (trav.left != null && trav.right != null) {
            parent = trav;
            Node succ = trav.right;
            while (succ.left != null) {
                parent = succ;
                succ = succ.left;
            }

            trav.value = succ.value;
            trav = succ;
        }
        
        if(trav.left == null){
            if (trav == root) {
                root = trav.right;
            }else if(trav == parent.left){
                parent.left = trav.right;
            }else{
                parent.right = trav.right;
            }
        }else if(trav.right == null){
            if (root == trav) {
                root = trav.left;
            }else if(trav == parent.left){
                parent.left = trav.left;
            }else{
                parent.right = trav.left;
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        BSTMain bst = new BSTMain();
        bst.add(50);
        bst.add(30);
        bst.add(10);
        bst.add(90);
        bst.add(100);
        bst.add(40);
        bst.add(70);
        bst.add(80);
        bst.add(60);
        bst.add(20);

        System.out.print("Pre: ");
        bst.preorder();
        System.out.print("In: ");
        bst.inorder();
        System.out.print("Post: ");
        bst.postorder();
        System.out.println("\n Height is: "+bst.height());

        System.out.print("Enter the Node to Find Height: ");
        int h = sc.nextInt();
        System.out.println("Height: "+ bst.heightOfNode(h));

        System.out.print("Enter The Key: ");
        int key = sc.nextInt();
        Node temp = bst.bfs(key);
        if (temp == null) 
            System.out.println("BFS: Not Found");
        else
            System.out.println("BFS: Found "+temp.getValue());

        temp = bst.dfs(key);
        if (temp == null) 
            System.out.println("DFS: Not Found");
        else
            System.out.println("DFS: Found "+temp.getValue());

        temp = bst.binarySearch(key);
        if (temp == null) 
            System.out.println("BS: Not Found");
        else
            System.out.println("BS: Found "+temp.getValue());
        
        Node[] t = bst.binarySearchWithParent(key);
        if (t[0] == null) {
            System.out.println("BS: Not Found");
        } else {
            System.out.println("BS: Found " + t[0].getValue());

        if (t[1] == null)
            System.out.println("Parent: No Parent (Root)");
        else
            System.out.println("Parent: " + t[1].getValue());
        }


        bst.inorder();
        System.out.print("Enter Element To Be Deleted: ");
        int value = sc.nextInt();
        bst.delete1(value);

        bst.inorder();

        sc.close();
    }

}
