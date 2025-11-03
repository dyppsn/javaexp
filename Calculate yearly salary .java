Calculate yearly salary 

import java.util.Scanner;

class Employee {
    String firstName;
    String lastName;
    double monthlySalary;

    // Constructor
    Employee(String fName, String lName, double salary) {
        firstName = fName;
        lastName = lName;
        if (salary > 0)
            monthlySalary = salary;
        else
            monthlySalary = 0;
    }

    // Method to calculate yearly salary
    double yearlySalary() {
        return monthlySalary * 12;
    }

    // Method to increase salary by given percentage
    void increaseSalary(double percent) {
        monthlySalary += (monthlySalary * percent / 100);
    }

    // Method to display employee details
    void display() {
        System.out.println("Employee Name: " + firstName + " " + lastName);
        System.out.println("Monthly Salary: " + monthlySalary);
        System.out.println("Yearly Salary: " + yearlySalary());
    }
}

public class EmployeeDetails {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Input details
        System.out.print("Enter first name: ");
        String fName = sc.nextLine();
        System.out.print("Enter last name: ");
        String lName = sc.nextLine();
        System.out.print("Enter monthly salary: ");
        double salary = sc.nextDouble();

        // Create Employee object
        Employee emp = new Employee(fName, lName, salary);

        System.out.println("\n--- Employee Details ---");
        emp.display();

        // Apply increment
        System.out.print("\nEnter increment percentage: ");
        double inc = sc.nextDouble();
        emp.increaseSalary(inc);

        System.out.println("\n--- After Increment ---");
        emp.display();

        sc.close();
    }
}
