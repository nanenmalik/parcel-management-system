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
        

        // load data from file if it already exists
        ParcelStorage.loadDataFromFile( poBoxes[][]);         //call from PropertySystem file
        System.out.println("Welcome to Property Management\n");

        do{
            // Taking user input for creating a Parcel object
            // System.out.println("Enter recipient name:");
            // String inputRecipientName = scanner.nextLine();

            System.out.println("Enter house number:");
            houseNumbers = input.nextInt();
            
            if( houseNumbers>=1 || houseNumbers<=30 ){
                houseNumbers = houseNumbers - 1 ;
                System.out.println("You have " + poBoxes[houseNumbers][4] + " parcel in your mail.");

                if( poBoxes[houseNumbers][5] == "EXPIRED"){
                    System.out.println("Your Parcel are EXPIRED.");
                    System.out.println("Please contact your sender again to retrieve your parcel.");
                }

                else if( poBoxes[houseNumbers][5] == "NOTEXPIRED"){
                    System.out.println("Your parcel are" ); // + countdown day

                    do{
                        int day = 0;
                        int timeExtended = 0;

                        System.out.println("Do you wish to extend time of your parcel package?");
                        System.out.println("Your time is " + poBoxes[houseNumbers][6].getParcelCost());

                        day = input.nextInt();

                        timeExtended = Parcel.handleExtendTime( days );

                        

                    }while()
                }

                else if( poBoxes[houseNumbers][5] == "NOPARCEL"){
                    System.out.println("There are no parcel in your mail." ); // + countdown day
                }

                
            }

        }while
    }
}
