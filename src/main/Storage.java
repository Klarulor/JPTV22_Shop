package main;

import main.ConsoleInterfaceInteractions.BuyingProcessInteraction;
import main.Entities.BuyingHistoryCell;
import main.Entities.Customer;
import main.Entities.Product;
import main.Managers.BuyingHistoryCellManager;
import main.Managers.CustomerManager;
import main.Managers.ProductManager;
import main.utils.SQLConnector;

import java.util.ArrayList;
import java.util.List;

public class Storage {
    public static Storage instance;

    private ProductManager _productManager;
    private CustomerManager _customerManager;
    private BuyingHistoryCellManager _buyingHistoryCellManager;

    public Storage(){
        Storage.instance = this;
    }
    public void init(){

        ArrayList<Product> productList = fetchProductList();
        _productManager = new ProductManager(productList);

        ArrayList<Customer> customerList = fetchCustomerList();
        _customerManager = new CustomerManager(customerList);

        ArrayList<BuyingHistoryCell> cells = fetchHistoryCellList();
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

    private ArrayList<Product> fetchProductList(){
        ArrayList<Product> products = new ArrayList<>();
        List<List<Object>> res = SQLConnector.reqQuery("SELECT * FROM products");
        for(List<Object> row : res){
            Product prod = new Product((String)row.get(0), (String)row.get(1), (int)row.get(2), (int)row.get(3), (float)row.get(4));
            products.add(prod);
        }
        return products;
    }
    private ArrayList<Customer> fetchCustomerList(){
        ArrayList<Customer> customers = new ArrayList<>();
        List<List<Object>> res = SQLConnector.reqQuery("SELECT * FROM customers");
        for(List<Object> row : res){
            Customer customer = new Customer((String)row.get(0), (String)row.get(1), (int)row.get(2), (float)row.get(3));
            customers.add(customer);
        }
        return customers;
    }
    private ArrayList<BuyingHistoryCell> fetchHistoryCellList(){
        ArrayList<BuyingHistoryCell> cells = new ArrayList<>();
        List<List<Object>> res = SQLConnector.reqQuery("SELECT * FROM buyingHistoryCells");
        for(List<Object> row : res){
            BuyingHistoryCell cell = new BuyingHistoryCell(Integer.parseInt((String)row.get(0)), Integer.parseInt((String)row.get(1)), (float)row.get(2), (int)row.get(3));
            cells.add(cell);
        }
        return cells;
    }

}
