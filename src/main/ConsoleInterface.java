package main;

import main.ConsoleInterfaceInteractions.BuyingProcessInteraction;
import main.ConsoleInterfaceInteractions.CustomerInteraction;
import main.ConsoleInterfaceInteractions.ProductInteraction;
import main.ConsoleInterfaceInteractions.ShopInteractions;
import main.utils.ScannerUtils;

import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

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
                    "11 - Сменить название товара\n" +
                    "12 - Сменить номер телефона клиента\n" +
                    "13 - Просмотреть скидочные компании\n"+
                    "Выберите номер действия: ");
            int num = sc.nextInt();
            if(!ScannerUtils.booleanInput("Продолжить работу в задаче номер "+num+" (y/n)?"))
                continue;
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
                case 11:
                    ProductInteraction.changeDisplayName(sc);
                case 12:
                    CustomerInteraction.changePhoneNumber(sc);
                    break;
                case 13:
                    Date currentDate = new Date();
                    Date[] dates = new Date[]{
                            new Date(currentDate.getYear(), 11, 29, 23, 59, 59), // new year
                            new Date(currentDate.getYear(), 5, 1, 0, 0, 0) // summer
                    };
                    String[] names = new String[]{
                            "Новогодняя распродажа",
                            "Летняя распродажа"
                    };

                    for(int i = 0; i < dates.length; i++){

                        String name = names[i];
                        Date date = dates[i];

                        long millisRemaining = date.getTime() - currentDate.getTime();

                        long days = TimeUnit.MILLISECONDS.toDays(millisRemaining);
                        long hours = TimeUnit.MILLISECONDS.toHours(millisRemaining) % 24;
                        long minutes = TimeUnit.MILLISECONDS.toMinutes(millisRemaining) % 60;
                        long seconds = TimeUnit.MILLISECONDS.toSeconds(millisRemaining) % 60;

                        if(seconds > 0 && days > 0){
                            System.out.println(String.format("%s! Осталось %s дней %s часов %s минут %s секунд", name,days, hours, minutes, seconds));
                        }else{
                            date.setYear(date.getYear()+1);

                             millisRemaining = date.getTime() - currentDate.getTime();

                             days = TimeUnit.MILLISECONDS.toDays(millisRemaining);
                             hours = TimeUnit.MILLISECONDS.toHours(millisRemaining) % 24;
                             minutes = TimeUnit.MILLISECONDS.toMinutes(millisRemaining) % 60;
                             seconds = TimeUnit.MILLISECONDS.toSeconds(millisRemaining) % 60;

                            System.out.println(String.format("%s! Осталось %s дней %s часов %s минут %s секунд",name,days, hours, minutes, seconds));
                        }
                    }






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
