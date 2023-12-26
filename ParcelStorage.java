//ParcelStorage.java

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
//import java.util.InputMismatchException;
//import java.util.ArrayList;
import java.util.Scanner;

public class ParcelStorage {

    public static int insertingData(String[] recipients, String[][] poBox, int houseNumbers) throws IOException {

    Scanner input = new Scanner(System.in);

        int unitSlot;
        int dayLeft;
        String time= "";
        String parcelStatus= "";
        char answer;
                
        
        System.out.println("\nINSERTING DATA\n--------------------");
        
        //incerement the count to insert data to the next index
        while (houseNumbers < recipients.length && recipients[houseNumbers] != null) {
        houseNumbers++;
        }
        
        System.out.print("Enter agent name: ");                 //Eg: Nadiah/ Syaza
        recipients[houseNumbers] = input.nextLine();
        
        do {
            System.out.println("Enter Unit Slot Number: ");     
            unitSlot = input.nextInt();
            poBox[houseNumbers][2] = Integer.toString(unitSlot);

            System.out.println("Enter (Extend/None): ");     
            time = input.nextLine();
            poBox[houseNumbers][3] = time;

            System.out.println("Enter Day Left : ");     
            dayLeft = input.nextInt();
            poBox[houseNumbers][4] = Integer.toString(dayLeft);

            System.out.println("Enter Day Left (Extend/None): ");     
            parcelStatus = input.nextLine();
            poBox[houseNumbers][5] = parcelStatus;

            System.out.println("Do you want to re-do? (Y/N): ");
            answer = input.next().charAt(0);

        }while(Character.toUpperCase(answer) == 'Y');

        input.close();

        System.out.println();
        System.out.println("Data inserted successfully.\n");
        
        return houseNumbers;
    }

    //Method to load data from file
    public static void loadDataFromFile(String[] recipients, String[][] poBox, int houseNumbers) throws IOException {
        File file = new File("data.txt");
        int count = houseNumbers;
    
        try (Scanner in = new Scanner(file)) {
            while (in.hasNextLine()) {
                String line = in.nextLine();
                String[] data = line.split(",");
    
                // Assuming poBox has 5 properties for each entry
                poBox[count][0] = data[0]; // data[][0] = Recipient Name
                poBox[count][1] = data[1]; // data[][1] = House Number
                poBox[count][2] = data[2]; // data[][2] = Content
                poBox[count][3] = data[3]; // data[][3] = Total Units
                poBox[count][4] = data[4]; // data[][4] = Parcel Status
    
                count++; // increment count to read the next index 
            }
        } catch (FileNotFoundException e) {
            System.out.println("Data file not found. Continue to create a new file.");
            System.out.println("File successfully created.");
        }
    }
        

    // Method to save data to file
    public static void savingDataToFile(String[] recipients, String[][] poBox, int houseNumbers) throws IOException {
        File file = new File("data.txt");
        PrintWriter en = new PrintWriter(new FileWriter(file));

        // Write data into the file named 'data.txt'
        for (int i = 0; i < poBox.length; i++) {
            // Check if any of the required arrays or elements are null or if houseNumbers[i] is zero
            

            // Write data to the file
            en.write(poBox[i][0] + "," + poBox[i][1] + "," + poBox[i][2] + "," + poBox[i][3] + "," + poBox[i][4]);
            en.println();
        }

        en.close();
    }

    //method to view poBox info
    public void viewPoBoxData(String[] recipients, String[][] poBox, int houseNumbers) {
        System.out.println("______________________________________________________________________________________");
        System.out.printf("\n%-20s\t%-10s\t%-20s\t%-10s\t%-20s\n", "Recipient Name", "House Number", "Content",
                "Total Units", "Parcel Status");
        System.out.println("______________________________________________________________________________________");

        for (String[] parcelData : poBox) {
            if (parcelData[0] != null) {
                System.out.printf("%-20s\t%-10s\t%-20s\t%-10s\t%-20s\n", parcelData[0], parcelData[1], parcelData[2],
                        parcelData[3], parcelData[4]);
            }
        }
        System.out.println();
    }
}