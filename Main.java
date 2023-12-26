import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        // Creating a Scanner object for user input
        Scanner input = new Scanner(System.in);

        int houseNumbers = 0;
        int option = 0;
        char answers = ' ';
        int parcelCost;

        String[][] poBox = new String[30][5];
        String[] recipient = new String[houseNumbers];

        // load data from file if it already exists
        ParcelStorage.loadDataFromFile ( recipient, poBox, houseNumbers );         //call from ParcelStorage file

        do{
            System.out.println("Welcome to Property Management\n");

            System.out.println("------ View PO Box ------");

            System.out.println("Enter house number:");
            houseNumbers = input.nextInt();
            
            if( houseNumbers>=1 || houseNumbers<=30 ){

                System.out.println("Hello " + poBox[houseNumbers][0]);
            
                houseNumbers = houseNumbers - 1 ;//poBoxes[houseNumbers][2] kena tukar jadi int
                System.out.println("You have " + poBox[houseNumbers][2] + " parcel in your mail.");

                if( poBox[houseNumbers][5] == "EXPIRED"){
                    System.out.println("Your Parcel has EXPIRED.");
                    System.out.println("Please contact your sender again to retrieve your parcel.");
                }

                else if( poBox[houseNumbers][5] == "NONE"){
                    System.out.println("Your parcel are" + poBox[houseNumbers][4]);

                    char answer;
                    do {
                        int day = 0;
                        int timeExtended = 0;
            
                        System.out.println("Do you wish to extend time for your parcel package?");
                        
                        // Input validation
                        while (true) {
                            try {
                                day = input.nextInt();
                                break; // Break out of the loop if input is an integer
                            } catch (java.util.InputMismatchException e) {
                                System.out.println("Invalid input. Please enter a valid integer.");
                                input.next(); // Consume the invalid input
                            }
                        }
            
                        parcelCost = Parcel.handleExtendTime(day);
                        System.out.println("Parcel to extend cost is RM" + parcelCost);
                        System.out.println("Your time has been extended to " + timeExtended);
            
                        System.out.println("Do you want to re-do? (Y/N): ");
                        answer = input.next().charAt(0);
            
                    } while (Character.toUpperCase(answer) == 'Y');
                }

                else if( poBox[houseNumbers][5] == "NOPARCEL"){
                    System.out.println("There are no parcel in your mail." ); // + countdown day
                }

                System.out.println("Do you want to view your PO Box information?");
                //put view data

            }
    //-------------------------------------------------------------------------------------------------------

            if ( houseNumbers == 999){
                System.out.println("----------This is the System Update----------");

                try{
                    System.out.println("1. insert all PO Box data");
                    System.out.println("2. View/Print entered PO Box house number");
                    System.out.println("3. Update PO Box data");
                    option = input.nextInt();   
                }
                catch (InputMismatchException e) {
                    System.out.println();
                    System.out.println("Error: Invalid input. Please enter a valid option.");
                    System.out.println();
                    input.nextLine(); // Consume the remaining input
                    continue; // Continue to the next iteration of the loop
                    }
            
            switch (option) {
                case 1:
                    //view all data
                        
                            try {
                                ParcelStorage.insertingData( recipient, poBox, houseNumbers);
                                } 
                            catch (IOException e) {
                                System.out.println("Error: " + e.getMessage()); // Print the error message
                                // Additional error handling if needed
                                }
                                break;
                    
                case 2:
                    //view [] house data
                    // Specify the row index you want to print
                    int rowIndexToPrint = 0; // Change this to the desired row index
                    houseNumbers = rowIndexToPrint;

                    // Check if the specified row index is valid
                    if (rowIndexToPrint >= 0 && rowIndexToPrint < poBox.length) {
                    // Print the specified row
                    System.out.println("Row " + rowIndexToPrint + ":");
                        for (int i = 0; i < poBox[rowIndexToPrint].length; i++) {
                        System.out.print(poBox[rowIndexToPrint][i] + " ");
                        }
                    break;
                    }

                case 3:
                    //update data
                    try {
                        //ParcelStorage.updatePoBoxData( recipient, poBox, houseNumbers);
                        // save the updated data to file
                        ParcelStorage.savingDataToFile( recipient, poBox, houseNumbers);
                        } 
                    catch (IOException e) {
                        System.out.println("Error: " + e.getMessage()); // Print the error message
                        // Additional error handling if needed
                        }
                    break;
            }
        }
            System.out.println("Do you want to re-do? (Y/N): ");
            answers = input.next().charAt(0);

        }
        while(Character.toUpperCase(answers) == 'Y');

        input.close();
    }
}