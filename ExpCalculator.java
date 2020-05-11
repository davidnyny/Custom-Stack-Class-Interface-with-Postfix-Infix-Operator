import java.util.*;
//David Nygren
//IT179 003
//Homework 05

//This class returns the value of a postfix and changes infix to postfix
public class ExpCalculator{
    //evaluate a postfix expression and return its value
    public static double evalPostfix(String postfixExp){
        
        int index = 0;
        ArrayStack<Double> arr = new ArrayStack<Double>();
        double result = 0;
        //traversing throughout the string postfixExp
        for(int i = 0; i < postfixExp.length(); i++) 
        { 
            char c = postfixExp.charAt(i); 
            //This checks for spaces and skips over them
            if(c == ' ') 
                continue; 
            //Checking for double digits, so if it's a digit, then continue to take in and add the value 
            else if(Character.isDigit(c)) 
            { 
                double x = 0.0; 
                boolean check = true;
                //Checking for decimal places in case of a double
                while(Character.isDigit(c) || c == '.') 
                { 
                    //Calculate the value of the numbers before the decimal point
                    if(c!= '.' && check == true){
                        x = x*10 + (double)(c-'0'); 
                        i++; 
                        c = postfixExp.charAt(i);
                    }
                    //Calculate the value of the numbers after the decimal point
                    else{
                        check = false;
                        x = x + 0.1 + (double)(c-'0')/10;
                        i++;
                        c = postfixExp.charAt(i);
                    }
                } 
                i--; 
                arr.push(x); 
            } 
            else
            { 
                //Else if the character in postfixExp isn't a decimal point, space, or number, it's an operator
                //The switch case calculates the different values depending on the operator given
                double val1 = arr.pop(); 
                double val2 = arr.pop(); 
                switch(c) 
                { 
                    case '+': 
                    arr.push(val2+val1); 
                    break; 

                    case '-': 
                    arr.push(val2- val1); 
                    break; 

                    case '/': 
                    if (val1 == 0)throw new ArithmeticException();
                    arr.push(val2/val1); 
                    break; 

                    case '*': 
                    arr.push(val2*val1); 
                    break; 
                    
                    case '^':
                    for(int x = 1; x< val1; x++)val2*=val2;
                    arr.push(val2);
                    break;
                    
                    default:
                    throw new ArithmeticException();
                } 
            } 
        } 
        return arr.pop(); 
    }

    public static String infixToPostfix(String exp){
        String result = "";
        ArrayStack<Character> arr = new ArrayStack<>();
        for (int i = 0; i <exp.length() ; i++) {
            char c = exp.charAt(i);
            //check if char is operator
            if(precedence(c)>0){
                //take off the top of the stack in order to check its precedence
                while(arr.isEmpty()==false && precedence(arr.peek())>=precedence(c)){
                    result += arr.pop();
                }
                result += ' ';
                arr.push(c);
                //checking for parentheses in order to determine precedence
            }else if(c==')'){
                char x = arr.pop();
                while(x!='('){
                    result += x;
                    x = arr.pop();
                }
            }else if(c=='('){
                arr.push(c);
            }else{
                //character is neither operator nor ( 
                result += c;
            }
        }
        for (int i = 0; i <=arr.size() ; i++) {
            result += arr.pop();
        }
        return result;
    }
    
    //Checks the precedence of the operator
    static int precedence(char c){
        switch (c){
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

}
