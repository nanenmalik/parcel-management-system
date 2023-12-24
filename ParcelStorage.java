//ParcelStorage.java

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
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
}
