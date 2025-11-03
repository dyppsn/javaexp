Problem Statement:
Create a Java program that demonstrates method overriding using an inheritance hierarchy.
Define a base class Employee with a method displayDetails() that shows general information like
employee name and ID.
Then create two subclasses:
· FullTimeEmployee – overrides displayDetails() to include salary and working hours.
· PartTimeEmployee – overrides displayDetails() to include hourly wage and total hours
worked.
In the Main class, create objects of both subclasses and call their displayDetails() methods to show
how method overriding allows subclasses to provide specific implementations for the same method
name.



// Base class
class Employee {
    String name;
    int id;

    // Constructor
    Employee(String name, int id) {
        this.name = name;
        this.id = id;
    }

    // Method to display general employee details
    void displayDetails() {
        System.out.println("Employee Name: " + name);
        System.out.println("Employee ID: " + id);
    }
}

// Subclass for full-time employees
class FullTimeEmployee extends Employee {
    double salary;
    int workingHours;

    // Constructor
    FullTimeEmployee(String name, int id, double salary, int workingHours) {
        super(name, id);
        this.salary = salary;
        this.workingHours = workingHours;
    }

    // Overriding displayDetails() method
    @Override
    void displayDetails() {
        super.displayDetails(); // call base class method
        System.out.println("Salary: $" + salary);
        System.out.println("Working Hours: " + workingHours + " per week");
        System.out.println("----------------------------");
    }
}

// Subclass for part-time employees
class PartTimeEmployee extends Employee {
    double hourlyWage;
    int totalHoursWorked;

    // Constructor
    PartTimeEmployee(String name, int id, double hourlyWage, int totalHoursWorked) {
        super(name, id);
        this.hourlyWage = hourlyWage;
        this.totalHoursWorked = totalHoursWorked;
    }

    // Overriding displayDetails() method
    @Override
    void displayDetails() {
        super.displayDetails(); // call base class method
        System.out.println("Hourly Wage: $" + hourlyWage);
        System.out.println("Total Hours Worked: " + totalHoursWorked);
        System.out.println("----------------------------");
    }
}

// Main class
public class Main {
    public static void main(String[] args) {
        // Create objects of subclasses
        FullTimeEmployee fullTimeEmp = new FullTimeEmployee("Alice", 101, 50000, 40);
        PartTimeEmployee partTimeEmp = new PartTimeEmployee("Bob", 102, 20, 25);

        // Call displayDetails() for each object
        fullTimeEmp.displayDetails();
        partTimeEmp.displayDetails();
    }
}
