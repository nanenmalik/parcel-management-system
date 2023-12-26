//ParcelStorage.java

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class ParcelStorage {

    String [][] poBox = {
        {"Recipient1", "5", "No Parcel"}, 
        {"Recipient2", "5", "No Parcel"},
        {"Recipient3", "5", "No Parcel"},
        {"Recipient4", "5", "No Parcel"},
        {"Recipient5", "5", "No Parcel"},
        {"Recipient6", "5", "No Parcel"},
        {"Recipient7", "5", "No Parcel"},
        {"Recipient8", "5", "No Parcel"},
        {"Recipient9", "5", "No Parcel"},
        {"Recipient10", "5", "No Parcel"},
        {"Recipient11", "5", "No Parcel"},
        {"Recipient12", "5", "No Parcel"},
        {"Recipient13", "5", "No Parcel"},
        {"Recipient14", "5", "No Parcel"},
        {"Recipient15", "5", "No Parcel"},
        {"Recipient16", "5", "No Parcel"},
        {"Recipient17", "5", "No Parcel"},
        {"Recipient18", "5", "No Parcel"},
        {"Recipient19", "5", "No Parcel"},
        {"Recipient20", "5", "No Parcel"},
        {"Recipient21", "5", "No Parcel"},
        {"Recipient22", "5", "No Parcel"},
        {"Recipient23", "5", "No Parcel"},
        {"Recipient24", "5", "No Parcel"},
        {"Recipient25", "5", "No Parcel"},
        {"Recipient26", "5", "No Parcel"},
        {"Recipient27", "5", "No Parcel"},
        {"Recipient28", "5", "No Parcel"},
        {"Recipient29", "5", "No Parcel"},
        {"Recipient30", "5", "No Parcel"}
        
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
    

