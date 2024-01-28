package udacity.project1;

import udacity.project1.model.Customer;
import udacity.project1.model.Room;
import udacity.project1.model.RoomType;
import udacity.project1.service.CustomerService;

import java.util.List;

public class Main {
    public static void main(String[] args) {

        Customer customer = new Customer("Khoi", "Tran", "khoideptrai@gmail.com");
        Customer customer1 = new Customer("Khoi", "Tran", "khodeptrai@gmail.com");
        Customer customer2 = new Customer("Khoi", "Tran", "khoieptrai@gmail.com");
        CustomerService customerService = CustomerService.getInstance();
        customerService.addCustomer("Khoi", "Tran", "khoidptrai@gmail.com");
//        var a = customerService.getAllCustomers();
        System.out.printf(customerService.getAllCustomer().toString());
    }
}