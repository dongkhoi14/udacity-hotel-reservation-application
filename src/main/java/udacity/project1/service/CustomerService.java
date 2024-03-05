package udacity.project1.service;

import udacity.project1.model.Customer;

import java.util.*;

public class CustomerService {
    private static CustomerService instance;
    private final ArrayList<Customer> customers;

    public static CustomerService getInstance() {
        if (instance == null){
            instance = new CustomerService();
        }
        return instance;
    }
    public CustomerService(){
        this.customers = new ArrayList<>();
    }

    public void addCustomer(String firstName, String lastName, String email){
        Customer newCustomer = new Customer(firstName,lastName,email);
        if (isCustomerExisted(email)){
            throw new IllegalArgumentException("Email: " + email+" already exist!");
        }else {
            customers.add(newCustomer);
        }
    }
    private boolean isCustomerExisted(String email){
        for (Customer customer: customers){
            if (customer.getEmail().equals(email)){
                return true;
            }
        }
        return false;
    }


    //Get customer by email
    public Customer getCustomer(String customerEmail){
        for (Customer customer: customers){
            if(customer.getEmail().equals(customerEmail)){
                return customer;
            }
        }
        return null;
    }

    public Collection<Customer> getAllCustomers(){
        return  customers;
    }


}
