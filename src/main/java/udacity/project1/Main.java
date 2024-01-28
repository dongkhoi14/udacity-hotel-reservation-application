package udacity.project1;

import udacity.project1.model.Room;
import udacity.project1.model.RoomType;

public class Main {
    public static void main(String[] args) {
        Room room = new Room("ACC", 1.2, RoomType.DOUBLE);
        System.out.println(room.toString());
    }
}