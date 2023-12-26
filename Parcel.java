import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class Parcel {
    private String recipientName;
    private int houseNumber;
    private LocalDate storedDate;
    private double parcelCost;
    private int countdownTime;

    public Parcel(String recipientName, int houseNumber, String content) {
        this.recipientName = recipientName;
        this.houseNumber = houseNumber;
        this.storedDate = LocalDate.now();
        this.parcelCost = 0;
        this.countdownTime = 0;
    }

    public int getHouseNumber() { //getter
        return houseNumber;
    }

    public String getRecipientName() { 
        return recipientName;
    }

    public LocalDate getStoredDate() { 
        return storedDate;
    }

    public boolean isExpired() { 
        LocalDate currentDate = LocalDate.now();
        long daysDifference = ChronoUnit.DAYS.between(storedDate, currentDate);

        if (daysDifference > 2) {
            countdownTime = 0;
            return true;
        } else if (daysDifference == 2) {
            countdownTime = 1;
            return false;
        } else {
            countdownTime = 2;
            return false;
        }
    }

    public int getCountdownTime() { 
        return countdownTime;
    }

    public double handleExtendTime(int days) { 
        storedDate = storedDate.plusDays(days);
        parcelCost += days * 3;
        return parcelCost;
    }

    public void handleReturn() { 
        storedDate = LocalDate.now();
    }

    public double getParcelCost() { 
        return parcelCost;
    }

    @Override
    public String toString() {
        if (isExpired()) {
            return "Expired Parcel for " + recipientName + " at " + houseNumber + " with countdown time: " + getCountdownTime();
        } else {
            return "Parcel for " + recipientName + " at " + houseNumber + " with countdown time: " + getCountdownTime();
        }
    }
}