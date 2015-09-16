import java.util.Scanner;
/**
 * Created by Marco on 15-09-07.
 */
public class main {
    public static void main(String[] args){
        //Creating a scanner for user input
        Scanner sc = new Scanner(System.in);
        //Printing out the welcome message
        tasks.welcome();
        //Asking the user what he/she wants to do
        System.out.println("Press \"E\" to exit or any other button to continue> ");
        //Saving the users answer
        char choice = sc.next().charAt(0);
        //Letting the program know what choice the user made.
        if (choice == 'e' || choice == 'E'){
            System.exit(0);
        }
        else {
            tasks.runCalc();
        }
    }
}
