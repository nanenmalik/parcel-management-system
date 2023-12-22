import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class ParcelManagementSystem {

    private static final int NUMBER_OF_SLOTS = 30;
    private ArrayList<Parcel> slots;

    public ParcelManagementSystem() {
        slots = new ArrayList<>(NUMBER_OF_SLOTS);
        for (int i = 0; i < NUMBER_OF_SLOTS; i++) {
            slots.add(null);
        }
    }

    public void storeParcel(Parcel parcel) {
        int slotNumber = findAvailableSlot();
        if (slotNumber != -1) {
            slots.set(slotNumber, parcel);
            System.out.println("Parcel stored in slot number " + (slotNumber + 1));
        } else {
            System.out.println("No available slots. Cannot store parcel.");
        }
    }

    private int findAvailableSlot() {
        for (int i = 0; i < NUMBER_OF_SLOTS; i++) {
            if (slots.get(i) == null) {
                return i;
            }
        }
        return -1;
    }

    public Parcel retrieveParcel(int slotNumber) {
        if (slotNumber >= 1 && slotNumber <= NUMBER_OF_SLOTS) {
            return slots.get(slotNumber - 1);
        } else {
            System.out.println("Slot number " + slotNumber + " does not exist. Please choose a slot number between 1 and " + NUMBER_OF_SLOTS + ".");
            return null;
        }
    }
    ///bla bla bla push test

    public ArrayList<Parcel> checkAndReturnUnCollectedParcels() {
        ArrayList<Parcel> uncollectedParcels = new ArrayList<>();
        for (int i = 0; i < NUMBER_OF_SLOTS; i++) {
            Parcel parcel = slots.get(i);
            if (parcel != null && parcel.getReceiver().equals(parcel.getSender())) {
                uncollectedParcels.add(parcel);
                slots.set(i, null);
            }
        }
        return uncollectedParcels;
    }

    public void loadUserInformationFromFile(String fileName) {
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] userInfo = line.split(",");
                if (userInfo.length == 2) {
                    String sender = userInfo[0].trim();
                    String receiver = userInfo[1].trim();
                    Parcel parcel = new Parcel(sender, receiver);
                    storeParcel(parcel);
                }
            }
        } catch (IOException e) {
            System.out.println("Error loading user information from file: " + e.getMessage());
        }
    }

    public void saveUserInformationToFile(String fileName) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
            for (Parcel parcel : slots) {
                if (parcel != null) {
                    writer.write(parcel.getSender() + "," + parcel.getReceiver());
                    writer.newLine();
                }
            }
        } catch (IOException e) {
            System.out.println("Error saving user information to file: " + e.getMessage());
        }
    }
}


class Parcel {
    private String sender;
    private String receiver;

    public Parcel(String sender, String receiver) {
        this.sender = sender;
        this.receiver = receiver;
    }

    public Object getSender() {
        return null;
    }

    public Object getReceiver() {
        return null;
    }

    // Add getters and setters as needed
}