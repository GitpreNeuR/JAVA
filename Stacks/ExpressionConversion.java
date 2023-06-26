package Stacks;

import java.util.*;

//CONVERSION OF INFIX TO POSTFIX sRESSIONS USING STACKS

public class ExpressionConversion {

    
   


    static int Prec(char c)
    {
        switch (c)
        {
        case '+':
        case '-':
            return 1;
      
        case '*':
        case '/':
            return 2;
      
        case '^':
            return 3;
        }
        return -1;
    }
      
    
    static String infixToPostfix(String s)
    {
        // initializing empty String for result
        String result = new String("");
         
        // initializing empty stack
        Stack<Character> stack = new Stack<>();
         
        for (int i = 0; i<s.length(); ++i)
        {
            char c = s.charAt(i);
             
            // If the scanned character is an
            // operand, add it to output.
            if (Character.isLetterOrDigit(c))
                result += c;
              
            // If the scanned character is an '(',
            // push it to the stack.
            else if (c == '(')
                stack.push(c);
             
            //  If the scanned character is an ')',
            // pop and output from the stack
            // until an '(' is encountered.
            else if (c == ')')
            {
                while (!stack.isEmpty() &&
                        stack.peek() != '(')
                    result += stack.pop();
                 
                    stack.pop();
            }
            else // an operator is encountered
            {
                while (!stack.isEmpty() && Prec(c)
                         <= Prec(stack.peek())){
                   
                    result += stack.pop();
             }
                stack.push(c);
            }
      
        }
      
        // pop all the operators from the stack
        while (!stack.isEmpty()){
            if(stack.peek() == '(')
                System.out.println( "Invalid expression");
            result += stack.pop();
         }
        return result;
    }


    
   
    // Driver method
    public static void main(String[] args)
    {
        String s = "a+b*(c^d-e)^(f+g*h)-i";

        System.out.println("\nThe coverted expression from infix to postfix is");
        System.out.println(infixToPostfix(s));
    }
}