package main.ConsoleInterfaceInteractions;

import main.Entities.Product;
import main.Storage;
import main.utils.ScannerUtils;

import java.util.List;
import java.util.Scanner;


public class ProductInteraction {
    public static void addProduct(Scanner sc){
        String displayName = ScannerUtils.stringInput("Введите имя товара: ");
        String internalCode = "_";
        int count = ScannerUtils.integerInput("Введите количество: ");
        int price = ScannerUtils.integerInput("Введите цену за единицу товара: ");

        Product newProduct = Storage.instance.getProductManager().addNewProduct(displayName, internalCode, count, price);
        System.out.println("Успешно был создан продукт: " + newProduct.toString());

    }
    public static void putProductList(Scanner sc){
        List<Product> productList = Storage.instance.getProductManager().getProducts();
        System.out.print("Список товаров: ");

        if(productList.isEmpty()){
            System.out.print("пусто");
        }
        System.out.println();

        for(int i = 0; i < productList.size(); i++){
            System.out.println((i+1) + ".) " + productList.get(i));
        }
    }
}
