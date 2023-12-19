package main.Entities;

import main.Storage;
import main.utils.SQLConnector;

import java.util.Objects;
import java.util.stream.Collectors;

public class Product {
    private String _displayName;
    private String _internalCode;
    private int _availableCount;
    private int _count;
    private float _price;

    public Product(String displayName, String internalCode, int availableCount, int count, float price){
        _displayName = displayName;
        _internalCode = internalCode;
        _availableCount = availableCount;
        _count = count;
        _price = price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return _availableCount == product._availableCount && _count == product._count && Float.compare(_price, product._price) == 0 && Objects.equals(_displayName, product._displayName) && Objects.equals(_internalCode, product._internalCode);
    }

    @Override
    public int hashCode() {
        return Objects.hash(_internalCode);
    }

    @Override
    public String toString() {
        return _displayName + " (" + _internalCode + ") " + _availableCount + "/" + _count + " " + _price + "$";
    }

    public float getPrice() {
        return _price;
    }

    public int getAvailableCount() {
        return _availableCount;
    }

    public int getCount() {
        return _count;
    }

    public String getDisplayName() {
        return _displayName;
    }

    public String getInternalCode() {
        return _internalCode;
    }

    public void setAvailableCount(int _availableCount) {
        this._availableCount = _availableCount;
    }

    public static Product FromHashCode(int hashCode){
        return Storage.instance.getProductManager().getProducts().stream().filter(x -> x.hashCode() == hashCode).collect(Collectors.toList()).get(0);
    }

    public void ChangeDisplayName(String newDisplayName){
        _displayName = newDisplayName;
        SQLConnector.execute(String.format("UPDATE products SET displayName='%s' WHERE internalCode='%s'", newDisplayName, _internalCode));
    }
}
