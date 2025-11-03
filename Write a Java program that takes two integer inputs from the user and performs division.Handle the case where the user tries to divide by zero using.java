Write a Java program that takes two integer inputs from the user and performs division.Handle
the case where the user tries to divide by zero using
ArithmeticException.Display a meaningful error message when such an exception
occurs, and prompt the user to enter valid numbers again.



import java.util.Scanner;

public class DivisionProgram {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int numerator = 0, denominator = 0;
        boolean validInput = false;

        while (!validInput) {
            try {
                // Input numerator
                System.out.print("Enter numerator: ");
                numerator = sc.nextInt();

                // Input denominator
                System.out.print("Enter denominator: ");
                denominator = sc.nextInt();

                // Perform division
                int result = numerator / denominator;
                System.out.println("Result: " + result);
                validInput = true; // successful division, exit loop

            } catch (ArithmeticException e) {
                System.out.println("Error: Division by zero is not allowed. Please enter valid numbers.");
            } catch (Exception e) {
                System.out.println("Error: Invalid input. Please enter integers only.");
                sc.nextLine(); // clear the invalid input
            }
        }

        sc.close();
    }
}
