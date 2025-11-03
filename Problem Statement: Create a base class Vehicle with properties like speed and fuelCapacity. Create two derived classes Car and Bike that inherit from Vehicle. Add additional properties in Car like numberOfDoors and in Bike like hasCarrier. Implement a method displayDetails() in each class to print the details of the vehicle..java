Problem Statement: Create a base class Vehicle with properties like speed and fuelCapacity. Create
two derived classes Car and Bike that inherit from Vehicle. Add additional properties in Car like
numberOfDoors and in Bike like hasCarrier. Implement a method displayDetails() in each class to
print the details of the vehicle.



// Base class
class Vehicle {
    int speed;
    int fuelCapacity;

    // Constructor for Vehicle
    Vehicle(int speed, int fuelCapacity) {
        this.speed = speed;
        this.fuelCapacity = fuelCapacity;
    }

    // Display common details
    void displayDetails() {
        System.out.println("Speed: " + speed + " km/h");
        System.out.println("Fuel Capacity: " + fuelCapacity + " liters");
    }
}

// Derived class Car
class Car extends Vehicle {
    int numberOfDoors;

    // Constructor for Car
    Car(int speed, int fuelCapacity, int numberOfDoors) {
        super(speed, fuelCapacity); // Call base class constructor
        this.numberOfDoors = numberOfDoors;
    }

    // Display car details
    void displayDetails() {
        System.out.println("----- Car Details -----");
        super.displayDetails();
        System.out.println("Number of Doors: " + numberOfDoors);
        System.out.println("------------------------");
    }
}

// Derived class Bike
class Bike extends Vehicle {
    boolean hasCarrier;

    // Constructor for Bike
    Bike(int speed, int fuelCapacity, boolean hasCarrier) {
        super(speed, fuelCapacity);
        this.hasCarrier = hasCarrier;
    }

    // Display bike details
    void displayDetails() {
        System.out.println("----- Bike Details -----");
        super.displayDetails();
        System.out.println("Has Carrier: " + (hasCarrier ? "Yes" : "No"));
        System.out.println("------------------------");
    }
}

// Main class
public class VehicleDetails {
    public static void main(String[] args) {
        // Create Car object
        Car car = new Car(180, 50, 4);

        // Create Bike object
        Bike bike = new Bike(120, 15, true);

        // Display details
        car.displayDetails();
        bike.displayDetails();
    }
}
