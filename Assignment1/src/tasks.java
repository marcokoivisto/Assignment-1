import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;


/**
 * Created by Marco on 15-09-07.
 */

public class tasks {
    public static String task1(String infix){
        //Creating a variable for the output.
        String output = "", tmp = "";

        //Converting the infix string into a RPN string.
        //Creating the loop that will go on for every character in the infix string.
        for (int i = 0; i < infix.length(); i++){

            //Creating a variable to hold the character at position (i).
            char character = infix.charAt(i);
            //if statement for numbers.
            if (character >= '0' && character <= '9'){
                output += " " + character;
            }
            //if statement for left paranthases.
            else if (character == '('){
                tmp = character + tmp;
            }
            //if statement for right paranthases.
            else if (character == ')'){
                if (tmp.contains("(")){
                    int j = tmp.indexOf('(');
                    output += " " + tmp.substring(0, j);
                    tmp = tmp.substring(j+1, tmp.length());
                }
            }
            //if statement for operators.
            else if (character == '+' || character == '-' || character == '*' || character == '/'){

                while (true){
                    char t = tmp.length() > 0 ? tmp.charAt(0): ' ';
                    if (operatorCheck(t) < operatorCheck(character) || t == '(' || tmp.length() == 0) {
                        break;
                    }
                    output += " " + t;
                    tmp = tmp.substring(1, tmp.length());
                }
                tmp = character + tmp;
            }
        }
        //Adding a space between the operators that are left in tmp after the for-loop is done.
        for (int i = 0; i < tmp.length(); i++) {
            output += " " + tmp.charAt(i);
        }
        //Resetting tmp variable.
        tmp = "";

        //Returning the postfix string.
        return output;

    }
    public static int operatorCheck(char operator){
        if (operator == '+' || operator == '-'){
            return 0;
        }
        return 1;
    }
    public static double task2(String postfix){

        int i = 0;
        String tmp = "";
        double temp = 0;
        while (i <= postfix.length()-1){
            char character = postfix.charAt(i);
            i++;
            if (character >= '0' && character <= '9'){
                tmp += character;
            }
            else if (character == '+'){
                if (tmp.length() > 1) {
                    temp += Character.getNumericValue(tmp.charAt(0)) + Character.getNumericValue(tmp.charAt(1));
                }
                else
                    temp += Character.getNumericValue(tmp.charAt(0));
                tmp = "";
            }
            else if (character == '-'){
                if (tmp.length() > 1) {
                    temp += Character.getNumericValue(tmp.charAt(0)) - Character.getNumericValue(tmp.charAt(1));
                    System.out.println(temp);
                }
                else
                    temp -= Character.getNumericValue(tmp.charAt(0));
                tmp = "";
            }
            else if (character == '/'){
                if (tmp.length() > 1) {
                    temp = Character.getNumericValue(tmp.charAt(0)) / Character.getNumericValue(tmp.charAt(1));
                    System.out.println(temp);
                }
                else
                    temp /= Character.getNumericValue(tmp.charAt(0));
                tmp = "";
            }
            else if (character == '*'){
                if (tmp.length() > 1) {
                    temp += Character.getNumericValue(tmp.charAt(0)) * Character.getNumericValue(tmp.charAt(1));
                    System.out.println(temp);
                }
                else
                    temp *= Character.getNumericValue(tmp.charAt(0));
                tmp = "";
            }
            else
                continue;
        }
        return temp;
    }
    public static void welcome(){
        System.out.println(
                "+*****************************************+\n" +
                        "*                                         *\n" +
                        "*      Welcome to DIT948 Calculator.      *\n" +
                        "*            (Made by Marco)              *\n" +
                        "*                                         *\n" +
                "+*****************************************+\n"
        );
    }
    public static void runCalc(){
        //Creating a scanner to read user input
        Scanner sc = new Scanner(System.in);
        //Asking the user to enter a arithmetic expression to evaluate
        System.out.println("Please enter an arithmetic expression to evaluate>");
        //Saving the users input into a variable
        String infix = sc.nextLine();

        System.out.println("The RPN representation of your expression is> " + task1(infix));
        System.out.println("The final result is> " + task2(task1(infix)) + "\n");

        //Asking the user what he/she wants to do
        System.out.println("Press \"E\" to exit or any other button to continue> ");
        //Saving the users answer
        char choice = sc.next().charAt(0);
        //Letting the program know what choice the user made.
        if (choice == 'e' || choice == 'E'){
            System.exit(0);
        }
        else {
            runCalc();
        }
    }
}
