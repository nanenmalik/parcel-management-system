
import java.io.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {


    private final static int SLOT = 30;
    private final static int SIZE = 5;
    private static List<ParcelStorage> parcelStorage = new ArrayList<>(SLOT);
    private final static DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

    private static Scanner scanner = new Scanner(System.in);
    
    // Presents a menu to the user and calls specific methods based on the user's choice.
    public static void main(String[] args) throws IOException {
       
        int select = 0;

        do {
            printWelcomeMessage();
            select = Integer.parseInt(scanner.nextLine());
            if (select == 1) {
                menu1();
            } else if (select == 2) {
                menu2();
            } else if (select == 3) {
                System.out.println("Bye bye");
            }

        } while (select != 3);

    }
    // Handles the collection of parcels. Reads user input for username and collection code, searches for the parcel, and removes it if found.
    public static void menu1() throws IOException {
        readFile();
        System.out.println("Enter your username: ");
        String username = scanner.nextLine();

        System.out.println("Enter your collection code: ");
        String code = scanner.nextLine();


        for (ParcelStorage ps : parcelStorage) {
            for (int i = 0 ; i < ps.getParcelList().size() ; i ++) {

                Parcel parcel = ps.getParcelList().get(i);
                if (parcel != null) {
                    if (username.equals(parcel.getusername()) && code.equals(parcel.getCode())) {
                        System.out.println("Parcel found !!! ");
                        System.out.println("Please collect your parcel ");

                        ps.getParcelList().remove(i);
                        writeFile();
                        return;
                    }
                }

            }
        }
        System.out.println("Invalid code !");

    }
    // Handles the drop off of parcels. Reads user input for username, collection code, and sender details, and stores the parcel if there is space.
    public static void menu2() throws IOException {

        readFile();

        System.out.println("Enter the receiver username: ");
        String username = scanner.nextLine();
        System.out.println("Enter the receiver collection code: ");
        String code = scanner.nextLine();
        System.out.println("Enter the sender detail: ");
        String sender = scanner.nextLine();


        for (ParcelStorage ps : parcelStorage) {
            if (ps.getusername() == null) {
                ps.setusername(username);
                Parcel parcel = new Parcel(username, code, sender);
                ps.getParcelList().add(parcel);
                System.out.println("Parcel stored ");
                writeFile();
                return;
            } else if (ps.getusername().equals(username)) {
                if (ps.getParcelList().size() < SIZE) {
                    Parcel parcel = new Parcel(username, code, sender);
                    ps.getParcelList().add(parcel);
                    System.out.println("Parcel stored ");
                    writeFile();
                    return;

                }
                break;
            }
        }

        System.out.println("All slot are full! ");


    }
    // Prints the welcome message and menu options.
    public static void printWelcomeMessage() {
        System.out.println("Welcome to the Lazada Parcel service center ! ");
        System.out.println("1. Collect ");
        System.out.println("2. Drop Off");
        System.out.println("3. Exit");
    }
    // Reads the contents of the file and stores them in the parcel storage array.
    public static void readFile() throws IOException {
        File file = new File("parcel2.txt");
        FileReader fr = new FileReader(file);
        BufferedReader br = new BufferedReader(fr);
        String line;
        resetArray();

        // read line by line
        while ((line = br.readLine()) != null) {
            //seperate by the delimeter
            StringTokenizer st = new StringTokenizer(line, "|");
            String username = st.nextToken();

            String code = st.nextToken();
            LocalDate storedDate = LocalDate.parse(st.nextToken(), formatter);
            LocalDate expiredDate = LocalDate.parse(st.nextToken(), formatter);
            String sender = st.nextToken();

            if (expiredDate.isBefore(LocalDate.now())) {
                System.out.println("Parcel code " + code + " is expired, returning to original sender " + sender);
                continue;
            }

            Parcel p = new Parcel(username, code, storedDate, expiredDate, sender);

            for (ParcelStorage ps : parcelStorage) {
                if (ps.getusername() == null || !ps.getusername().equals(username)) {
                    ps.setusername(username);
                }
                ps.getParcelList().add(p);
                break;
            }


        }
        fr.close();
    }
    // Writes the contents of the parcel storage to the file.
    public static void writeFile() throws IOException {
        File file = new File("parcel2.txt");
        FileWriter fr = new FileWriter(file);

        for (ParcelStorage ps : parcelStorage) {

            for (Parcel parcel : ps.getParcelList()) {
                fr.write(parcel.getusername() + "|" + parcel.getCode() + "|" +
                        parcel.getStoredDate() + "|" + parcel.getExpiredDate() + "|" + parcel.getSender() + "\n");

            }
        }
        fr.close();
    }

    // Resets the parcel storage array.
    public static void resetArray(){
        parcelStorage = new ArrayList<>(SLOT);
        for (int i = 0; i < SLOT; i++) {
            parcelStorage.add(new ParcelStorage());
        }
    }
}
