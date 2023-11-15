package main.ConsoleInterfaceInteractions;

import main.Entities.BuyingHistoryCell;
import main.Entities.Customer;
import main.Entities.Product;
import main.Storage;
import main.utils.SortingUtils;

import java.util.*;
import java.util.stream.Collectors;

public class ShopInteractions {
    public static void putTotalGain(Scanner sc){
        int total = 0;
        for(BuyingHistoryCell cell : Storage.instance.getBuyingHistoryCellManager().getCells()){
            total += cell.getTotalPrice();
        }
        System.out.println("Выручка за весь день составляет $"+total);
    }

    public static void putCustomerBuyingRank(Scanner sc){
        List<BuyingHistoryCell> cells = Storage.instance.getBuyingHistoryCellManager().getCells();
        HashMap<Integer, Float> customers = new HashMap<>();
        for(BuyingHistoryCell cell : cells){
            if(!customers.containsKey(cell.getCustomerHasCode()))
                customers.put(cell.getCustomerHasCode(), 0f);
            float sum = customers.get(cell.getCustomerHasCode()) + cell.getTotalPrice();
            customers.remove(cell.getCustomerHasCode());
            customers.put(cell.getCustomerHasCode(), sum);
        }
        HashMap<Integer, Float> sorted = SortingUtils.sortByValue(customers);
        int i = 0;
        List<Integer> ar = new ArrayList<>(sorted.keySet());
        Collections.reverse(ar);
        for(int hashcode : ar){
            i++;
            System.out.println(i+".) "+Customer.FromHashCode(hashcode) + " TOTAL: $"+sorted.get(hashcode));
        }
    }
    public static void putProductBuyingRank(Scanner sc){
        List<BuyingHistoryCell> cells = Storage.instance.getBuyingHistoryCellManager().getCells();
        HashMap<Integer, Float> products = new HashMap<>();
        for(BuyingHistoryCell cell : cells){
            if(!products.containsKey(cell.getProductHasCode()))
                products.put(cell.getProductHasCode(), 0f);
            float sum = products.get(cell.getProductHasCode()) + 1;
            products.remove(cell.getProductHasCode());
            products.put(cell.getProductHasCode(), sum);
        }
        HashMap<Integer, Float> sorted = SortingUtils.sortByValue(products);
        int i = 0;
        List<Integer> ar = new ArrayList<>(sorted.keySet());
        Collections.reverse(ar);
        for(int hashcode : ar){
            i++;
            System.out.println(i+".) "+ Product.FromHashCode(hashcode).getDisplayName() + " TOTAL SOLD: "+sorted.get(hashcode));
        }
    }
}
