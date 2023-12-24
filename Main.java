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
        ParcelStorage.loadDataFromFile(recipientNames, poBoxes,  houseNumbers);         //call from PropertySystem file
        System.out.println("Welcome to Property Management\n");

        // Taking user input for creating a Parcel object
        System.out.println("Enter recipient name:");
        String inputRecipientName = scanner.nextLine();

        System.out.println("Enter house number:");
        int inputHouseNumber = scanner.nextInt();
        scanner.nextLine(); // Consume the newline character

        // System edit need to KIV
        System.out.println("Enter parcel content:");
        String content = scanner.nextLine();

        // Creating a Parcel object based on user input
        Parcel parcel = new Parcel(inputRecipientName, inputHouseNumber, content);

        // Storing the Parcel object in the 2D array
        recipientNames[inputHouseNumber - 1] = inputRecipientName; // assuming house numbers start from 1
        houseNumbers[inputHouseNumber - 1] = inputHouseNumber; // storing house number
        poBoxes[inputHouseNumber - 1][0] = parcel; // storing in the first column, adjust as needed

        // Displaying initial information
        System.out.println("Initial Parcel Details:");
        System.out.println(poBoxes[inputHouseNumber - 1][0]);
        System.out.println("Is the parcel expired? " + poBoxes[inputHouseNumber - 1][0].isExpired());
        System.out.println("Parcel cost: $" + poBoxes[inputHouseNumber - 1][0].getParcelCost());
        System.out.println();

        // Handling extend time for the parcel
        System.out.println("Handling extend time for 3 days...");
        poBoxes[inputHouseNumber - 1][0].handleExtendTime(3);
        System.out.println("Updated Parcel Details:");
        System.out.println(poBoxes[inputHouseNumber - 1][0]);
        System.out.println("Is the parcel expired? " + poBoxes[inputHouseNumber - 1][0].isExpired());
        System.out.println("Parcel cost: $" + poBoxes[inputHouseNumber - 1][0].getParcelCost());
        System.out.println();

        // Handling return of the parcel
        System.out.println("Handling return of the parcel...");
        poBoxes[inputHouseNumber - 1][0].handleReturn();
        System.out.println("Updated Parcel Details:");
        System.out.println(poBoxes[inputHouseNumber - 1][0]);
        System.out.println("Is the parcel expired? " + poBoxes[inputHouseNumber - 1][0].isExpired());
        System.out.println("Parcel cost: $" + poBoxes[inputHouseNumber - 1][0].getParcelCost());

        // Closing the scanner (optional)
        scanner.close();
    }
}


