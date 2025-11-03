Problem Statement:
Create a Java program to demonstrate method overloading by defining multiple versions of the same method with different parameter lists.
Define a class Calculator with a method add() that can:
· Add two integers
· Add three integers
· Add two double values
In the Main class, create an object of Calculator and call the overloaded add() methods to display how
compile-time polymorphism works in Java



// Calculator.java
class Calculator {

    // Method to add two integers
    public int add(int a, int b) {
        return a + b;
    }

    // Method to add three integers
    public int add(int a, int b, int c) {
        return a + b + c;
    }

    // Method to add two double values
    public double add(double a, double b) {
        return a + b;
    }
}

// Main class to test Calculator
public class Main {
    public static void main(String[] args) {
        Calculator calc = new Calculator();

        // Calling add method with two integers
        int sum1 = calc.add(10, 20);
        System.out.println("Sum of 2 integers: " + sum1);

        // Calling add method with three integers
        int sum2 = calc.add(5, 15, 25);
        System.out.println("Sum of 3 integers: " + sum2);

        // Calling add method with two double values
        double sum3 = calc.add(10.5, 20.7);
        System.out.println("Sum of 2 doubles: " + sum3);
    }
}
