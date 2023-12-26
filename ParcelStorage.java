//ParcelStorage.java

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
//import java.util.ArrayList;
import java.util.Scanner;

public class ParcelStorage {
   
    //private static final int MAX_SLOTS = 30;


    //private static final int

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
public static void savingDataToFile(String[] recipientNames, String[][] poBox, int[] houseNumbers) throws IOException {
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

    
}
