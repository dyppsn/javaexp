Problem Statement: Create a class Student with attributes name, rollNumber, and course. Write two
constructors: one default constructor that assigns default values, and one parameterized constructor
that accepts values for all the attributes. Create a method displayDetails() to print the details of the
student.




// Student.java
class Student {
    // Attributes
    String name;
    int rollNumber;
    String course;

    // Default constructor
    public Student() {
        name = "Unknown";
        rollNumber = 0;
        course = "Not Assigned";
    }

    // Parameterized constructor
    public Student(String name, int rollNumber, String course) {
        this.name = name;
        this.rollNumber = rollNumber;
        this.course = course;
    }

    // Method to display student details
    public void displayDetails() {
        System.out.println("Student Details:");
        System.out.println("Name: " + name);
        System.out.println("Roll Number: " + rollNumber);
        System.out.println("Course: " + course);
        System.out.println("-------------------------");
    }
}

// Main class to test Student class
public class Main {
    public static void main(String[] args) {
        // Using default constructor
        Student student1 = new Student();
        student1.displayDetails();

        // Using parameterized constructor
        Student student2 = new Student("Shravani Mahind", 101, "Computer Science");
        student2.displayDetails();
    }
}
