package udacity.project1.model;

public class Room implements IRoom {

    private final String roomNumber;
    private final Double price;
    private final RoomType roomType;
    private boolean available = true;
    public Room(String roomNumber, Double price, RoomType roomType) {
        this.roomNumber = roomNumber;
        this.price = price;
        this.roomType = roomType;

    }

    @Override
    public String getRoomNumber() {
        return this.roomNumber;
    }

    @Override
    public Double getRoomPrice() {
        return this.price;
    }

    @Override
    public RoomType getRoomType() {
        return this.roomType;
    }
    public void reserveThisRoom(){
        this.available = false;
    }
    @Override
    public Boolean isFree() {
        return this.available;
    }

    @Override
    public String toString() {
        return "\nRoom number : " + roomNumber + " , Price : " + price + " , roomType : " + roomType  + "\n Available: " +  isFree().toString();
    }
}
