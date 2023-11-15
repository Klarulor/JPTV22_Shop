package main.Entities;

import sun.util.resources.cldr.ti.CurrencyNames_ti;

import java.util.Objects;

public class BuyingHistoryCell {
    private int _customerHasCode;
    private int _productHasCode;
    private float _totalPrice;
    private int _timestamp;

    public BuyingHistoryCell(int customerHashCode, int productHasCode, float totalPrice, int timestamp){
        _customerHasCode = customerHashCode;
        _productHasCode = productHasCode;
        _totalPrice = totalPrice;
        _timestamp = timestamp;
    }

    public int getCustomerHasCode() {
        return _customerHasCode;
    }

    public int getProductHasCode() {
        return _productHasCode;
    }

    public int getTimestamp() {
        return _timestamp;
    }

    public float getTotalPrice() {
        return _totalPrice;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BuyingHistoryCell that = (BuyingHistoryCell) o;
        return _customerHasCode == that._customerHasCode && _productHasCode == that._productHasCode && _totalPrice == that._totalPrice && _timestamp == that._timestamp;
    }

    @Override
    public int hashCode() {
        return Objects.hash(_customerHasCode, _productHasCode, _totalPrice, _timestamp);
    }


}
