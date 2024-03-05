package udacity.project1.api;

import udacity.project1.model.Customer;
import udacity.project1.model.IRoom;
import udacity.project1.model.Reservation;
import udacity.project1.model.Room;
import udacity.project1.service.CustomerService;
import udacity.project1.service.ReservationService;

import java.util.Collection;
import java.util.Date;

public class HotelResource {

    private final CustomerService customerService = new CustomerService().getInstance();
    private final ReservationService  reservationService = new ReservationService().getInstance();

    public HotelResource() {

    }



    public Customer getCustomer(String email){

        return customerService.getCustomer(email);
    }
    public void createACustomer( String firstName, String lastName,String email){
        customerService.addCustomer(firstName,lastName,email);
    }
    public IRoom getRoom(String roomNumber){

        return reservationService.getARoom(roomNumber);
    }

    public Reservation bookARoom(String customerEmail, IRoom room, Date dateCheckIn, Date dateCheckOut){

        Customer customer = customerService.getCustomer(customerEmail);
        reservationService.reserveARoom(customer,room,dateCheckIn,dateCheckOut);
        return reservationService.reserveARoom(customer,room,dateCheckIn,dateCheckOut);
    }
    public Collection<Reservation> getCustomerReservation(String customerEmail){
        return reservationService.getCustomerReservation(customerService.getCustomer(customerEmail));
    }
    public Collection<IRoom> findARoom(Date dateCheckIn, Date dateCheckOut){
        return reservationService.findRooms(dateCheckIn,dateCheckOut);
    }


}
