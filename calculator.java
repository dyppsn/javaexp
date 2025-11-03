Calculator 



import java.util.Scanner;

public class MultiCalculator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("----- Simple Multi Calculator -----");
        System.out.println("1. Arithmetic Operations");
        System.out.println("2. Logical Comparisons");
        System.out.println("3. String Concatenation");
        System.out.print("Enter your choice (1-3): ");
        int choice = sc.nextInt();

        switch (choice) {
            // ----- Arithmetic Operations -----
            case 1:
                System.out.print("Enter first number: ");
                double a = sc.nextDouble();
                System.out.print("Enter second number: ");
                double b = sc.nextDouble();

                System.out.println("Choose operation (+, -, *, /): ");
                char op = sc.next().charAt(0);

                double result = 0;
                switch (op) {
                    case '+': result = a + b; break;
                    case '-': result = a - b; break;
                    case '*': result = a * b; break;
                    case '/':
                        if (b != 0)
                            result = a / b;
                        else {
                            System.out.println("Division by zero not allowed!");
                            sc.close();
                            return;
                        }
                        break;
                    default:
                        System.out.println("Invalid operator!");
                        sc.close();
                        return;
                }
                System.out.println("Result: " + result);
                break;

            // ----- Logical Comparisons -----
            case 2:
                System.out.print("Enter first number: ");
                int x = sc.nextInt();
                System.out.print("Enter second number: ");
                int y = sc.nextInt();

                System.out.println("Choose comparison (>, <, ==, !=, >=, <=): ");
                String cmp = sc.next();

                boolean ans = false;
                switch (cmp) {
                    case ">": ans = x > y; break;
                    case "<": ans = x < y; break;
                    case "==": ans = x == y; break;
                    case "!=": ans = x != y; break;
                    case ">=": ans = x >= y; break;
                    case "<=": ans = x <= y; break;
                    default:
                        System.out.println("Invalid comparison!");
                        sc.close();
                        return;
                }
                System.out.println("Result: " + ans);
                break;

            // ----- String Concatenation -----
            case 3:
                sc.nextLine(); // clear buffer
                System.out.print("Enter first string: ");
                String s1 = sc.nextLine();
                System.out.print("Enter second string: ");
                String s2 = sc.nextLine();
                System.out.println("Concatenated String: " + s1 + " " + s2);
                break;

            default:
                System.out.println("Invalid choice!");
        }

        sc.close();
    }
}
