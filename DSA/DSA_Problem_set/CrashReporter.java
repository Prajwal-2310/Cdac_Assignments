public class CrashReporter {

    static class MethodStack {

        private String[] data;
        private int top;

        public MethodStack(int size) {
            data = new String[size];
            top = -1;
        }

        // Push
        public boolean push(String method) {

            if (top == data.length - 1) {
                return false;
            }

            data[++top] = method;

            return true;
        }

        // Pop
        public String pop() {

            if (top == -1) {
                return null;
            }

            String temp = data[top];

            data[top] = null;

            top--;

            return temp;
        }

        public String peek() {

            if (top == -1) {
                return null;
            }

            return data[top];
        }

        public boolean isEmpty() {
            return top == -1;
        }

        public int size() {
            return top + 1;
        }

        public void printTrace() {

            for (int i = top; i >= 0; i--) {
                System.out.println("at " + data[i]);
            }
        }
    }


    public static void main(String[] args) {

        String[] log = {
            "ENTER main",
            "ENTER placeOrder",
            "ENTER validateCart",
            "EXIT validateCart",
            "ENTER processPayment",
            "ENTER connectBank",
            "CRASH"
        };


        MethodStack stack = new MethodStack(10);

        int maxDepth = 0;


        for (int i = 0; i < log.length; i++) {

            String line = log[i];

            String[] parts = line.split(" ");

            String command = parts[0];


            // ENTER
            if (command.equals("ENTER")) {

                String method = parts[1];

                if (!stack.push(method)) {

                    System.out.println(
                        "StackOverflowError: call depth exceeded 10"
                    );

                    return;
                }

                if (stack.size() > maxDepth) {
                    maxDepth = stack.size();
                }
            }


            // EXIT
            else if (command.equals("EXIT")) {

                String method = parts[1];

                if (stack.peek() == null ||
                    !stack.peek().equals(method)) {

                    System.out.println(
                        "Invalid EXIT at line " + (i + 1)
                    );

                    return;
                }

                stack.pop();
            }


            // CRASH
            else if (command.equals("CRASH")) {

                System.out.println(
                    "Application crashed at line " + (i + 1)
                );

                System.out.println(
                    "Stack trace:"
                );

                stack.printTrace();

                System.out.println(
                    "Maximum call depth reached: " + maxDepth
                );

                return;
            }
        }


        System.out.println(
            "Program finished normally"
        );
    }
}