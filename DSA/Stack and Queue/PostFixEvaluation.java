import java.util.Stack;

public class PostFixEvaluation {
    public static int clac(int a, int b, char opeartor){
        switch (opeartor) {
            case '$': return (int) Math.pow(a, b);
            case '+': return a + b;
            case '*': return a * b;
            case '/': return a / b;
            case '%': return a % b;
            case '-': return a - b;
        }
        return 0;
    }
    public static int solvePostFix(String post){
        Stack<Integer> s = new Stack<>();
        for(int i=0; i<post.length(); i++){
            char sym = post.charAt(i);
            if (Character.isDigit(sym)) {
                String operand  = Character.toString(sym);
                s.push(Integer.parseInt(operand));
            }else{
                int b = s.pop();
                int a = s.pop();
                int c = clac(a, b, sym);
                s.push(c);
            }
        }

        return s.pop();
    }

    public static void main(String[] args) {
        String postfix = "59+4862/-*-173-$+";

        int result = solvePostFix(postfix);
        System.out.println(result);
    }
}
