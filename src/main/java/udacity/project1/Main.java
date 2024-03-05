package udacity.project1;

import udacity.project1.api.AdminResource;
import udacity.project1.api.HotelResource;
import udacity.project1.model.Customer;
import udacity.project1.model.IRoom;
import udacity.project1.model.Room;
import udacity.project1.model.RoomType;
import udacity.project1.service.CustomerService;
import udacity.project1.service.ReservationService;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Main {
    public static void main(String[] args) {
//        CustomerService customerService = new CustomerService();
//        CustomerService.getInstance();
//        customerService.addCustomer("khoi", "tran","s@gmail.com");
//        System.out.println(customerService.getAllCustomers().toString());
        MainMenu.MainMenu();
}}