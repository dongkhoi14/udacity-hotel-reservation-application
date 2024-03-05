package udacity.project1.service;

import udacity.project1.model.Customer;
import udacity.project1.model.IRoom;
import udacity.project1.model.Reservation;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

public class ReservationService {
    private static ReservationService instance;
    private final ArrayList<IRoom> allRooms;
    private final ArrayList<Reservation> allReservations;
    public static ReservationService getInstance(){
        if (instance == null){
            instance = new ReservationService();
        }
        return instance;
    }
    public ReservationService() {
        this.allRooms = new ArrayList<>();
        this.allReservations = new ArrayList<>();
    }

    public void addRoom(IRoom newRoom){
        System.out.println(allRooms.toString());
        for (IRoom room: allRooms){
            if(room.getRoomNumber().equals(newRoom.getRoomNumber())){
                throw new IllegalArgumentException("Room  " + room.getRoomNumber()+" already exist!");
            }
        }
        allRooms.add(newRoom);
    }

    public IRoom getARoom(String roomID){
        for (IRoom room: allRooms){
            if(room.getRoomNumber().equals(roomID)){
                return room;
            }
        }
        return null;
    }

    public Reservation reserveARoom(Customer customer, IRoom room, Date checkInDate, Date checkOutDate){
        Reservation reservation = new Reservation(customer, room, checkInDate,checkOutDate);
        if(isReserved(room)){
            throw new IllegalArgumentException("Room  " + room.getRoomNumber()+" already Reserved!");
        }
        allReservations.add(reservation);
        return reservation;
    }
    private boolean isReserved(IRoom room){
        for (Reservation reservation: allReservations){
            if (reservation.getiRoom().getRoomNumber().equals(room.getRoomNumber())){
                return true;
            }
        }
        return false;
    }

    //Find available rooms
    public Collection<IRoom> findRooms(Date checkInDate, Date checkOutDate){
        ArrayList<IRoom> listRoom = new ArrayList<>(this.allRooms);
        for (Reservation reservation: allReservations){
            if(reservation.getCheckInDate().equals(checkInDate) || reservation.getCheckInDate().equals(checkOutDate)){
                listRoom.remove(reservation.getiRoom());
            }
        }
        return listRoom;
    }
    public ArrayList<IRoom> getAllRooms() {
        return  allRooms;
    }
    public Collection<Reservation> getCustomerReservation(Customer customer){

        return null;
    }
    public void printAllReservation(){
        if(!allReservations.isEmpty()){
            for(Reservation reservation: allReservations){
                System.out.printf(reservation.toString());
            }
        }else{
            System.out.println("Don't have any Reservation");
        }

    }

}
