//ParcelStorage.java

import java.util.ArrayList;

public class ParcelStorage {
   
    private static final int MAX_SLOTS = 30;
    private static final int MAX_PARCELS_PER_SLOT = 5;
    private static final int STORAGE_DURATION_DAYS = 2;

    private ArrayList<Parcel> parcels;

    public ParcelStorage() {
        slots = new ArrayList[MAX_SLOTS];
        for (int i = 0; i < MAX_SLOTS; i++) {
            slots[i] = new ArrayList<>();
        }
    }

    public void storeParcel(Parcel parcel) {
        int slotIndex = parcel.getHouseNumber() % MAX_SLOTS;
        ArrayList<Parcel> currentSlot = slots[slotIndex];

        if (currentSlot.size() < MAX_PARCELS_PER_SLOT) {
            currentSlot.add(parcel);
            System.out.println("Parcel stored successfully.");
        } else {
            System.out.println("Storage at capacity for house number " + parcel.getHouseNumber());
        }
    }

}
