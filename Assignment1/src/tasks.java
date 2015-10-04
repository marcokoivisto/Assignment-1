import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;


/**
 * Created by Marco on 15-09-07.
 */

public class tasks {
    public static String task1(String infix){
        //Creating a variable to hold the output and a variable to hold characters temp.
        String output = "", tmp = "";

        //Converting the infix string into a RPN string.
        //Creating the loop that will go on for every character in the infix string.
        for (int i = 0; i < infix.length(); i++){

            //Creating a variable to hold the character at position (i).
            char character = infix.charAt(i);
            //if statement for numbers, Statement - if number add number to variable of type string output.
            if (character >= '0' && character <= '9'){
                output += " " + character;
            }
            //if statement for left paranthases, if ( add character to variable of type string tmp.
            else if (character == '('){
                tmp = character + tmp;
            }
            //if statement for right paranthases, if ) and tmp contains ( add characters beetween ) - ( to output.
            else if (character == ')'){
                if (tmp.contains("(")){
                    int j = tmp.indexOf('(');
                    output += " " + tmp.substring(0, j);
                    tmp = tmp.substring(j+1, tmp.length());
                }
            }
            //if statement for operators, if tmp length is bigger then 0, t = first character, otherwise character = ' '
            else if (character == '+' || character == '-' || character == '*' || character == '/'){

                while (true){
                    char t = tmp.length() > 0 ? tmp.charAt(0): ' ';
                    // operatorCheck checks the value of the operator. If the value of first character in tmp is less than
                    // the value of the new character or  "t" is equal to ( or tmp length is 0 - break out of while loop.
                    // Otherwise add character "t" to output string. Then delete the character from tmp String until break.
                    if (operatorCheck(t) < operatorCheck(character) || t == '(' || tmp.length() == 0) {
                        break;
                    }
                    output += " " + t;
                    tmp = tmp.substring(1, tmp.length());
                }
                //add character to the beginning of tmp string.
                tmp = character + tmp;
            }
                // if character is a space just continue the loop.
            else if (character == ' '){
                continue;
            }
                //else if the character is a letter or something else, tell the user that the character is not valid.
            else
                System.out.println(character + " Is not a valid character!");
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
    private static int operatorCheck(char operator){
        //Checks if operator in variable "operator" has a value of "0" or "1".
        if (operator == '+' || operator == '-'){
            return 0;
        }
        return 1;
    }
    public static double task2(String postfix){
        int i = 0;
        String tmp = "";
        double temp = 0;
        //While loop is running as long as "i" is less or equal to the postfix string length. (All characters)
        while (i <= postfix.length()-1){
            //Variable character is dependent of i, so will be changed as the loop starts over again.
            char character = postfix.charAt(i);
            i++;
            //If the character is numeric it will be added to the String "tmp".
            if (character >= '0' && character <= '9'){
                tmp += character;
            }
            //If the character is a operator + and the length of tmp is bigger then 2 or equal to 2, the two characters in tmp will be added to each other
            //and then to temp variable of type int. Else the character will directly be + to temp. Then the character will be deleted from tmp.
            else if (character == '+'){
                if (tmp.length() >= 2) {
                    temp += Character.getNumericValue(tmp.charAt(tmp.length()-2)) + Character.getNumericValue(tmp.charAt(tmp.length()-1));
                }
                else if (tmp.length() < 2 && tmp.length() != 0) {
                    temp += Character.getNumericValue(tmp.charAt(tmp.length()-1));
                }
                if (tmp.length() > 2){
                    tmp = tmp.substring(0, tmp.length() - 2);
                }
                else tmp = "";
            }
            //If the character is a operator - and the length of tmp is bigger then 2 or equal to 2, the two characters in tmp will be substrate to each other
            //and then to temp variable of type int. Else temp will be - with the character. Then the character will be deleted from tmp.
            else if (character == '-'){
                if (tmp.length() >= 2) {
                    temp += Character.getNumericValue(tmp.charAt(tmp.length()-2)) - Character.getNumericValue(tmp.charAt(tmp.length()-1));
                }
                else if (tmp.length() < 2 && tmp.length() != 0) {
                    temp -= Character.getNumericValue(tmp.charAt(tmp.length()-1));
                }
                if (tmp.length() > 2){
                    tmp = tmp.substring(0, tmp.length() - 2);
                }
                else tmp = "";
            }
            //If the character is a operator / and the length of tmp is bigger then 2 or equal to 2, the two characters in tmp will be divided by each other
            //and then to temp variable of type int. Else temp will be / with the character. Then the character will be deleted from tmp.
            else if (character == '/'){
                if (tmp.length() >= 2) {
                    temp += (double)Character.getNumericValue(tmp.charAt(tmp.length()-2)) / (double)Character.getNumericValue(tmp.charAt(tmp.length()-1));
                    //
                }
                else if (tmp.length() < 2 && tmp.length() != 0) {
                    temp /= Character.getNumericValue(tmp.charAt(tmp.length() - 1));
                }
                if (tmp.length() > 2){
                    tmp = tmp.substring(0, tmp.length() - 2);
                }
                else tmp = "";
            }
            //If the character is a operator and the length of tmp is bigger then 2 or equal to 2, the two characters in tmp will be multiplied to each other
            //and then to temp variable of type int. Else temp will be * with the character. Then the character will be deleted from tmp.
            else if (character == '*'){
                if (tmp.length() >= 2) {
                    temp += Character.getNumericValue(tmp.charAt(tmp.length()-2)) * Character.getNumericValue(tmp.charAt(tmp.length()-1));
                }
                else if (tmp.length() < 2 && tmp.length() != 0) {
                    temp *= Character.getNumericValue(tmp.charAt(tmp.length() - 1));
                }
                if (tmp.length() > 2){
                    tmp = tmp.substring(0, tmp.length() - 2);
                }
                else tmp = "";
            }
            //I've added spaces between every character so if it's a space the while-loop will just continue.
            else
                continue;
        }
        return temp;
    }
    public static void welcome(){
        //Printing out the welcome message.
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
