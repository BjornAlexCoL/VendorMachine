package se.lexicon.g34.bl.model;

import model.Till;
import org.junit.Before;
import org.junit.Test;

public class TillTest{
    @Test
    public void setTillTest() {

        Till mainTill = new Till(20); //Create a new till with 20 of each value in it.
        Till depositPool = new Till(10);//Create a new till with 0 of each value in it.
        System.out.println("--------------------------------------------");
        System.out.println("Main Till");
        mainTill.printTill();
        System.out.println("--------------------------------------------");
        System.out.println("Deposit Pool");
        depositPool.printTill();
        System.out.println("--------------------------------------------");
        System.out.println("Add 88888 to Deposit Pool");

        depositPool.deposit(88888);
        depositPool.printTill();
        System.out.println("--------------------------------------------");
        System.out.println("Withdraw 88888 Deposit Pool");

        depositPool.withDraw(88888);
        depositPool.printTill();
        System.out.println("--------------------------------------------");
        System.out.println("Try to deposit .1 Deposit Pool");

        depositPool.deposit(-1);
        depositPool.printTill();
        System.out.println("--------------------------------------------");
        System.out.println("Buy");
        depositPool.withDraw(450);
        mainTill.deposit(450);
        depositPool.printTill();
        mainTill.printTill();





 //       depositPool.withDraw(1560);
 //       depositPool.printTill();
//        depositPool.withDraw(-100);
//        depositPool.printTill();
 //       depositPool.withDraw(20000);
 //       depositPool.printTill();
          depositPool.withDraw(18880);
          depositPool.printTill();

    }

}
