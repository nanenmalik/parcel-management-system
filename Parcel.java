//Parcel.java
import java.util.Date;

public class Parcel {

   private int houseNumber;
   private String itemName;
   private Date storageDate;

   public Parcel(int houseNumber, String itemName) {
       this.houseNumber = houseNumber;
       this.itemName = itemName;
       this.storageDate = new Date();
   }

   public int getHouseNumber() {
       return houseNumber;
   }

   public String getItemName() {
       return itemName;
   }

   public Date getStorageDate() {
       return storageDate;
   } 
   
}