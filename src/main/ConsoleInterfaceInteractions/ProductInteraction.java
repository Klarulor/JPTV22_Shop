package main.ConsoleInterfaceInteractions;

import main.Entities.Product;
import main.Storage;
import main.utils.ScannerUtils;

import java.util.List;
import java.util.Random;
import java.util.Scanner;


public class ProductInteraction {
    public static void addProduct(Scanner sc){
        String displayName = ScannerUtils.stringInput("Введите имя товара: ");

        int leftLimit = 48; // numeral '0'
        int rightLimit = 122; // letter 'z'
        int targetStringLength = 10;
        Random random = new Random();
        String generatedString = random.ints(leftLimit, rightLimit + 1)
                .filter(i -> (i <= 57 || i >= 65) && (i <= 90 || i >= 97))
                .limit(targetStringLength)
                .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
                .toString();


        String internalCode = generatedString;
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
    public static void changeDisplayName(Scanner sc){
        putProductList(sc);
        int id = ScannerUtils.integerInput("Выберите нужный товар: ");
        String newName = ScannerUtils.stringInput("Новое название товара:");
        Product prod = Storage.instance.getProductManager().getProducts().get(id-1);
        prod.ChangeDisplayName(newName);
    }
}
