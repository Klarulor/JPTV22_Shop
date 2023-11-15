package main.ConsoleInterfaceInteractions;

import com.sun.security.ntlm.Client;
import main.Entities.BuyingHistoryCell;
import main.Entities.Customer;
import main.Entities.Product;
import main.Storage;
import main.utils.ScannerUtils;

import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class BuyingProcessInteraction
{
    public static void tryBuy(Scanner sc){
        ProductInteraction.putProductList(sc);
        int num = ScannerUtils.integerInput("Выберите нужный номер товара: ");
        List<Product> products = Storage.instance.getProductManager().getProducts();
        int id = num-1;
        if(id < 0 || id >= products.size())
        {
            System.out.println("Неправильно выбранный товар");
            return;
        }
        Product product = products.get(id);
        if(product.getAvailableCount() <= 0){
            System.out.println("Вы не можете купить этот товар, на складе 0");
            return;
        }


        CustomerInteraction.putCustomerList(sc);
        int customerId = ScannerUtils.integerInput("Выберите нужный номер клиента: ")-1;
        List<Customer> customers = Storage.instance.getCustomerManager().getCustomers();
        if(customerId < 0 || customerId >= customers.size()){
            System.out.println("Неправильный клиент");
            return;
        }
        Customer customer = customers.get(customerId);
        if(customer.getBalance() < product.getPrice()){
            System.out.println("Недостаточный баланс");
            return;
        }
        customer.setBalance(customer.getBalance() - product.getPrice());
        product.setAvailableCount(product.getAvailableCount()-1);

        int timestamp = (int) (new Date().getTime()/1000);
        Storage.instance.getBuyingHistoryCellManager().addNewCell(customer.hashCode(), product.hashCode(), product.getPrice(), timestamp);
        System.out.println("Успешно была совершена покупка. Остаточный баланс: " + customer.getBalance());
    }
}
