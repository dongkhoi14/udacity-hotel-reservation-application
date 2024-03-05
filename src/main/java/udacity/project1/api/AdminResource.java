package udacity.project1.api;

import udacity.project1.model.Customer;
import udacity.project1.model.IRoom;
import udacity.project1.model.Room;
import udacity.project1.service.CustomerService;
import udacity.project1.service.ReservationService;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class AdminResource {
    private final CustomerService customerService = new CustomerService().getInstance();
    private final ReservationService  reservationService = new ReservationService().getInstance();

    public AdminResource() {

    }


    public Customer getCustomer(String customerEmail){

        return customerService.getCustomer(customerEmail);
    }
    public void addRoom(List<IRoom> rooms){

        for (IRoom room: rooms){
            reservationService.addRoom(room);
        }
    }
//    private boolean isRoomExist(IRoom room){
//        var allRooms = getAllRooms();
//        for (IRoom exitRoom: allRooms){
//            if (exitRoom.getRoomNumber().equals(room.getRoomNumber())){
//                System.out.println("Room number existed, please enter other room number");
//                return true;
//            }
//        }
//        return false;
//    }
    public Collection<IRoom> getAllRooms(){
        var allRoom = reservationService.getAllRooms();
        return allRoom;
    }

    public Collection<Customer> getAllCustomers(){
        return customerService.getAllCustomers();
    }

    public void displayAllReservations(){
        reservationService.printAllReservation();
    }
    public void createACustomer( String firstName, String lastName,String email){
        customerService.addCustomer(firstName,lastName,email);
    }
}
