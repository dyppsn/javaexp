import java.util.Scanner;

public class FibonacciFactorial {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.print("Enter a number: ");
        int n = sc.nextInt();

        // Fibonacci Series
        System.out.println("\nFibonacci Series up to " + n + " terms:");
        int a = 0, b = 1, c;
        for (int i = 1; i <= n; i++) {
            System.out.print(a + " ");
            c = a + b;
            a = b;
            b = c;
        }

        // Factorial
        int fact = 1;
        for (int i = 1; i <= n; i++) {
            fact = fact * i;
        }
        System.out.println("\n\nFactorial of " + n + " is: " + fact);

        sc.close();
    }
}
