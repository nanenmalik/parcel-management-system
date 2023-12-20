public class Parcel {
    private String recipientName;
    private int houseNumber;
    private String content;

    public Parcel(String recipientName, int houseNumber, String content) {
        this.recipientName = recipientName;
        this.houseNumber = houseNumber;
        this.content = content;
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

    
}