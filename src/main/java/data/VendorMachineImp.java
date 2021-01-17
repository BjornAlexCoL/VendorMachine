package data;

import model.*;

import java.util.Arrays;
import java.util.Scanner;


// if we want to implement an interface we should use implements keyword
public class VendorMachineImp implements VendingMachine {
    Products[] products = new Products[0];
    Till depositPool = new Till();

    @Override
    public void addCurrency(int Amount) {
        depositPool.deposit(Amount);
    }

    @Override
    public Products request(int productNumber) {
        if (products[productNumber].getInStock() < 1) {
            System.out.println("Temporarily out of " + products[productNumber].getName() + ". Please buy something else or come by later.");
            return null;
        }
        if (depositPool.withDraw(products[productNumber].getPrice()) > 0) {
            return null;
        }
        products[productNumber].setInStock(products[productNumber].getInStock() - 1);

        System.out.println("You buy one " + products[productNumber].examine());

        return products[productNumber];

    }

    @Override
    public int endSession() {
        printDenominations();
        return depositPool.withDraw(depositPool.getBalance());
    }

    @Override
    public String getDescription(int productNumber) {
        return products[productNumber].examine();
    }

    @Override
    public int getBalance() {
        return depositPool.getBalance();
    }

    @Override
    public String[] getProducts() {
        String[] productList = new String[products.length];

        for (int index = 0; index < products.length - 1; index++) {
            productList[index] = products[index].getName() + " \t" + index;
        }
        return productList;
    }

    @Override
    public String[] getProductsByType(int type) {
        String[] productList = new String[products.length];
        for (int index = 0; index < products.length; index++) {
            if ((products[index].getProductType() == type) || (type == 0)) {
                productList[index] = products[index].getName();
            }
        }
        return productList;
    }


    @Override

    public int addProduct(int type) {
        Scanner inpStr = new Scanner(System.in);
        Menu menu = new Menu();
        int index = products.length;
        Products newProduct = null;
        System.out.println("\nPlease Enter");

        System.out.print("Name of product:");
        String name = inpStr.nextLine();
        System.out.print("Cost of product:");
        int cost = menu.getValidInt(0);
        System.out.print("Amount of units in stock:");
        int inStock = menu.getValidInt(0);
        switch (type) {
            case 1: {
                System.out.print("Volume in cl in the drink unit:");
                String volume = Integer.toString(menu.getValidInt(0));
                index = searchProduct(name + " " + volume + " " + cost + " " + type);
                newProduct = new Drinks(name, cost, inStock, type, volume);
                break;
            }
            case 2: {
                System.out.print("Amount of kcal in the food:");
                int calories = menu.getValidInt(0);
                index = searchProduct(name + " " + calories + " " + cost + " " + type);
                newProduct = new Foods(name, cost, inStock, type, calories);
                break;
            }
            case 3: {
                System.out.print("Percent of Sugar in the snack:");
                int sugarPercent = menu.getValidInt(0);
                index = searchProduct(name + " " + sugarPercent + " " + cost + " " + type);
                newProduct = new Snacks(name, cost, inStock, type, sugarPercent);

                break;
            }
            default: {
                break;
            }
        }
        if (index < 0) {
            Products[] newProductArray = Arrays.copyOf(products, products.length + 1);
            index = newProductArray.length - 1;
            newProductArray[index] = newProduct;
            products = newProductArray;
            System.out.println(products[index].examine() + " added");

        } else {
            System.out.println("Product exist!");
            String[] checkYes = new String[]{"Yes"};
            if (menu.selectFromMenu("Do you want me to add the amount to current stock", checkYes) == 1) {
                products[index].setInStock(products[index].getInStock() + inStock);
                System.out.println(inStock + " units of " + products[index].examine() + " added. Current stock is " + products[index].getInStock());
            }
        }

        return index;
    }

    @Override
    public void printDenominations() {
        depositPool.printTill();
    }

    @Override
    public void printDescriptions() {
        System.out.println("\nProduct Descriptions");
        for (Products product : products) {
            System.out.println(product.examine());
        }
    }

    @Override
    public int searchProduct(String toCheck) {
        if (products.length > 0) {
            for (int index = 0; index < products.length; index++) {
                if (products[index].toString().equals(toCheck)) {
                    return index;
                }
            }

        }
        return -1;
    }
}

