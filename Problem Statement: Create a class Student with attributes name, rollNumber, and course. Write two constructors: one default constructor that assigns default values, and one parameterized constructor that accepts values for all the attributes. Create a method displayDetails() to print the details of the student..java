Problem Statement: Create a class Student with attributes name, rollNumber, and course. Write two
constructors: one default constructor that assigns default values, and one parameterized constructor
that accepts values for all the attributes. Create a method displayDetails() to print the details of the
student.




class Student {
    String name;
    int rollNumber;
    String course;

    // Default Constructor
    Student() {
        name = "Unknown";
        rollNumber = 0;
        course = "Not Assigned";
    }

    // Parameterized Constructor
    Student(String n, int r, String c) {
        name = n;
        rollNumber = r;
        course = c;
    }

    // Method to display student details
    void displayDetails() {
        System.out.println("Name: " + name);
        System.out.println("Roll Number: " + rollNumber);
        System.out.println("Course: " + course);
        System.out.println("-----------------------------");
    }
}

public class StudentDetails {
    public static void main(String[] args) {
        // Using Default Constructor
        Student s1 = new Student();

        // Using Parameterized Constructor
        Student s2 = new Student("Shravani", 212, "Business English");

        // Displaying details
        System.out.println("--- Student Details ---");
        s1.displayDetails();
        s2.displayDetails();
    }
}
