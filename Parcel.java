//Parcel.java
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class Parcel {
    private String recipientName;
    private int houseNumber;
    private String content;
    private LocalDate storedDate;
    private double parcelCost;

    public Parcel(String recipientName, int houseNumber, String content) {
        this.recipientName = recipientName;
        this.houseNumber = houseNumber;
        this.content = content;
        this.storedDate = LocalDate.now();
        this.parcelCost = 0;
    }

    public int getHouseNumber() {
        return houseNumber;
    }

    public String getRecipientName() {
        return recipientName;
    }

    public String getContent() {
        return content;
    }

    public boolean isExpired() {
        LocalDate currentDate = LocalDate.now();
        long daysDifference = ChronoUnit.DAYS.between(storedDate, currentDate);
        return daysDifference > 2;
    }
    
    public void handleExtendTime(int days) {
        storedDate = storedDate.plusDays(days);
        parcelCost += days * 3;
    }
    
    public void handleReturn() {
        storedDate = LocalDate.now();
    }
       
    public double getParcelCost() {
        return parcelCost;
    }
       

    @Override
    public String toString() {
        return "Parcel for " + recipientName + " at " + houseNumber + " containing " + content;
    }
   
}