import java.util.ArrayList;

public class ParcelManagementSystem {

    private static final int NUMBER_OF_SLOTS = 30;
    private ArrayList<Parcel> slots;

    public ParcelManagementSystem() {
        slots = new ArrayList<>(NUMBER_OF_SLOTS);
        for (int i = 0; i < NUMBER_OF_SLOTS; i++) {
            slots.add(null);
        }
    }

    public void storeParcel(int slotNumber, Parcel parcel) {
        if (slotNumber >= 1 && slotNumber <= NUMBER_OF_SLOTS) {
            slots.set(slotNumber - 1, parcel);
        } else {
            System.out.println("Slot number " + slotNumber + " does not exist. Please choose a slot number between 1 and " + NUMBER_OF_SLOTS + ".");
        }
    }

    public Parcel retrieveParcel(int slotNumber) {
        if (slotNumber >= 1 && slotNumber <= NUMBER_OF_SLOTS) {
            return slots.get(slotNumber - 1);
        } else {
            System.out.println("Slot number " + slotNumber + " does not exist. Please choose a slot number between 1 and " + NUMBER_OF_SLOTS + ".");
            return null;
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

    // Add getters and setters as needed
}