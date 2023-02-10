
import java.util.Scanner;
/**
*This class executes the conversion from infix to postfix.
*@author Chun-Hsien Liu
*@version ver 1.0.0
*/
public class InfixConversion
{
    /**
    *default constructor.
    */
    public InfixConversion()
    {

    }

    /**
    *This method validates if a String is an operator.
    *
    *@param     accepts a String input.
    *@return    a boolean value indicating if the input is an operator.
    */ 
    public boolean isOperator(String input)
    {
        if(input.equals("+") || input.equals("-") || input.equals("*") || input.equals("/") || input.equals("%") || input.equals("^"))
        {
            return true;
        }
        else
        {
            return false;
        }
    }

    /**
    *This method compares 2 operators's precendence. 
    *
    *@param     two operators as Strings.
    *@return    a true boolean value if operator1 has an equal or greater precedence than that of operator2.  
    */
    public boolean precedence(String operator1, String operator2)
    {
        int precedenceNumber1 = precedenceLevel(operator1);
        int precedenceNumber2 = precedenceLevel(operator2);

        if(precedenceNumber1 >= precedenceNumber2)
        {
            return true;
        }
        else
        {
            return false;
        }
    }

    /**
    *This method converts an operator's level of precedence into an integer.
    *
    *@param     accepts an operator as a String.
    *@return    an integer which represents the level of precedence.
    */ 
    public int precedenceLevel(String operator)
    {
        int precedenceNumber = 0;

        if(operator.equals("^"))
        {
            precedenceNumber = 3;
        }
        else if(operator.equals("*")|| operator.equals("/") || operator.equals("%"))
        {
            precedenceNumber = 2;
        }
        else if(operator.equals("+") || operator.equals("-"))
        {
            precedenceNumber = 1;
        }

        return precedenceNumber;
    }

    /**
    *This method converts an infix expression to a postfix one.
    *
    *@param     accepts an infix expression as a String.
    *@return    a postfix expression as a String.
    */
    public String convertToPostfix(String expression)
    {
        QueueADT infix = new QueueADT();
        QueueADT postfix = new QueueADT();
        QueueADT test = new QueueADT();
        StackADT stack = new StackADT();

        int length = expression.length();

        for(int i = 0; i < length; i++)
        {
            String input = Character.toString(expression.charAt(i));
            infix.enqueue(input);
            test.enqueue(input);
        }

        if(validation(test))
        {
            stack.push("(");

            infix.enqueue(")");

            for(int i = 0; i < length + 1; i++)
            {
                String current = infix.dequeue();

                if(isDigit(current))
                {
                    postfix.enqueue(current);
                }
                else if(current.equals("("))
                {
                    stack.push(current);
                }
                else if(isOperator(current))
                {
                    if(isOperator(stack.stackTop()))
                    {
                        while(precedence(stack.stackTop(), current))
                        {
                            String operator = stack.stackTop();
                            stack.pop();
                            postfix.enqueue(operator);                   
                        }

                            stack.push(current);
                    }
                    else
                    {
                        stack.push(current);
                    }

                }
                else if(current.equals(")"))
                {
                    while(!stack.stackTop().equals("("))
                    {
                        String operator = stack.stackTop();
                        stack.pop();
                        postfix.enqueue(operator);
                    }
                    
                    stack.pop();
                }

            }

                String conversion = "";

                while(!postfix.isEmpty())
                {
                    String value = postfix.dequeue();
                    conversion += value;
                }

                return conversion;
        }
        else
        {
            return "Invalid expression";
        }        
    }

    /**
    *This method validates if a String input is a digit.
    *
    *@param     accepts a String input.
    *@return    a true boolean value if the input is a digit. 
    */
    public boolean isDigit(String input)
    {
        if(input.equals("0") || input.equals("1") || input.equals("2") || input.equals("3") || input.equals("4") || input.equals("5") || input.equals("6") || input.equals("7") || input.equals("8") || input.equals("9"))
        {
            return true;
        }
        else
        {
            return false;
        }
    }


    /**
    *This method validates the validity of an infix expression.
    *
    *@param     accepts an infix queue.
    *@return    a boolean value indicating if the expression is valid.  
    */
    public boolean validation(QueueADT test)
    {
        StackADT stack = new StackADT();
        StackADT parentheses = new StackADT();

        while(!test.isEmpty())
        {   
            String value = test.dequeue();

            if(stack.isEmpty())
            {
                if(value.equals(")"))
                {
                    return false;
                }
                else if(value.equals("("))
                {
                    parentheses.push(value);
                }

                stack.push(value);
            }
            else
            {
                if(isOperator(stack.stackTop()) && isOperator(value))
                {
                    return false;
                }
                else if(!isDigit(value) && !isOperator(value) && !value.equals("(") && !value.equals(")"))
                {
                    return false;        
                }
                else if(value.equals("(") || value.equals(")"))
                {
                    parentheses.push(value);
                }

                stack.push(value);
            } 
        }

        int count = 0;

        if(!parentheses.isEmpty() && parentheses.stackTop().equals("("))
        {
            return false;
        }
        
        while(!parentheses.isEmpty())
        {
            // String value = parentheses.stackTop();
            parentheses.pop();
            count++;
        }

        if(count % 2 != 0)
        {
            return false;
        }

        return true;
    }

    /**
    *Main method including sample testing code.
    */
    public static void main(String[] args)
    {
        InfixConversion conversion = new InfixConversion();
        Scanner scan = new Scanner(System.in);
        
        Boolean flag = true;

        do {
            
            System.out.println("Enter an infix expression:");
            String infix = scan.nextLine();
            System.out.println("Its postfix version is:");
            System.out.println(conversion.convertToPostfix(infix));
            
            Boolean flag2 = true;

            while(flag2) {
                System.out.println("continue? y/n");
                String proceed = scan.nextLine();

                if(proceed.equals("n")) {
                    flag = false;
                    flag2 = false;
                }
                else if(proceed.equals("y")) {
                    flag2 = false;
                }
                else {
                    System.out.println("Invalid input. Please only enter y or n\n");
                }
            }

        }while(flag);

        scan.close();
        
        // System.out.println(conversion.convertToPostfix("1+4-(2+3)*7+6^5+8%4/9"));
        // System.out.println(conversion.convertToPostfix("7%3*8-6/2+9-(1+4)*7^6"));
        // System.out.println(conversion.convertToPostfix("3++2-4*6%7*4^3+(9-1)/8"));
        // System.out.println(conversion.convertToPostfix(")7*8^3-2*9/4+1-6%5-3"));
        
    }        
}