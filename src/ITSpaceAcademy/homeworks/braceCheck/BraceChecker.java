package ITSpaceAcademy.homeworks.braceCheck;

public class BraceChecker {
    private String string;

    public BraceChecker(String string) {
        this.string = string;
    }

    public boolean check() {
        CharStack stack = new CharStack();
        boolean flag = true;
        for (int i = 0; i < string.length(); i++) {
            if(string.charAt(i) == '(' || string.charAt(i) == '[' || string.charAt(i) == '{'){
                stack.push(string.charAt(i));
                continue;
            }

            switch (string.charAt(i)){
                case ')':
                    if(stack.isEmpty()){
                        System.err.println("Error at " + i + " index Closed ) but not open.");
                        flag = false;
                    }else{
                        if(stack.peek() != '('){
                            System.err.println("Error at " + i + " index Closed ) but not open.");
                            flag = false;
                        }else {
                            stack.pop();
                        }
                    }
                    break;
                case ']':
                    if(stack.isEmpty()){
                        System.err.println("Error at " + i + " index Closed ] but not open.");
                        flag = false;
                    }else{
                        if(stack.peek() != '['){
                            System.err.println("Error at " + i + " index Closed ] but not open.");
                            flag = false;
                        }else {
                            stack.pop();
                        }
                    }
                    break;
                case '}':
                    if(stack.isEmpty()){
                        System.err.println("Error at " + i + " index Closed } but not open.");
                        flag = false;
                    }else{
                        if(stack.peek() != '{'){
                            System.err.println("Error at " + i + " index Closed } but not open.");
                            flag = false;
                        }else{
                            stack.pop();
                        }
                    }
                    break;
            }
        }
        if(!stack.isEmpty()){
            flag = false;
            while (!stack.isEmpty()){
                System.err.println("Error: Opened " + stack.peek() + " but not closed.");
                stack.pop();
            }
        }
        return flag;
    }
}
