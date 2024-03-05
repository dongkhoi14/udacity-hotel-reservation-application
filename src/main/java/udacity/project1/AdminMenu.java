package udacity.project1;

import udacity.project1.MainMenu;
import udacity.project1.api.AdminResource;
import udacity.project1.model.Customer;
import udacity.project1.model.IRoom;
import udacity.project1.model.Room;
import udacity.project1.model.RoomType;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AdminMenu {
    private static final AdminResource adminResource = new AdminResource();
    public static void adminMennu(){
        Scanner scanner = new Scanner(System.in);
        displayAdminMenu();
        var selectedMenu = "";
        do {
            selectedMenu = scanner.nextLine();
            switch (selectedMenu){
                case "1":
                    seeAllCustomer();
                    break;

                case "2":
                    seeAllRooms();
                    break;
                case "3":
                    seeAllReservations();
                    break;

                case "4":
                    addARoom();
                    break;
                case "5":
                    MainMenu.MainMenu();
                    break;

                case "6":
                    addMockData();
                    break;

            }
        }while(selectedMenu.equals("5"));
    }
    private static void displayAdminMenu() {
        System.out.println("\nWelcome to the Hotel Reservation Application Admin Menu\n\n" +
                "-------------------------------------------------------\n" +
                "1. See all customer\n" +
                "2. See rooms\n" +
                "3. See all Reservations\n" +
                "4. Add a room\n" +
                "5. Back to Main Menu\n" +
                "6. Add Data\n" +
                "-------------------------------------------------------\n" +
                "Please select a number for the menu option");
    }
    public static void seeAllCustomer(){
        var customers = adminResource.getAllCustomers();

        for (Customer customer: customers){
            System.out.println(customer.toString());
        }
        adminMennu();


    }
    public static void seeAllReservations(){
        adminResource.displayAllReservations();
        adminMennu();

    }
    public static void seeAllRooms(){
        var a= adminResource.getAllRooms();
        System.out.println(a.toString());
        adminMennu();
    }
    public static void addARoom(){
        Scanner sc = new Scanner(System.in);

        try{
            System.out.println("Enter Room Number: ");
            String roomNumber = sc.nextLine();
            System.out.println("Enter Price per Room: ");
            Double price = sc.nextDouble();
            System.out.println("Enter Room Number, 1 for single bed, 2 for double bed ");
            int r = sc.nextInt();
            if(r == 1){
                Room room = new Room(roomNumber,price,RoomType.SINGLE);
                List <IRoom> rooms = new ArrayList<IRoom>();
                rooms.add(room);
                adminResource.addRoom(rooms);
            } else if (r == 2) {
                Room room = new Room(roomNumber,price,RoomType.DOUBLE);
                List <IRoom> rooms = new ArrayList<IRoom>();
                rooms.add(room);
            } else {
                System.out.println("Invalid Room Type, please enter 1 for single bed, 2 for double bed");
                addARoom();
            }

        }catch (Exception e){
            System.out.println(e.getMessage());
            addARoom();
        }
        addOtherRoom();

    }
    public static void addOtherRoom(){
        System.out.println("Would like to add another room y/n");
        Scanner scanner = new Scanner(System.in);
        String decision = scanner.nextLine();
        try{
            if (decision.equals("y")){
                addARoom();
            } else if (decision.equals("n")) {
                adminMennu();
            }else {
                System.out.println("please enter valid value, y for add another room, n for exit to admin menu");
                addARoom();;
            }
        } catch (Exception e){
            System.out.println(e.getMessage());
        }

    }
    public static void addMockData(){
        List <IRoom> rooms = new ArrayList<IRoom>();

        rooms.add(new Room("1",100.00,RoomType.SINGLE));
        rooms.add(new Room("2",100.00,RoomType.SINGLE));
        rooms.add(new Room("3",100.00,RoomType.SINGLE));
        rooms.add(new Room("4",100.00,RoomType.SINGLE));
        rooms.add(new Room("5",100.00,RoomType.SINGLE));
        rooms.add(new Room("6",200.00,RoomType.DOUBLE));
        rooms.add(new Room("7",200.00,RoomType.DOUBLE));
        rooms.add(new Room("8",200.00,RoomType.DOUBLE));
        rooms.add(new Room("9",200.00,RoomType.DOUBLE));
        rooms.add(new Room("10",200.00,RoomType.DOUBLE));
        adminResource.addRoom(rooms);
        adminResource.createACustomer("Tran","Khoi", "khoi@gmail.com");
        adminResource.createACustomer("Tran","Khoi1", "khoi1@gmail.com");
        adminResource.createACustomer("Tran","Khoi2", "khoi2@gmail.com");
        adminResource.createACustomer("Tran","Khoi3", "khoi3@gmail.com");
        adminResource.createACustomer("Tran","Khoi4", "khoi4@gmail.com");
        adminResource.createACustomer("Tran","Khoi5", "khoi5@gmail.com");
        adminResource.createACustomer("Tran","Khoi6", "khoi6@gmail.com");
        adminResource.createACustomer("Tran","Khoi7", "khoi7@gmail.com");


        adminMennu();
    }
}
