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
    
    // Method to insert data
    public static int insertingData(String[] recipient, String[] houseNumber, String[][] poBox, int count) {
    
        Scanner in = new Scanner(System.in);
        System.out.println("\nINSERTING DATA\n--------------------");
        
        //incerement the count to insert data to the next index
        while (recipient[count]!=null){
             count++;  
        }
        
        System.out.print("Enter recipient name: ");                 //Eg: Nadiah/ Syaza
        recipient[count] = in.nextLine();
    
        System.out.print("Enter house number: ");              //Eg: Mahmud/ Mawar/ Naqib 
        houseNumber[count] = in.nextLine();
    
        System.out.print("Enter your username: ");              //Eg: password authentication
        poBox[count][0] = in.nextLine();
        
    
        System.out.print("Enter unit slot parcel: ");              //Eg: Apartment, Single storey terrace, Bungalow
        poBox[count][1] = in.nextLine();
    
        System.out.print("Enter time parcel need to be taken: ");     //Eg: 1, 2, 3
        poBox[count][2] = in.nextLine();
    
        System.out.print("Enter total parcel: ");             //Eg: Gombak,Kl,Setapak
        poBox[count][3] = in.nextLine();
    
        System.out.print("Parcel (EXTENDED/NONE): ");                //Eg: 500000
        poBox[count][4] = in.nextLine();
        
        System.out.println("Data inserted successfully.\n");
        
        return count;
    }
  
// Method to view data
    public static void viewPropertyData(String[] recipient, String[] houseNumber, String[][] poBox) {

        System.out.println();
        System.out.println("__________________________________________________________________________________________________________________________________________");
        System.out.printf("\n%-10s%-15s\t%-15s\t%-15s\t%-15s\t%-15s\t%-15s\t%-15s\t%-15s\n", "Index", "Recipient","House Number", "Username","Slot Avail ","Units Sold","Time Pickup","Total Parcel","ParcelStatus");
        System.out.println("__________________________________________________________________________________________________________________________________________");

        for (int i = 0; i < recipient.length; i++) {
            if (recipient[i] == null  && houseNumber[i] == null &&  poBox[i][0] == null) {
                continue;
            }
        
            System.out.printf("%-10d%-15s\t%-15s\t%-15s\t%-15s\t%-15s\t%-15s\t%-15s\t%-15s\n", i, recipient[i], houseNumber[i], poBox[i][0], poBox[i][1], poBox[i][2], poBox[i][3], poBox[i][4], poBox[i][5]);
        } //print the data from index 0 until last index

    System.out.println();
    }
    
// Method to update data
    public static void updatePropertyData(String[] recipient, String[] houseNumber, String[][] poBox) {
    
        Scanner in = new Scanner(System.in);
        
        viewPropertyData( recipient, houseNumber, poBox);
    
        System.out.println("\nSORTING EXISTING DATA IN SYSTEM-------------------");
        System.out.println("\nUPDATE EXISTING DATA IN SYSTEM\n--------------------");
        
        System.out.print("Enter the index of the property you want to update: "); //index that user want to update
        int index = in.nextInt();
        in.nextLine();
 
        System.out.print("Enter the updated recipient name: "); //updated customer name
        recipient[index] = in.nextLine();

        System.out.print("Enter the updated house number: ");  //updated total units
        houseNumber[index] = in.nextLine();
        

        System.out.print("Enter the  username: ");  //updated price
        poBox[index][4] = in.nextLine();

            // Want to update or not the features in data
            System.out.print("Do you want to update features of the properties? Y/N: ");  // question to update properties or not
            char option = in.nextLine().charAt(0);
            
            while(true){
                if (option == 'Y'){
                    System.out.print("Enter the updated features of the property: ");  //updated status
                    poBox[index][5] = in.nextLine();
                    break;
                }
                else if (option == 'N'){
                    break;
                }
            }
        
        System.out.print("Enter the updated status of the properties: ");  //updated status
        poBox[index][6] = in.nextLine();

        

        System.out.println("Data successfully updated.\n");  // display message that data successfully updated
        
        }
    

        
  //Method to load data from file
    public static void loadDataFromFile(String[] agents, String[] customers, String[][] properties) throws IOException {
        
        File file = new File("data.txt");
     
        int count = 0;
        
        try //Using exception to create a new file
            (Scanner in = new Scanner (file)){
        
        while (in.hasNextLine()) {
            String line = in.nextLine();
            String[] data = line.split(",");
            agents[count] = data[0]; //read agent name
            customers[count] = data[1];  //read customer name
            properties[count][0] = data[2];  //read the list of properties data,   //data[][0] = name of the property
            properties[count][1] = data[3];                                        //data[][1] = type of the property
            properties[count][2] = data[4];                                        //data[][2] = total units sold of the property
            properties[count][3] = data[5];                                        //data[][3] = location of the property
            properties[count][4] = data[6];                                        //data[][4] = price of the property
            properties[count][5] = data[7];                                        //data[][5] = features of the property
            properties[count][6] = data[8];                                        //data[][6] = status of the property
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
    public static void savingDataToFile(String[] recipient, String[] houseNumber, String[][] poBox) throws IOException {
        
        File file = new File("data.txt");
        PrintWriter en = new PrintWriter(new FileWriter(file));
        
        //write data into file named 'data.txt'
        for (int i = 0; i < recipient.length; i++) {
            if (recipient[i] == null  && houseNumber[i] == null && poBox[i][0] == null) {
            continue;
            }
            
            en.write(recipient[i] + "," + houseNumber[i] + "," + poBox[i][0] + "," + poBox[i][1] + "," + poBox[i][2] + "," + poBox[i][3] + "," + poBox[i][4] + "," + poBox[i][5] + "," + poBox[i][6]);
            en.println();
        }
        
        en.close();
    }
    
    public static String userAuthentication(String[] recipient, String[] houseNumber, String[][] poBox) throws IOException {
        Scanner in = new Scanner(System.in);
    
        try {
            System.out.println("Enter username:");
            String username = in.nextLine();
    
            System.out.println("Enter password:");
            String password = in.nextLine();
    
            String correctUsername = "user123";
            String correctPassword = "pass456";
    
            if (username.equals(correctUsername) && password.equals(correctPassword)) {
                System.out.println("Authentication successful. Welcome, " + username + "!");
                return username;
            } else {
                throw new AuthenticationException("Authentication failed. Invalid username or password.");
            }
        } catch (AuthenticationException e) {
            System.err.println(e.getMessage());
        } finally {
            // Close the scanner in the finally block to ensure it gets closed
            if (in != null) {
                in.close();
            }
        }
        return null;
    }

    public static int findUserRowIndex(String[][] poBox, String username) {
        return 0;
    }