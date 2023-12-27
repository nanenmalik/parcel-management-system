import java.io.*;
import java.util.Scanner;
/**
 */
public class Main {
    public static void main(String[] args) throws IOException {

        //Scanner object to read input from the user 
        Scanner in = new Scanner(System.in); 
        
        // Variables to store information about agents, properties, and customers
        String[] recipient = new String[31];          //1D array to store recipient name
        String[] houseNumber = new String[30];       //1D array to store houseNumber name
        String[][] poBox = new String[31][7]; // 2D array to store properties, 
                                                   //each row representing a property and each column representing a property detail 
        int count = 0 ;
        int row = 0 ;
        char answer;
        
        
        //boolean

        // load data from file if it already exists
        ParcelStorage.loadDataFromFile(recipient, houseNumber, poBox);         //call Parcel Storage file
        System.out.println("Welcome to Property Management\n");

        String username = ParcelStorage.userAuthentication( recipient, houseNumber, poBox);
        
        // Print the result
        System.out.println("Hello " + username + (". Hope you are in a good Day!!"));

    do{
            System.out.print("----- Welcome to PO Box -----");

            System.out.println("1. Check Inbox");
            System.out.println("2. View/Print Your POBox");
            System.out.println("3. Exit");
    

           int choice = 0;

   /*  while (true) {
        if (in.hasNextInt()) {
        choice = in.nextInt();
        break;
        } else {
        System.out.println("Invalid input. Please enter a valid integer.");
        in.next(); // consume the invalid input
    }*/
  
            System.out.print("Enter your choice: ");
            switch (choice) {
                case 1:{//check inbox
                    {
                        row = ParcelStorage.findUserRowIndex( poBox, username);
                        
                        Parcel parcel = new Parcel(recipient, houseNumber, poBox); // Create an instance of the Parcel class
                        if (parcel.isExpired()) {
                            System.out.println("Your Parcel has EXPIRED.");
                            System.out.println("Please contact your sender again to retrieve your parcel.");
                        } else {
                            System.out.println("Your parcel has " + parcel.getCountdownTime() + " days left.");
                            System.out.println("Do you wish to extend time for your parcel package? Enter days: ");
                            int daysToExtend = in.nextInt();
                            
                            int parcelCost = parcel.handleExtendTime(daysToExtend);
                            System.out.println("Parcel to extend cost is RM" + parcelCost);
                            System.out.println("Your time has been extended to " + parcel.getCountdownTime() + " days.");
                        }
                        // if( poBox[houseNumbers][5] == "EXPIRED"){
                        //     System.out.println("Your Parcel has EXPIRED.");
                        //     System.out.println("Please contact your sender again to retrieve your parcel.");
                        // }

                        // else if( poBox[houseNumbers][5] == "NONE"){
                        //     System.out.println("Your parcel are" + poBox[houseNumbers][4]);
                    //------------------------------------------------------------------------
                        //     do {
                        //         int day = 0;
                        //         int timeExtended = 0;
                    
                        //         System.out.println("Do you wish to extend time for your parcel package?");
                                
                        //         // Input validation
                        //         class Parcel {
                        //             private int costPerDay;
        
                        //             public Parcel() {
                        //                 // Initialize the cost per day
                        //                 costPerDay = 10;
                        //             }
        
                        //             public int handleExtendTime(int day) {
                        //                 return costPerDay * day;
                        //             }
                        //         }
                    //--------------------------------------------------------------------------
                        // Parcel parcel = new Parcel(); // Create an instance of the Parcel class
                        // parcelCost = parcel.handleExtendTime(day);
                        // System.out.println("Parcel to extend cost is RM" + parcelCost);
                        // System.out.println("Your time has been extended to " + timeExtended);
        
                    }
                        break;
                    } 
                    
                    
                case 2:
                    { //view data
                        //row??
                        row = ParcelStorage.findUserRowIndex( poBox, username);

                            if (row >= 0) {
                                ParcelStorage.printColumnsForRow(poBox, row);
                            } else {
                                System.out.println("User not found.");
                            }
                    
                    break;
                    }
        
                case 3:
                        //exit the program
                        return;
                    
                default:
                        System.out.println();        
                        System.out.println("Invalid choice.");
                        System.out.println();
                  }

            System.out.println("Do you want to continue?(Y/N): ");
            answer = ' ';
                if( answer == 'N'){
                    break;
                }
                answer = in.next().charAt(0);
            } while (answer == 'Y' || answer == 'y');
         
    
        //-------------------------------------------------------------------------------------------------------
        boolean isAuthenticated = false;

        if (isAuthenticated) {
        
        
    
        // Main menu for parcel management system
        while (isAuthenticated) {

            count = 0;

            System.out.println("1. Insert data");
            System.out.println("2. View/Print data");
            System.out.println("3. Update data");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            int option = in.nextInt();

            switch (option) {
                case 1:
                    //insert data
                    if(count < 10) {
                        // increment the count to insert data to the next index
                        count = ParcelStorage.insertingData(recipient, houseNumber, poBox, count);
                        //save the data to the file
                        ParcelStorage.savingDataToFile(recipient, houseNumber, poBox);
                    } 
                    
                    else
                        System.out.println("List is property is maximum"); 
                        //User cannot add more data if list of rows is already 10
                    
                    break;
                    
                case 2:
                    //view data
                    ParcelStorage.viewPropertyData(recipient, houseNumber, poBox);
                    break;
                    
                case 3:
                    //update data
                    ParcelStorage.updatePropertyData(recipient, houseNumber, poBox);
                    //save the updated data to file
                    ParcelStorage.savingDataToFile(recipient, houseNumber, poBox);
                    break;
                    
                    case 4:
                        //exit the program
                        return;
                    
                    default:
                        System.out.println();        
                        System.out.println("Invalid choice.");
                        System.out.println();
                  }                 
                }
            }
            else {
                System.out.println("Authentication failed. Exiting the program.");
            }
        
            // Close the scanner
            in.close();
       }
    }



