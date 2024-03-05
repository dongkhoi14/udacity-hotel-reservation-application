package udacity.project1;

import udacity.project1.api.HotelResource;
import udacity.project1.model.Reservation;
import udacity.project1.service.ReservationService;

import java.util.Date;
import java.util.Scanner;

public class MainMenu {
    private static final HotelResource hotelResource = new HotelResource();


    public static void MainMenu() {
        Scanner scanner = new Scanner(System.in);
        displayMainMenu();
        var selectedMenu = "";
        try{

            do {
                selectedMenu =scanner.nextLine();
                switch (selectedMenu){
                    case "1":
                        findAndReserveARoom();
                        break;
                    case "2":
                        seeMyReservations();
                        break;
                    case "3":
                        createAccount();

                        break;
                    case "4":
                        AdminMenu.adminMennu();
                        break;
                    case "5":
                        System.out.println("Exiting....");
                        break;
                    default:
                        System.out.println("Please enter a valid option number (1-5)\n");
                        MainMenu();
                }

                System.out.println(selectedMenu);

            }while(selectedMenu.equals("5"));
        } catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
    private static void displayMainMenu() {
        System.out.println("\nWelcome to the Hotel Reservation Application\n\n" +
                "-------------------------------------------------------\n" +
                "1. Find and reserve a room\n" +
                "2. See my reservations\n" +
                "3. Create an Account\n" +
                "4. Admin\n" +
                "5. Exit\n" +
                "-------------------------------------------------------\n" +
                "Please select a number for the menu option");
    }
    public static void findAndReserveARoom(){
        Scanner sc = new Scanner(System.in);
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter CheckIn Date mm/dd/yyyy example 02/01/2020");


        System.out.println("Enter Check-Out Date mm/dd/yyyy example 02/21/2020");

    }
    private static void getAllAvailableRoom(){

    }
    public static void seeMyReservations(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Please enter customer email : ");
        String customerEmail = sc.nextLine();
        var myReserved = hotelResource.getCustomerReservation(customerEmail);
        if(!myReserved.isEmpty()){
            for (Reservation reservation: myReserved){
                reservation.toString();

            }
        }

    }
    public static void createAccount(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter your first name");
        String firstName = scanner.nextLine();
        System.out.println("Enter your last name");
        String lastName = scanner.nextLine();
        System.out.println("Enter your email");
        String customerEmail = scanner.nextLine();

        try {
            hotelResource.createACustomer(firstName,lastName,customerEmail);
            System.out.println("Create Account Successfully!");
            MainMenu();
        }catch (Exception e){
            System.out.println(e.getMessage());
        }


    }
}
