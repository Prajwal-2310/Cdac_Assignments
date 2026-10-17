import java.util.Stack;

public class InfixToPrePostfix {
    public static Character pri(char operator){
        switch (operator) {
            case '$': return 10;
            case '*': return 7;
            case '/': return 7;
            case '%': return 7;
            case '+': return 3;
            case '-': return 3;
        }
        return 0;
    }
    public static String solveToPrefix(String infix){
        Stack<Character> s = new Stack<>();
        StringBuilder pre = new StringBuilder();

        for(int i=0; i<infix.length();i++){
            char sym = infix.charAt(i);

            //If operand is found, append to postfix
            if (Character.isDigit(sym)) 
                pre.append(sym);
            else if(sym == '(' ) // if opening ( is found put it into the stack
                s.push(sym);

            // If closing ) is found
            else if(sym == ')'){
                //pop all the operator from the stack one by one and append to the postfix
                // until opening ( is found

                while (s.peek() != '(' ) {
                    pre.append(s.pop());
                }

                s.pop();
            }
            else{
                //If operator is found, push it on to the stack.
                //If priority of topmost operator from stack >= priority of current operator,
                while (!s.isEmpty() && pri(s.peek()) >= pri(sym)) {
                    pre.append(s.pop());
                }
                s.push(sym);
            }
            
        }

        while (!s.isEmpty()) 
            pre.append(s.pop());

        return pre.toString();
    }

    public static String solveToPostFix(String infix){
        Stack<Character> s = new Stack<>();
        StringBuilder pre = new StringBuilder();

        for(int i=infix.length() - 1; i>=0; i--){
            char sym = infix.charAt(i);

            if(Character.isDigit(sym))
                pre.append(sym);

            else if(sym == ')')
                s.push(sym);

            else if(sym == '('){
                while (s.peek() != ')') {
                    pre.append(s.pop());
                }
                s.pop();
            }
            else{
                while (!s.isEmpty() && pri(s.peek()) > pri(sym)) {
                    pre.append(s.pop());
                }
                s.push(sym);
            }
        }

        while (!s.isEmpty()) 
            pre.append(s.pop());
        
        return pre.reverse().toString();
    }

    public static void main(String[] args) {
        String infix = "5+9-4*(8-6/2)+1$(7-3)";
        String prefix = solveToPrefix(infix);
        System.out.println(prefix);

        String postfix = solveToPostFix(infix);
        System.out.println(postfix);
    }
}
