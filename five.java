//Write a program to evaluate postfix expression using stack.

import java.util.Stack;

public class five{
    public static int evaluatePostfix() 
    {
        Stack<Integer> s=new Stack<>();
        String p=
        for(char ch:p.toCharArray())
        {
            if(Character.isDigit(ch))
            {
                s.push(ch-'0');
            }
            else if(ch !=' ')
            {
                int operand2 = s.pop();
                int operand1 = s.pop();
                int result = 0;
                switch(ch)
                {
                    case '+': result=operand1+operand2;
                              break;
                    case '-': result=operand1-operand2;
                              break;
                    case '*': result=operand1*operand2;
                              break;
                    case '/': 
                    if(operand2==0)
                    {
                        throw new ArithmeticException("Division by zero");
                    }  
                    result=operand1/operand2;
                    break;

                    default: throw new IllegalArgumentException("Invalid operator "+ch);
                }
                s.push(result);
            }
        }
        if(s.size()==0)
        {
            return s.pop();
        }
        else 
        {
            System.out.println("Invalid");
            //throw new IllegalArgumentException("Invalid postfix");
        }
    }
    public static void main(String[] args) {
        //String p="23*5+";
        //int result=evaluatePostfix(p);
       // System.out.println("Result: "+evaluatePostfix(p));
    }
}

