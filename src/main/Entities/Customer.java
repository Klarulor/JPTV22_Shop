package main.Entities;

import main.Storage;
import main.utils.SQLConnector;

import java.util.Objects;
import java.util.stream.Collectors;

public class Customer {
    private int _id;
    private String _firstName;
    private String _lastName;
    private int _phoneNumber;

    private float _balance;

    public Customer(String firstName, String lastName, int phoneNumber, float balance){
        _firstName = firstName;
        _lastName = lastName;
        _phoneNumber = phoneNumber;
        _balance = balance;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Customer customer = (Customer) o;
        return _phoneNumber == customer._phoneNumber && Objects.equals(_firstName, customer._firstName) && Objects.equals(_lastName, customer._lastName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(_firstName, _lastName, _phoneNumber);
    }

    @Override
    public String toString() {
        return _firstName + " " + _lastName + " " + _phoneNumber + " " +_balance + "$";
    }

    public float getBalance() {
        return _balance;
    }

    public void setBalance(float _balance) {
        this._balance = _balance;
        SQLConnector.execute(String.format("UPDATE customers SET balance='%d' WHERE firstName='%s' AND lastName='%s'", (int)_balance, _firstName, _lastName));
    }

    public int getPhoneNumber() {
        return _phoneNumber;
    }

    public String getLastName() {
        return _lastName;
    }

    public String getFirstName() {
        return _firstName;
    }

    public static Customer FromHashCode(int hashCode){
        return Storage.instance.getCustomerManager().getCustomers().stream().filter(x -> x.hashCode() == hashCode).collect(Collectors.toList()).get(0);
    }
}
