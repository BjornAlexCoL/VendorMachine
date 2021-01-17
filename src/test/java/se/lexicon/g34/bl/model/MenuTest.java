package se.lexicon.g34.bl.model;

import model.Menu;
import model.Till;

import org.junit.Test;
import java.util.Scanner;

public class MenuTest {

    @Test
    public void selectFromMenuTest() {
        String[] test = new String[]{"Alfa", "Beta", "Gamma"};
        Till tillTest = new Till();
        Menu menu = new Menu();

    menu.printMenu("Testmenu", test);
    menu.printMenu("Testmenu", tillTest.getDenominationsList() );

    }
@Test
    public void getValidIntTest() {
 //   Scanner inp=new Scanner(System.in);
//    String inpStr = inp.nextLine();
 //   System.out.println(inpStr);
    Menu menu = new Menu();
    System.out.println("Test ");

    int choice= menu.getValidInt(7);
    System.out.println("Test "+choice);

    }

}