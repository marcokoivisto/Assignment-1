import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;


/**
 * Created by Marco on 15-09-07.
 */

public class tasks {
    public static void task1(){

        //Creating a scanner for user input.
        Scanner sc = new Scanner(System.in);
        //Asking the user for a infix string
        System.out.println("Hi, please enter a infix string! (This program will convert it into RPN).");
        //Creating a variable for the infix string and also reading the value.
        String infix = sc.nextLine();
        //Creating a variable for the output.
        String output = "", tmp = "";
        //Getting the amount of characters.
        int length = infix.length();


        //Converting the infix string into a RPN string.
        for (int i = 0; i < length; i++){

            char character = infix.charAt(i);
            if (character >= '0' && character <= '9'){
                output = output + character;
            }
            else if (character == '('){
                tmp = character + tmp;
                //tmp = tmp + character;
            }
            else if (character == ')'){

                tmp = character + tmp;
                int j = tmp.indexOf('(');
                if (tmp.contains("(") && tmp.contains(")")){
                    output += tmp.substring(1, j);
                    String remove = tmp.substring(0, j+1);
                    tmp = tmp.replace(remove,"");
                    System.out.println(tmp);
                }
                //5+5*10+(4+3)
            }
            else if (character == '+' || character == '-' || character == '*' || character == '/'){
                //tmp = tmp + character;

                char t = tmp.length() > 0 ? tmp.charAt(tmp.length()-1): ' ';
                while (tmp.length() > 0 && !(operatorCheck(t) < operatorCheck(character)) && t != '('){
                    output += t;
                    tmp = tmp.substring(0, tmp.length()-1);
                }
                tmp = character + tmp;
            }

            // test - System.out.println(infix.charAt(i));
            System.out.println("tmp:" + tmp);
            System.out.println("output" + output + "\n");

        }

        output += tmp;
        tmp = "";



        //test print out.
        System.out.println("infix is: " + infix + "\n");
        System.out.println("infix length is: " + length + " chars.\n");
        System.out.println("output: " + output + "\n");
        System.out.println("in tmp: " + tmp + "\n");

    }
    public static int operatorCheck(char operator){
        if (operator == '+' || operator == '-'){
            return 0;
        }
        return 1;
    }
    public static void task2(){
        //Creating a scanner for user input
        Scanner sc = new Scanner(System.in);
        //Printing out the welcome message
        welcome();
        //Asking the user what he/she wants to do
        System.out.println("Press \"E\" to exit or any other button to continue> ");
        //Saving the users answer
        char choice = sc.next().charAt(0);
        //Letting the program know what choice the user made.
        if (choice == 'e' || choice == 'E'){
            System.exit(0);
        }
        else {
            runcalc();
        }
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
    public static void runcalc(){
        //Creating a scanner to read user input
        Scanner sc = new Scanner(System.in);
        //Asking the user to enter a arithmetic expression to evaluate
        System.out.println("Please enter an arithmetic expression to evaluate>");
        //Saving the users input into a variable
        String infix = sc.nextLine();


        //Creating a variable for the output.
        String output = "", tmp = "";
        //Getting the amount of characters.
        int length = infix.length();
        //Converting the infix string into a RPN string.
        for (int i = 0; i < length; i++){
            char character = infix.charAt(i);
            if (character >= '0' && character <= '9'){
                output = output + character;
            }
            else if (character == '('){
                tmp = character + tmp;
                //tmp = tmp + character;
            }
            else if (character == ')'){

                tmp = character + tmp;
                int j = tmp.indexOf('(');
                if (tmp.contains("(") || tmp.contains(")")){
                    output += tmp.substring(1, j);
                    String remove = tmp.substring(0, j+1);
                    tmp = tmp.replace(remove,"");
                }
            }
            else if (character == '+' || character == '-' || character == '*' || character == '/'){
                //tmp = tmp + character;
                tmp = character + tmp;
            }
            // test - System.out.println(infix.charAt(i));
        }


        //HELP!!!!!
        if (!tmp.contains("(") || !tmp.contains(")")){
            output += tmp;
            tmp = "";
        }


        System.out.println("The RPN representation of your expression is> " + output + "\n");
        //System.out.println("The final result is>" + infix + "\n");
        System.out.println("The final result is> " + infix);


        //Asking the user what he/she wants to do
        System.out.println("Press \"E\" to exit or any other button to continue> ");
        //Saving the users answer
        char choice = sc.next().charAt(0);
        //Letting the program know what choice the user made.
        if (choice == 'e' || choice == 'E'){
            System.exit(0);
        }
        else {
            task2();
        }

    }
}
