package se.lexicon.g34.bl;

import data.VendorMachineImp;
import model.Menu;
import model.Products;
import model.Till;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
        VendorMachineImp vendorMachine = new VendorMachineImp();
        Menu menu = new Menu();
        String[] menuChoices;
        int choice;
        int trash;
        Till menuTill = new Till();
        Products boughtProduct;
        do {
            menuChoices = new String[]{"Depositmangagement", "Buy Products","Show Productdescriptions", "Emter New Products"};
            choice = menu.selectFromMenu("Vendor Machine", menuChoices);
            switch (choice) {
                case 1: {
                    do {
                        menuChoices = new String[]{"Enter Money into Machine", "Use Credit Card", "Show Balance","Show Till","Withdraw Deposited Money"};
                        choice = menu.selectFromMenu("Depositmanagement", menuChoices);
                        switch (choice) {
                            case 1: {
                                do {
                                    choice = menu.selectFromMenu("Deposit Denomination", menuTill.getDenominationsList());
                                    if (choice > 0) {
                                        choice = menuTill.getDenomination(choice);
                                        vendorMachine.addCurrency(choice);
                                        System.out.println(choice + " kr added");
                                        System.out.println("Total Balance is " + vendorMachine.getBalance());
                                    }
                                }
                                while (choice != 0);
                                choice = 1;
                                break;
                            }
                            case 2: {
                                System.out.print("\nUse Creditcard. Please enter amount:");
                                choice = menu.getValidInt(0);
                                vendorMachine.addCurrency(choice);
                                System.out.println(choice + " kr debet on your card.");
                                choice = 2;
                                break;
                            }
                            case 3:{
                                System.out.println("Your Balance is " + vendorMachine.getBalance());
                                choice=3;
                                break;
                            }
                            case 4:{
                                vendorMachine.printDenominations();
                                choice=4;
                                break;
                            }
                            case 5: {
                                System.out.println("\nWithdrawing all deposited (" + vendorMachine.getBalance() + ")");
                                System.out.println("Your Balance is now " + vendorMachine.endSession());

                                System.out.println("Thanks for stepping by.");

                                choice = 5;
                                break;
                            }
                            default: {
                                break;
                            }
                        }
                    }
                    while (choice != 0);
                    choice = 1;
                    break;
                }
                case 2: {
                    do {
                        choice = menu.selectFromMenu("Buy Products", vendorMachine.getProductsByType(0));
                        if (choice > 0) {
                            boughtProduct = vendorMachine.request((choice - 1));
                            if (boughtProduct != null) {
                                System.out.println(boughtProduct.use());
                            }
                            choice = 2;
                        }
                    }
                    while (choice != 0);
                    choice = 2;
                    break;
                }
                case 3:{
                    vendorMachine.printDescriptions();
                    choice=3;
                    break;
                }
                case 4: {
                    do {
                        menuChoices = new String[]{"Drinks", "Foods", "Snacks"};
                        choice = menu.selectFromMenu("Enter more products", menuChoices);
                        if (choice > 0) {
                            trash = vendorMachine.addProduct(choice);
                        }
                    }
                    while (choice != 0);
                    choice = 4;
                    break;
                }
                default: {
                    break;
                }
            }
        }
        while (choice != 0);

}
}