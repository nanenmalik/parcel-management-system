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
    public static void loadDataFromFile(String[] recipientNames, String[][] poBox, String[] houseNumber) throws IOException {
        
        File file = new File("data.txt");
     
        int count = 0;
        
        try //Using exception to create a new file
            (Scanner in = new Scanner (file)){
        
        while (in.hasNextLine()) {
            String line = in.nextLine();
            String[] data = line.split(",");
            recipientNames[count] = data[0]; //read recipient name
            houseNumber[count] = data[1];    //read house number
            poBox[count][0] = data[2];  //read the list of properties data,   //data[][0] = recipientNames
            poBox[count][1] = data[3];                                        //data[][1] = houseNumber
            poBox[count][2] = data[4];                                        //data[][2] = total units parcelbox that have been occupied
            
            count++; //increment count to read the next index 
        }
        
        
        in.close();
        }
        
        catch(FileNotFoundException e){
            System.out.println("Data file you search is not found. Continue to create a new file.");
            System.out.println("File Succesfully created.");
        }
    }

    // Method to save data to file
    public static void savingDataToFile(String[] recipientNames, String[][] poBox, String[] houseNumbers) throws IOException {

        File file = new File("data.txt");
        PrintWriter en = new PrintWriter(new FileWriter(file));
    
        // Write data into the file named 'data.txt'
        for (int i = 0; i < houseNumbers.length; i++) {
            // Check if any of the required arrays or elements are null
            if (recipientNames[i] == null || poBox[i] == null || poBox[i][0] == null || houseNumbers[i] == null) {
                continue;
            }
    
            // Write data to the file
            en.write(houseNumbers[i] + "," + recipientNames[i] + "," + poBox[i][0] + "," + poBox[i][1] + "," + poBox[i][2]);
            en.println();
        }
    
        en.close();
    }
    
}
