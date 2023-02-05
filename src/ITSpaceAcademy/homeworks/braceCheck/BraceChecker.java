package ITSpaceAcademy.homeworks.braceCheck;

public class BraceChecker {
    private String string;

    public BraceChecker(String string) {
        this.string = string;
    }

    public boolean check() {
        Stack stack = new Stack();

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

    public void betterCheck(){
        Stack stack = new Stack();
        int last;
        char lastBracket;
        for (int i = 0; i < string.length(); i++) {
            char c = string.charAt(i);
            switch (c) {
                case '(', '{', '[' -> stack.push(c);
                case ')' -> {
                    last = stack.pop();
                    if (last == 0) {
                        System.out.println("Error at " + i + " index Closed" + c + "but not open.");
                    } else {
                        lastBracket = (char) last;
                        if (lastBracket != '(') {
                            System.out.println("Error at " + i + " index Closed" + c + " but opened" + lastBracket);
                        }
                    }
                }
                case ']' -> {
                    last = stack.pop();
                    if (last == 0) {
                        System.out.println("Error at " + i + " index Closed" + c + "but not open.");
                    } else {
                        lastBracket = (char) last;
                        if (lastBracket != '[') {
                            System.out.println("Error at " + i + " index Closed" + c + " but opened" + lastBracket);
                        }
                    }
                }
                case '}' -> {
                    last = stack.pop();
                    if (last == 0) {
                        System.out.println("Error at " + i + " index Closed" + c + "but not opened.");
                    } else {
                        lastBracket = (char) last;
                        if (lastBracket != '{') {
                            System.out.println("Error at " + i + " index Closed" + c + " but opened" + lastBracket);
                        }
                    }
                }
            }
        }
//        while ((lastBracket = (char) stack.pop()) != 0){
//            System.err.println("Error: Opened " + lastBracket + " but not closed.");
//        }

        while (!stack.isEmpty()){
            System.err.println("Error: Opened " +(char) stack.pop() + " but not closed.");
        }
    }


}
