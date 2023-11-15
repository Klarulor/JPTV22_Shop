package main;

import main.ConsoleInterfaceInteractions.BuyingProcessInteraction;
import main.ConsoleInterfaceInteractions.CustomerInteraction;
import main.ConsoleInterfaceInteractions.ProductInteraction;
import main.ConsoleInterfaceInteractions.ShopInteractions;
import main.utils.ScannerUtils;

import java.util.Scanner;

public class ConsoleInterface {
    public void load(){
        Scanner sc = new Scanner(System.in);
        boolean isRunning = true;
        do{
            System.out.print(
                    "1 - Выход из программы\n" +
                    "2 - Добавить товар\n" +
                    "3 - Список продаваемых товаров\n" +
                    "4 - Добавить покупаетля\n" +
                    "5 - Список зарегистрированных покупателей\n" +
                    "6 - Покупка покупателем продукта\n" +
                    "7 - Оборот магазина за всё время работы\n" +
                    "8 - Добавить денег покупателю\n" +
                    "9 - Рейтинг покупателе по количеству покупок\n" +
                    "10 - Рейтинг продаваемости товаров\n" +
                    "Выберите номер действия: ");
            int num = sc.nextInt();
            switch (num){
                case 1:
                    isRunning = false;
                    System.out.println("Хорошего дня!\nПриходите ещё!");
                    break;
                case 2:
                    ProductInteraction.addProduct(sc);
                    break;
                case 3:
                    ProductInteraction.putProductList(sc);
                    break;
                case 4:
                    CustomerInteraction.addNewCustomer(sc);
                    break;
                case 5:
                    CustomerInteraction.putCustomerList(sc);
                    break;
                case 6:
                    BuyingProcessInteraction.tryBuy(sc);
                    break;
                case 7:
                    ShopInteractions.putTotalGain(sc);
                    break;
                case 8:
                    CustomerInteraction.increaseBalance(sc);
                    break;
                case 9:
                    ShopInteractions.putCustomerBuyingRank(sc);
                    break;
                case 10:
                    ShopInteractions.putProductBuyingRank(sc);
                    break;
                default:
                    System.out.println("Неправильный ввод номера");
            }
            System.out.println("-----------------------------------------------");
            if(num != 1 && !ScannerUtils.booleanInput("Продолжить? (y/n): "))
                isRunning = false;
        }while(isRunning);
        Storage.instance.exit();
    }
}
