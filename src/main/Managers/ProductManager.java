package main.Managers;

import main.Entities.Product;
import main.utils.SQLConnector;

import java.util.ArrayList;
import java.util.List;

public class ProductManager {
    private List<Product> _products;

    public ProductManager(ArrayList<Product> productList){
        _products = productList;
    }

    public Product addNewProduct(String displayName, String internalCode, int count, float price){
        Product product = new Product(displayName, internalCode, count, count, price);
        _products.add(product);
        String str = String.format("INSERT INTO products (displayName, internalCode, avaliableCount, count, price) VALUES ('%s','%s','%d','%d','%d')",
                displayName, internalCode, count, count, (int)price);
        SQLConnector.execute(str);
        return product;
    }

    public List<Product> getProducts() {
        return _products;
    }
}
