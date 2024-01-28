package udacity.project1.model;

public class Room implements IRoom {

    private final String roomNumber;
    private final Double price;
    private final RoomType roomType;

    public Room(String roomNumber, Double price, RoomType roomType) {
        this.roomNumber = roomNumber;
        this.price = price;
        this.roomType = roomType;
    }

    @Override
    public String getRoomNumber() {
        return null;
    }

    @Override
    public Double getRoomPrice() {
        return null;
    }

    @Override
    public RoomType getRoomType() {
        return null;
    }

    @Override
    public Boolean isFree() {
        return null;
    }

    @Override
    public String toString() {
        return "Room number : " + roomNumber + " .\nPrice : " + price + " .\nroomType : " + roomType;
    }
}
