/*package Lab10_cal;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;
 
public class StackForCal {
	
	public StackForCal() {
		
	}
 
    
    private int Prec(char ch)
    {
        switch (ch) {
        case '+':
        case '-':
            return 1;
 
        case '*':
        case '/':
            return 2;
 
        }
        return -1;
    }
 
   
    public String infixToPostfix(String exp)
    {
        
        String result = new String("");
 
        
        Deque<Character> stack = new ArrayDeque<Character>();
        
        char[] toC = exp.toCharArray();
 
        for (char c : toC) {
 
            if (Character.isDigit(c))
                result += c;
 
            
            else 
            {
                while (!stack.isEmpty()&& Prec(c) <= Prec(stack.peek())) {
 
                    result += stack.peek();
                    stack.pop();
                }
                stack.push(c);
            }
        }
 
        return result;
    } 
    
}

*/

