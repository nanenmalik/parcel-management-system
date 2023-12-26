import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Creating a Scanner object for user input
        Scanner input = new Scanner(System.in);

        String[] recipientNames = new String[30]; // 1D array to store user names
        //int[] houseNumbers = new int[30]; // 1D array to store house numbers
        //Parcel[][] poBoxes = new Parcel[30][3]; // 2D array to store Parcel objects

        int houseNumbers = 0;
        int option = 0;
        char answers;

        // load data from file if it already exists
        ParcelStorage.loadDataFromFile( poBoxes[][]);         //call from PropertySystem file

        do{
            System.out.println("Welcome to Property Management\n");

            System.out.println("------ View PO Box ------");

            System.out.println("Enter house number:");
            houseNumbers = input.nextInt();
            
            if( houseNumbers>=1 || houseNumbers<=30 ){

                System.out.println("Hello " + poBoxes[houseNumbers][0]);
            
                houseNumbers = houseNumbers - 1 ;
                System.out.println("You have " + poBoxes[houseNumbers][4] + " parcel in your mail.");

                if( poBoxes[houseNumbers][5] == "EXPIRED"){
                    System.out.println("Your Parcel are EXPIRED.");
                    System.out.println("Please contact your sender again to retrieve your parcel.");
                }

                else if( poBoxes[houseNumbers][5] == "NOTEXPIRED"){
                    System.out.println("Your parcel are" ); // + countdown day

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
            
                        timeExtended = poBoxes[houseNumbers][6].handleExtendTime(day);
                        System.out.println("Parcel to extend cost is RM" + (day * 3));
                        System.out.println("Your time has been extended to " + timeExtended);
            
                        System.out.println("Do you want to re-do? (Y/N): ");
                        answer = input.next().charAt(0);
            
                    } while (Character.toUpperCase(answer) == 'Y');
                }

                else if( poBoxes[houseNumbers][5] == "NOPARCEL"){
                    System.out.println("There are no parcel in your mail." ); // + countdown day
                }

                System.out.println("Do you want to view your PO Box information?");
                //put view data

            }
            
            if ( houseNumbers == 999){
                System.out.println("----------This is the System Update----------");

            try{
                System.out.println("1. View/Print all house data");
                System.out.println("2. View/Print certain house data");
                System.out.println("3. Update house data");
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
                                ParcelStorage.viewPoBoxData(poBoxes[][]);
                                } 
                            catch (IOException e) {
                                System.out.println("Error: " + e.getMessage()); // Print the error message
                                // Additional error handling if needed
                                }
                                break;
                    
                case 2:
                    //view [] house data
                    poBoxes[houseNumbers][0];
                    break;
                    
                case 3:
                    //update data
                    try {
                        ParcelStorage.updatePropertyData(poBoxes[][]);
                        // save the updated data to file
                        ParcelStorage.savingDataToFile(poBoxes[][]);
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

        }while(Character.toUpperCase(answers) == 'Y');


    }
}
