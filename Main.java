import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        // Creating a Scanner object for user input
        Scanner scanner = new Scanner(System.in);

        // Taking user input for creating a Parcel object
        System.out.println("Enter recipient name:");
        String recipientName = scanner.nextLine();

        System.out.println("Enter house number:");
        int houseNumber = scanner.nextInt();
        scanner.nextLine(); // Consume the newline character

        System.out.println("Enter parcel content:");
        String content = scanner.nextLine();

        // Creating a Parcel object based on user input
        Parcel parcel = new Parcel(recipientName, houseNumber, content);

        // Displaying initial information
        System.out.println("Initial Parcel Details:");
        System.out.println(parcel);
        System.out.println("Is the parcel expired? " + parcel.isExpired());
        System.out.println("Parcel cost: $" + parcel.getParcelCost());
        System.out.println();

        // Handling extend time for the parcel
        System.out.println("Handling extend time for 3 days...");
        parcel.handleExtendTime(3);
        System.out.println("Updated Parcel Details:");
        System.out.println(parcel);
        System.out.println("Is the parcel expired? " + parcel.isExpired());
        System.out.println("Parcel cost: $" + parcel.getParcelCost());
        System.out.println();

        // Handling return of the parcel
        System.out.println("Handling return of the parcel...");
        parcel.handleReturn();
        System.out.println("Updated Parcel Details:");
        System.out.println(parcel);
        System.out.println("Is the parcel expired? " + parcel.isExpired());
        System.out.println("Parcel cost: $" + parcel.getParcelCost());

        // Closing the scanner
        scanner.close();
    }

} // Closing curly brace for the class body
