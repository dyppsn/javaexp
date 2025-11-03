Problem Statement: Create an abstract class Shape with an abstract method calculateArea(). Then,
create two concrete classes Circle and Rectangle that extend the Shape class and implement the
calculateArea() method for their respective shapes. Write a main class to create objects of Circle and
Rectangle and calculate their areas



// Shape.java
abstract class Shape {
    // Abstract method
    abstract double calculateArea();
}

// Circle.java
class Circle extends Shape {
    double radius;

    // Constructor
    public Circle(double radius) {
        this.radius = radius;
    }

    // Implement calculateArea() for Circle
    @Override
    double calculateArea() {
        return Math.PI * radius * radius;
    }
}

// Rectangle.java
class Rectangle extends Shape {
    double length;
    double width;

    // Constructor
    public Rectangle(double length, double width) {
        this.length = length;
        this.width = width;
    }

    // Implement calculateArea() for Rectangle
    @Override
    double calculateArea() {
        return length * width;
    }
}

// Main class
public class Main {
    public static void main(String[] args) {
        // Create Circle object
        Circle circle = new Circle(5.0);
        System.out.println("Area of Circle: " + circle.calculateArea());

        // Create Rectangle object
        Rectangle rectangle = new Rectangle(4.0, 6.0);
        System.out.println("Area of Rectangle: " + rectangle.calculateArea());
    }
}
