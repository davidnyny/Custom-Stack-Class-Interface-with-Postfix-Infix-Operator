import java.util.StringTokenizer;
import java.util.Scanner;
/**

a) Postfix expressions to be evaluated, and
b) infix expressions to be converted to postfix, and evaluated.
 */

public class Tester {

    public static void main(String[] args) {

        //Postfix expressions to be evaluated
        String[][] postfixExpression = {{"12 2 *"},{"1.3 2.7 + 4 /"},{"2 3 ^ 3 * 2 -"}};

        System.out.println("%------------------------------");
        System.out.println("Evaluating Postfix Expressions");
        System.out.println("%------------------------------");
        for (int i=0;i<postfixExpression.length;i++){

            System.out.println("Postfix: " + postfixExpression[i][0]);

            double result = ExpCalculator.evalPostfix(postfixExpression[i][0]);
            System.out.format("Value is %.2f%n",result); //

            System.out.println("----------------");
        }

        // Infix expressions to be converted to postfix, and evaluated.
        String[][] infixExpression = {{"3.1-2+1"},{"2*3^2"},{"4/2*5"},{"(2+3)*4"},{"5^2-3*(3.2+1.3)"}};

        System.out.println("%------------------------------------------");
        System.out.println("Convert Infix to Postfix, and evaluate.");
        System.out.println("%------------------------------------------");
        System.out.println("----------------");
        for (int i=0;i<infixExpression.length;i++){
            System.out.println("Infix: " + infixExpression[i][0]);

            String postfix = ExpCalculator.infixToPostfix(infixExpression[i][0]);
            System.out.println("Converted to postfix: " + postfix);

            double result = ExpCalculator.evalPostfix(postfix);
            System.out.format("Value is %.2f%n",result); //

            System.out.println("----------------");
        }

        /** The next, few sample expressions you can use to check if
        your methods are taking appropriate care of exceptions,
        division by zero and invalid expression, for example.*/
        /*
        //--------------------------------------//
        String postfixExp1 = "3 4 + 0 /"; //  error-division by zero
        System.out.println("----------------");
        double result = ExpCalculator.evalPostfix(postfixExp1);
        //--------------------------------------//
        */

        /*
        //--------------------------------------//
        String postfixExp2 = "* 3 4 + 2 /"; // ivalid expression
        System.out.println("----------------");
        double result = ExpCalculator.evalPostfix(postfixExp2);
        //--------------------------------------//
         */

        /*
        //--------------------------------------//
        String postfixExp3 = "3 4 & 2 /"; // ivalid expression
        System.out.println("----------------");
        double result = ExpCalculator.evalPostfix(postfixExp3);
        //--------------------------------------//
         */

        /*
        //--------------------------------------//
        String InfixExp1 = "(2-3 + 2*(4-1)"; // Invalid Expression
        System.out.println("----------------");
        String postfix = ExpCalculator.infixToPostfix(InfixExp1);
        //--------------------------------------//
         */

        /*
        //--------------------------------------//
        String InfixExp2 = "2&3 +(4-1)"; // Invalid Expression
        System.out.println("----------------");
        String postfix = ExpCalculator.infixToPostfix(InfixExp2);
        //--------------------------------------//
         */

    }
}
