package main;

import main.ConsoleInterfaceInteractions.BuyingProcessInteraction;
import main.Entities.BuyingHistoryCell;
import main.Entities.Customer;
import main.Entities.Product;
import main.Managers.BuyingHistoryCellManager;
import main.Managers.CustomerManager;
import main.Managers.ProductManager;

import java.util.ArrayList;

public class Storage {
    public static Storage instance;

    private ProductManager _productManager;
    private CustomerManager _customerManager;
    private BuyingHistoryCellManager _buyingHistoryCellManager;

    public Storage(){
        Storage.instance = this;
    }
    public void init(){

        ArrayList<Product> productList = new ArrayList<>();
        _productManager = new ProductManager(productList);

        ArrayList<Customer> customerList = new ArrayList<>();
        _customerManager = new CustomerManager(customerList);

        ArrayList<BuyingHistoryCell> cells = new ArrayList<>();
        _buyingHistoryCellManager = new BuyingHistoryCellManager(cells);
    }

    public void exit(){

    }

    public ProductManager getProductManager() {
        return _productManager;
    }
    public CustomerManager getCustomerManager(){
        return _customerManager;
    }
    public BuyingHistoryCellManager getBuyingHistoryCellManager(){
        return _buyingHistoryCellManager;
    }

}
