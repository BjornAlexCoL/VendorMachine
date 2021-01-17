package data;

import model.Products;

public interface VendingMachine {

    void addCurrency(int Amount);
    Products request (int ProductNumber);
    int endSession();
    String getDescription(int productNumber);
    int getBalance();
    String[] getProducts();
    String[] getProductsByType(int type);
    int addProduct(int type);
    void printDenominations();
    void printDescriptions();
    int searchProduct(String toCheck);
}
