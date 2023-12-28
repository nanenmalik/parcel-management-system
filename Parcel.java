import java.time.LocalDate;

public class Parcel {

    // Represents a parcel with a username, collection code, stored date, expired date, and sender.
    private String username;
    private String code;
    private LocalDate storedDate;
    private LocalDate expiredDate;
    private String sender;

    
    // Creates a new parcel with the given username, code, and sender.
    public Parcel(String username, String code, String sender) {
        this.username = username;
        this.code = code;
        this.storedDate = LocalDate.now();
        this.expiredDate = storedDate.plusDays(2);
        this.sender = sender;
    }
    
    public Parcel(String username, String code, LocalDate storedDate, LocalDate expiredDate, String sender) {
        this.username = username;

        this.code = code;
        this.storedDate = storedDate;
        this.expiredDate = expiredDate;
        this.sender = sender;
    }

    public String getusername() { // Get the username.
        return username;
    }

    public void setusername(String username) 
    
    { // Set the house username.
        this.username = username;
    }

    public String getCode() { // Get the code.
        return code;
    }

    public void setCode(String code) { // Set the code.
        this.code = code;
    }

    public LocalDate getStoredDate() { // Get the stored date.
        return storedDate;
    }

    public void setStoredDate(LocalDate storedDate) { // Set the stored date.
        this.storedDate = storedDate;
    }

    public LocalDate getExpiredDate() { // Get the expired date.
        return expiredDate;
    }

    public void setExpiredDate(LocalDate expiredDate) { // Set the expired date.
        this.expiredDate = expiredDate;
    }

    public String getSender() { // Get the sender.
        return sender;
    }

    public void setSender(String sender) { // Set the sender.
        this.sender = sender;
    }
}
