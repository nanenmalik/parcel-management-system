import java.util.ArrayList;
import java.util.List;

public class ParcelStorage {

    // Represents a parcel storage with a username and a list of parcels.
    private String username;
    private List<Parcel> parcelList;

    public ParcelStorage() {
        this.username = null;
        this.parcelList = new ArrayList<>(); // Initialize the list.
    }

    public ParcelStorage(String username, List<Parcel> parcelList) {  // Creates a new parcel storage with the given username and list.
        this.username = username; 
        this.parcelList = parcelList;
    }

    public String getusername() { // Get the username.
        return username;
    }

    public void setusername(String username) { // Set the username.
        this.username = username;
    }

    public List<Parcel> getParcelList() { // Get the list.
        return parcelList;
    }

    public void setParcelList(List<Parcel> parcelList) { // Set the list.
        this.parcelList = parcelList;
    }
}
