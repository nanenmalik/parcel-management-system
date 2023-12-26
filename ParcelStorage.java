//ParcelStorage.java

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class ParcelStorage {

    Parcel[][] poBox = new Parcel[][] {
        {new Parcel("Recipient1", 001, "Content1"), 
         new Parcel("Recipient2", 002, "Content2"),
         new Parcel("Recipient3", 003, "Content3"), 
         new Parcel("Recipient4", 004, "Content4"),
         new Parcel("Recipient5", 005, "Content5"), 
         new Parcel("Recipient6", 006, "Content6"),
         new Parcel("Recipient2", 007, "Content2"),
         new Parcel("Recipient3", 008, "Content3"), 
         new Parcel("Recipient4", 009, "Content4"),
         new Parcel("Recipient5", 010, "Content5"), 

         new Parcel("Recipient6", 011, "Content6"),
         new Parcel("Recipient2", 012, "Content2"),
         new Parcel("Recipient3", 013, "Content3"), 
         new Parcel("Recipient4", 014, "Content4"),
         new Parcel("Recipient5", 015, "Content5"), 
         new Parcel("Recipient6", 016, "Content6"),
         new Parcel("Recipient2", 017, "Content2"),
         new Parcel("Recipient3", 018, "Content3"), 
         new Parcel("Recipient4", 019, "Content4"),

         new Parcel("Recipient5", 020, "Content5"), 
         new Parcel("Recipient6", 021, "Content6"),
         new Parcel("Recipient3", 023, "Content3"), 
         new Parcel("Recipient4", 024, "Content4"),
         new Parcel("Recipient5", 025, "Content5"), 
         new Parcel("Recipient6", 026, "Content6"),
         new Parcel("Recipient2", 027, "Content2"),
         new Parcel("Recipient3", 028, "Content3"), 
         new Parcel("Recipient4", 029, "Content4"),

         new Parcel("Recipient5", 030, "Content5"), 
        
    };

    //Method to load data from file
    public static void loadDataFromFile(String[][] poBox) throws IOException {
        File file = new File("data.txt");
        int count = 0;
        
        try (Scanner in = new Scanner(file)) {
            while (in.hasNextLine()) {
                String line = in.nextLine();
                String[] data = line.split(",");
                //recipientNames[count] = data[0]; // read recipient name
                //houseNumber[count] = Integer.parseInt(data[1]); // read house number as integer
        
                // Assuming poBox has 3 properties for each entry
                poBox[count][0] = data[2]; // data[][0] = recipientNames
                poBox[count][1] = data[3]; // data[][1] = houseNumber
                poBox[count][2] = data[4]; // data[][2] = total units parcelbox that have been occupied
        
                count++; // increment count to read the next index 
            }
        } catch (FileNotFoundException e) {
            System.out.println("Data file not found. Continue to create a new file.");
            System.out.println("File successfully created.");
        }
    }
        

    // Method to save data to file
public static void savingDataToFile(String[][] poBox) throws IOException {
    File file = new File("data.txt");
    PrintWriter en = new PrintWriter(new FileWriter(file));

    // Write data into the file named 'data.txt'
    for (int i = 0; i < houseNumbers.length; i++) {
        // Check if any of the required arrays or elements are null or if houseNumbers[i] is zero
        if (recipientNames[i] == null || poBox[i] == null || poBox[i][0] == null || houseNumbers[i] == 0) {
            continue;
        }

        // Write data to the file
        en.write(houseNumbers[i] + "," + recipientNames[i] + "," + poBox[i][0] + "," + poBox[i][1] + "," + poBox[i][2]);
        en.println();
    }

    en.close();
}

// Method to view data
public static void viewPoBoxData(Parcel[][] poBoxes) {
    System.out.println("______________________________________________________________________________________");
    System.out.printf("\n%-20s\t%-10s\t%-20s\n", "Recipient Name", "House Number", "Content");
    System.out.println("______________________________________________________________________________________");

    for (Parcel[] row : poBoxes) {
        if (row[0] != null) {
            System.out.printf("%-20s\t%-10d\t%-20s\n", row[0].getRecipientName(), row[0].getHouseNumber(), row[0].getContent());
        }
    }
    System.out.println();
}
}
    

