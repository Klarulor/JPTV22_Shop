package main.ConsoleInterfaceInteractions;

import main.Entities.Customer;
import main.Entities.Product;
import main.Storage;
import main.utils.ScannerUtils;

import java.util.List;
import java.util.Scanner;

public class CustomerInteraction {
    public static void addNewCustomer(Scanner sc){
        String fname = ScannerUtils.stringInput("Введите имя клиента: ");
        String lname = ScannerUtils.stringInput("Введите фамилию клиента: ");
        int num = ScannerUtils.integerInput("Введите номер телефона: ");
        float balance = ScannerUtils.integerInput("Введите начальный баланс: ");
        Customer newCustomer = Storage.instance.getCustomerManager().addNewCustomer(fname, lname, num, balance);
        System.out.println(newCustomer);
    }

    public static void putCustomerList(Scanner sc){
        List<Customer> customerList = Storage.instance.getCustomerManager().getCustomers();
        System.out.print("Список клиентов: ");

        if(customerList.isEmpty()){
            System.out.print("пусто");
        }
        System.out.println();

        for(int i = 0; i < customerList.size(); i++){
            System.out.println((i+1) + ".) " + customerList.get(i));
        }
    }
    public static void increaseBalance(Scanner sc){
        CustomerInteraction.putCustomerList(sc);
        int customerId = ScannerUtils.integerInput("Выберите нужный номер клиента: ")-1;
        List<Customer> customers = Storage.instance.getCustomerManager().getCustomers();
        if(customerId < 0 || customerId >= customers.size()){
            System.out.println("Неправильный клиент");
            return;
        }
        Customer customer = customers.get(customerId);
        System.out.println(customer);
        System.out.println("Текущий баланс составляет $"+customer.getBalance());
        int additional = ScannerUtils.integerInput("Прибавленное количество: $");
        customer.setBalance(customer.getBalance()+additional);
        System.out.println("Текущий баланс составляет $"+customer.getBalance());
    }
}
