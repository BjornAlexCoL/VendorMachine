package model;

import java.util.Scanner;

public class Menu {

    public int selectFromMenu(String title, String[] choices) {
        printMenu(title, choices);
        return getValidInt(choices.length);
    }

    public void printMenu(String title, String[] menuItems) {

        System.out.println("\n"+title);
        for (int choice = 0; choice < menuItems.length; choice++) {
            System.out.println((choice + 1) + ".\t" + menuItems[choice]);
        }
        System.out.println("0.\tLeave Menu");
    }


    public int getValidInt(int maxChoice) {
        Scanner inp = new Scanner(System.in);
        String inpStr;
        int choice = -1;
        boolean isValid;
        do {
            isValid = true;
            if (maxChoice > 0) {
                System.out.print("Please make a choice: ");
            }


        inpStr = inp.nextLine();
        //inpStr="0";

        try { //Is the input an integer?
            Integer.parseInt(inpStr);
        } catch (NumberFormatException e) {//if not flag it as invalid
            isValid = false;
        }

        if (isValid) { //if input is an integer save it.
            choice = Integer.parseInt(inpStr);
        }
        if ((choice < 0) || ((choice > maxChoice) && (maxChoice != 0))) { //if choice is lesser then 0 or higher then maxChoice flag false input
            isValid = false;
        }

        if (inpStr.isEmpty()) { // if Empty string it's a bad choice //
            isValid = false;
        }
        if (!isValid) { //Bad choice try again½
            System.out.println("Invalid choice. Try again:");
        }
    }
        while(!isValid);
        return choice;
}
}
