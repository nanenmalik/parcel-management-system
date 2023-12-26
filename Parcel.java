import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class Parcel {
    public String recipient;
    public int houseNumber;
    public LocalDate storedDate;
    public int parcelCost;
    public int countdownTime;
    public String[][] poBox = new String[30][5];

    public Parcel(String recipient, int houseNumber, String content) {
        this.recipient = recipient;
        this.houseNumber = houseNumber;
        this.storedDate = LocalDate.now();
        this.parcelCost = 0;
        this.countdownTime = 0;
    }

    public int getHouseNumber() { //getter
        return houseNumber;
    }

    public String getRecipient() { 
        return recipient;
    }

    public LocalDate getStoredDate() { 
        return storedDate;
    }

    //time,day left ,parcel status
    public int handleExtendTime(int days) { 
        storedDate = storedDate.plusDays(days);
        parcelCost += days * 3;

        if(days == 0){
            String time = "Extend";
            poBox[houseNumber][3] = time;
        }

            return parcelCost;
    }

    public int getCountdownTime() {
        if(countdownTime == 0){
            String dayLeft = "Expired";
            poBox[houseNumber][4] = dayLeft;
        }
        else if(countdownTime == 1){
            String dayLeft = "1 day left";
            poBox[houseNumber][4] = dayLeft;
        }
        else if(countdownTime == 2){
            String dayLeft = "2 day left";
            poBox[houseNumber][4] = dayLeft;

        } 
        return countdownTime;
    }

    public boolean isExpired() { 
        LocalDate currentDate = LocalDate.now();
        long daysDifference = ChronoUnit.DAYS.between(storedDate, currentDate);


        if (daysDifference > 2) {
            countdownTime = 0;
            String parcelStatus = "EXPIRED";
             poBox[houseNumber][5] = parcelStatus;
            return true;
        } else if (daysDifference == 2) {
            countdownTime = 1;
            String parcelStatus = "NOT EXPIRED";
             poBox[houseNumber][5] = parcelStatus;
            return false;
        } else {
            countdownTime = 2;
            String parcelStatus = "NOT EXPIRED";
             poBox[houseNumber][5] = parcelStatus;
            return false;
        }
    }

      
    public void handleReturn() { 
        storedDate = LocalDate.now();
    }

    public int getParcelCost() { 
        return parcelCost;
    }

    /*@Override
    public String toString() {
        String parcelInfo = "Parcel for " + recipientName + " at " + houseNumber + " with countdown time: " + getCountdownTime();
        if (isExpired()) {
        parcelInfo = "Expired " + parcelInfo;
        }
         return parcelInfo;
    }*/
}