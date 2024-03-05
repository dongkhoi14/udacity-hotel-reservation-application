package udacity.project1.model;
import java.util.Date;
public class Reservation {
    private final Customer customer;
    private final IRoom iRoom;
    private final Date checkInDate;
    private final Date checkOutDate;

    public Customer getCustomer() {
        return customer;
    }

    public IRoom getiRoom() {
        return iRoom;
    }

    public Date getCheckInDate() {
        return checkInDate;
    }

    public Date getCheckOutDate() {
        return checkOutDate;
    }

    public Reservation(Customer customer, IRoom iRoom, Date checkInDate, Date checkOutDate) {
        this.customer = customer;
        this.iRoom = iRoom;
        this.checkInDate = checkInDate;
        this.checkOutDate = checkOutDate;
    }
    @Override
    public String toString(){
        return "Customer :" + customer.getFirstName() + " Room : " + iRoom.getRoomNumber() + " Checkin Date: " + getCheckInDate().toString() + " Checkout Date: " + getCheckOutDate().toString() ;
    }
}
