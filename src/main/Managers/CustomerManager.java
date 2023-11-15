package main.Managers;

import main.Entities.Customer;

import java.util.ArrayList;
import java.util.List;

public class CustomerManager {
    private List<Customer> _customers;

    public CustomerManager(ArrayList<Customer> customers){
        _customers = customers;
    }

    public Customer addNewCustomer(String firstName, String lastName, int phone, float startBalance){
        Customer customer = new Customer(firstName, lastName, phone, startBalance);
        _customers.add(customer);
        return customer;
    }

    public List<Customer> getCustomers(){
        return _customers;
    }
}
