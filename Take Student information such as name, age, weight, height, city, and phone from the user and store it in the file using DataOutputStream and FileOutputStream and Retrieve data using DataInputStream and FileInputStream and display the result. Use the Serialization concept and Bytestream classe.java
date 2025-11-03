Take Student information such as name, age, weight, height, city, and phone from the user and store
it in the file using DataOutputStream and FileOutputStream and Retrieve data using
DataInputStream and FileInputStream and display the result. Use the Serialization concept and
Bytestream classe


import java.io.*;
import java.util.Scanner;

public class StudentDataBytestream {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String fileName = "studentdata.dat";

        try {
            // Writing data to file
            FileOutputStream fos = new FileOutputStream(fileName);
            DataOutputStream dos = new DataOutputStream(fos);

            System.out.print("Enter Name: ");
            String name = sc.nextLine();
            System.out.print("Enter Age: ");
            int age = sc.nextInt();
            System.out.print("Enter Weight: ");
            float weight = sc.nextFloat();
            System.out.print("Enter Height: ");
            float height = sc.nextFloat();
            sc.nextLine(); // Consume leftover newline
            System.out.print("Enter City: ");
            String city = sc.nextLine();
            System.out.print("Enter Phone Number: ");
            long phone = sc.nextLong();

            // Writing data to file using DataOutputStream
            dos.writeUTF(name);
            dos.writeInt(age);
            dos.writeFloat(weight);
            dos.writeFloat(height);
            dos.writeUTF(city);
            dos.writeLong(phone);

            dos.close();
            fos.close();
            System.out.println("\nData successfully written to file.\n");

            // Reading data from file
            FileInputStream fis = new FileInputStream(fileName);
            DataInputStream dis = new DataInputStream(fis);

            System.out.println("Retrieved Student Data:");
            String rName = dis.readUTF();
            int rAge = dis.readInt();
            float rWeight = dis.readFloat();
            float rHeight = dis.readFloat();
            String rCity = dis.readUTF();
            long rPhone = dis.readLong();

            System.out.println("Name: " + rName);
            System.out.println("Age: " + rAge);
            System.out.println("Weight: " + rWeight);
            System.out.println("Height: " + rHeight);
            System.out.println("City: " + rCity);
            System.out.println("Phone: " + rPhone);

            dis.close();
            fis.close();

        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }

        sc.close();
    }
}
