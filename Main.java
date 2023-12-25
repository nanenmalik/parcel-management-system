import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Creating a Scanner object for user input
        Scanner scanner = new Scanner(System.in);

        String[] recipientNames = new String[30]; // 1D array to store user names
        int[] houseNumbers = new int[30]; // 1D array to store house numbers
        Parcel[][] poBoxes = new Parcel[30][3]; // 2D array to store Parcel objects

        int count = 0;
        int option = 0;

        // load data from file if it already exists
        ParcelStorage.loadDataFromFile(recipientNames, poBoxes, houseNumbers);         //call from PropertySystem file
        System.out.println("Welcome to Property Management\n");

        do{
            // Taking user input for creating a Parcel object
            // System.out.println("Enter recipient name:");
            // String inputRecipientName = scanner.nextLine();

            System.out.println("Enter house number:");
            int inputHouseNumber = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character

        }while
    }
}
