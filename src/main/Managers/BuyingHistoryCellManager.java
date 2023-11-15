package main.Managers;

import main.Entities.BuyingHistoryCell;

import java.util.List;

public class BuyingHistoryCellManager {
    private List<BuyingHistoryCell> _cells;

    public BuyingHistoryCellManager(List<BuyingHistoryCell> cells){
        _cells = cells;
    }

    public BuyingHistoryCell addNewCell(int customerHashCode, int productHasCode, float totalPrice, int timestamp){
        BuyingHistoryCell cell = new BuyingHistoryCell(customerHashCode, productHasCode, totalPrice, timestamp);
        _cells.add(cell);
        return cell;
    }

    public List<BuyingHistoryCell> getCells(){
        return _cells;
    }
}
