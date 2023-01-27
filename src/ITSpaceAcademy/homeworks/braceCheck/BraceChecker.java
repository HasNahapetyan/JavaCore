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
                        flag = false;
                    }else{
                        if(stack.peek() != '('){
                            flag = false;
                        }else {
                            stack.pop();
                        }
                    }
                    break;
                case ']':
                    if(stack.isEmpty()){
                        flag = false;
                    }else{
                        if(stack.peek() != '['){
                            flag = false;
                        }else {
                            stack.pop();

                        }
                    }
                    break;
                case '}':
                    if(stack.isEmpty()){
                        flag = false;
                    }else{
                        if(stack.peek() != '{'){
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
        }
        return flag;
    }
}
