package JAVAPROJECT;
import java.util.Scanner;

public class ElectricityBill {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Input customer details
        System.out.print("Enter customer name: ");
        String name = scanner.nextLine();

        System.out.print("Enter number of units consumed: ");
        int units = scanner.nextInt();

        double billAmount = 0;

        // Bill calculation based on units
        if (units <= 100) {
            billAmount = units * 1.5;
        } else if (units <= 200) {
            billAmount = 100 * 1.5 + (units - 100) * 2.5;
        } else if (units <= 300) {
            billAmount = 100 * 1.5 + 100 * 2.5 + (units - 200) * 4.0;
        } else {
            billAmount = 100 * 1.5 + 100 * 2.5 + 100 * 4.0 + (units - 300) * 6.0;
        }

        // Optional fixed charge
        double fixedCharge = 50.0;
        billAmount += fixedCharge;

        // Print the bill
        System.out.println("\n---- Electricity Bill ----");
        System.out.println("Customer Name: " + name);
        System.out.println("Units Consumed: " + units);
        System.out.println("Fixed Charges: ₹" + fixedCharge);
        System.out.println("Total Bill Amount: ₹" + billAmount);

        scanner.close();
    }
}