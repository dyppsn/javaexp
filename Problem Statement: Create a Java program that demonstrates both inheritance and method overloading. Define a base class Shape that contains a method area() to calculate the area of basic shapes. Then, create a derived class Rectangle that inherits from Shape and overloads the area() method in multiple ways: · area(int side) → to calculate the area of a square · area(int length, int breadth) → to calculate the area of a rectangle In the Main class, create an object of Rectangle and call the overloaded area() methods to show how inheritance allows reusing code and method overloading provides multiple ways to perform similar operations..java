Problem Statement:
Create a Java program that demonstrates both inheritance and method overloading.
Define a base class Shape that contains a method area() to calculate the area of basic shapes.
Then, create a derived class Rectangle that inherits from Shape and overloads the area() method in
multiple ways:
· area(int side) → to calculate the area of a square
· area(int length, int breadth) → to calculate the area of a rectangle
In the Main class, create an object of Rectangle and call the overloaded area() methods to show how
inheritance allows reusing code and method overloading provides multiple ways to perform
similar operations.



// Base class
class Shape {
    // Method to calculate area (can be overridden)
    void area() {
        System.out.println("Calculating area of a shape...");
    }
}

// Derived class Rectangle
class Rectangle extends Shape {

    // Overloaded method to calculate area of a square
    int area(int side) {
        return side * side;
    }

    // Overloaded method to calculate area of a rectangle
    int area(int length, int breadth) {
        return length * breadth;
    }
}

// Main class
public class ShapeDemo {
    public static void main(String[] args) {
        Rectangle rect = new Rectangle();

        // Call base class method
        rect.area();  // Inherited from Shape

        // Call overloaded methods
        int squareArea = rect.area(5); // Square with side 5
        int rectangleArea = rect.area(4, 6); // Rectangle 4x6

        System.out.println("Area of square (side=5): " + squareArea);
        System.out.println("Area of rectangle (4x6): " + rectangleArea);
    }
}
