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
        {"Recipient1", "5", "None","0", "No Parcel"}, 
        {"Recipient2", "5", "None","0", "No Parcel"},
        {"Recipient3", "5", "None","0", "No Parcel"},
        {"Recipient4", "5", "None","0", "No Parcel"},
        {"Recipient5", "5", "None","0", "No Parcel"},
        {"Recipient6", "5", "None","0", "No Parcel"},
        {"Recipient7", "5", "None","0", "No Parcel"},
        {"Recipient8", "5", "None","0", "No Parcel"},
        {"Recipient9", "5", "None","0", "No Parcel"},
        {"Recipient10", "5", "None","0", "No Parcel"},
        {"Recipient11", "5", "None","0", "No Parcel"},
        {"Recipient12", "5", "None","0", "No Parcel"},
        {"Recipient13", "5", "None","0", "No Parcel"},
        {"Recipient14", "5", "None","0", "No Parcel"},
        {"Recipient15", "5", "None","0", "No Parcel"},
        {"Recipient16", "5", "None","0", "No Parcel"},
        {"Recipient17", "5", "None","0", "No Parcel"},
        {"Recipient18", "5", "None","0", "No Parcel"},
        {"Recipient19", "5", "None","0", "No Parcel"},
        {"Recipient20", "5", "None","0", "No Parcel"},
        {"Recipient21", "5", "None","0", "No Parcel"},
        {"Recipient22", "5", "None","0", "No Parcel"},
        {"Recipient23", "5", "None","0", "No Parcel"},
        {"Recipient24", "5", "None","0", "No Parcel"},
        {"Recipient25", "5", "None","0", "No Parcel"},
        {"Recipient26", "5", "None","0", "No Parcel"},
        {"Recipient27", "5", "None","0", "No Parcel"},
        {"Recipient28", "5", "None","0", "No Parcel"},
        {"Recipient29", "5", "None","0", "No Parcel"},
        {"Recipient30", "5", "None","0", "No Parcel"}
        
    };

    //Method to load data from file
    public static void loadDataFromFile(String[][] poBox) throws IOException {
        File file = new File("data.txt");
        int count = 0;
    
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
    public static void savingDataToFile(String[][] poBox) throws IOException {
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
    public void viewPoBoxData() {
        System.out.println("______________________________________________________________________________________");
        System.out.printf("\n%-20s\t%-10s\t%-20s\t%-10s\t%-20s\n", "Recipient Name", "House Number", "Content", "Total Units", "Parcel Status");
        System.out.println("______________________________________________________________________________________");

        for (String[] parcelData : poBox) {
            if (parcelData[0] != null) {
                System.out.printf("%-20s\t%-10s\t%-20s\t%-10s\t%-20s\n",
                        parcelData[0], parcelData[1], parcelData[2], parcelData[3], parcelData[4]);
            }
        }
        System.out.println();
    }
}