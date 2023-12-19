package main.Managers;

import main.Entities.Customer;
import main.utils.SQLConnector;

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
        String str = String.format("INSERT INTO customers (firstName, lastName, phoneNumber, balance) VALUES ('%s','%s','%d','%d')",
                firstName, lastName, phone, (int)startBalance);
        SQLConnector.execute(str);
        return customer;
    }

    public List<Customer> getCustomers(){
        return _customers;
    }
}
