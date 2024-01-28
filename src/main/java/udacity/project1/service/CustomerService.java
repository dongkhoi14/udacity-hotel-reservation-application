package udacity.project1.service;

import udacity.project1.model.Customer;

import java.util.*;

public class CustomerService {
    private static CustomerService customerService;
    private ArrayList<Customer> customers;

    public CustomerService(){
        this.customers = new ArrayList<>() {
        };
    }
    public static CustomerService getInstance() {
        if (customerService == null){
            customerService = new CustomerService();
        }
        return customerService;
    }

    public void addCustomer(String firstName, String lastName, String email){
        Customer customer = new Customer(firstName,lastName,email);
    }

    //Get customer by email
    public Customer getCustomer(String customerEmail){
        return null;
    }

    public Collection<Customer> getAllCustomer(){
        return  customers;
    }


}
