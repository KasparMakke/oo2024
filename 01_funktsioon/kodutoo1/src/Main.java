import java.util.Random;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        String firstName;
        String lastName;
        int userAge;
        float userBalance;

        System.out.print("Console: Enter users first name> ");
        firstName = scanner.nextLine();

        System.out.print("Console: Enter users last name> ");
        lastName = scanner.nextLine();

        System.out.print("Console: Enter users age> ");
        userAge = scanner.nextInt();

        userBalance = GenerateUserBalance(random, firstName, lastName, userAge);

        System.out.println("Console: Users balance is> " + userBalance);
    }

    public static float GenerateUserBalance(
            Random random,
            String _firstName,
            String _lastName,
            int _age
    ){
        System.out.println("Console: Generating user balance...");
        return random.nextFloat(1, 100);
    }
}