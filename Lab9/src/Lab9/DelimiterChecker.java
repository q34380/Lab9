package Lab9;
import java.util.Scanner;
import java.util.Stack;
public class DelimiterChecker {
 
    public static void main(String []args){
    	System.out.println("Enter your string");
    	DelimiterChecker DC = new DelimiterChecker();
    	Stack<String> stack = new Stack();
    	Scanner s = new Scanner(System.in);
for(int i=0; i<100; i++) {
stack.push(s.next());
}
s.close();
boolean result = DC.Check(stack);
System.out.println(stack +" = "+result);}
    public boolean Check(Stack<String> stack) {
      int stackSize = ((CharSequence) stack).length();
        StackX theStack = new StackX(stackSize);
        for (int j = 0; j < ((CharSequence) stack).length(); j++) {
            char ch = ((CharSequence) stack).charAt(j);
            switch (ch) {
            case '{':
            case '[':
            case '(':
                    theStack.push(ch);
                    break;
            case '}':
            case ']':
            case ')':
                    if (!theStack.isEmpty()) {
                        char stackContent = theStack.pop();
                        if ((ch == '}' && stackContent != '{') 
                                || (ch == ']' && stackContent != '[')
                                || (ch == ')' && stackContent != '(')){
                            System.out.println("Mismatch found: " + ch + " at " + j);
                            return false;
                        }
                    } else {
                        System.out.println("Mismatch found: " + ch + " at " + j);
                        return false;
                    }
                    break;
            default: break;
            }
        }
        if (!theStack.isEmpty()){
            System.out.println("Error: missing right delimiter");
            return false;
        }
        return true;
    
       }
    }
