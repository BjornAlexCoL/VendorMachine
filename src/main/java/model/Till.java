package model;

import java.util.Arrays;

public class Till {
    static String[] DENOMINATIONSLIST = {"1 kr", "2 kr", "5 kr", "10 kr", "20 kr", "50 kr", "100 kr", "200 kr", "500 kr", "1000 kr"};
    TillDenomination[] tillDenominations;


    public Till() {
        tillDenominations = new TillDenomination[0];
        setChange(0);
    }

    public Till(int change) {
        tillDenominations = new TillDenomination[0];
        setChange(change);
    }

    public int getBalance() {
        int totBalance = 0;

        for (TillDenomination sum : tillDenominations) {
            totBalance += sum.getBalance();
        }
        return totBalance;
    }

    public int deposit(int sum) {
        if (sum < 0) {
            System.out.println("You trying to deposit negative amount.");
            return sum;
        }
        int change;
        for (int loop = tillDenominations.length - 1; loop >= 0; loop--) {
            change = sum / tillDenominations[loop].getDenom();
            if (change > 0) {
                sum -= (tillDenominations[loop].deposit(change) * tillDenominations[loop].getDenom());
            }
            if (sum == 0) {
                return sum;
            }
        }

        return sum;


    }

    public int withDraw(int sum) {
        int change;
        if (sum > getBalance()) {
            System.out.println("Insufficient balance. Your balance is only " + getBalance());
            return sum;
        }
        if (sum < 0) {
            System.out.println("You trying to withdraw negative amount.");
            return sum;
        }

        for (int loop = tillDenominations.length - 1; loop >= 0; loop--) {
            change = sum / tillDenominations[loop].getDenom();
            if (change > 0) {
                while (change > tillDenominations[loop].getAmount()) change(loop);
                sum -= (tillDenominations[loop].withDraw(change) * tillDenominations[loop].getDenom());
            }
        }
        return sum;
    }

    private void change(int index) {
        int sum;
        for (int loop=index+1;loop<tillDenominations.length ;loop++ ) {
            if (tillDenominations[loop].getAmount() > 0){
                sum = tillDenominations[loop].withDraw() * tillDenominations[loop].getDenom();
                sum -= (tillDenominations[loop - 1].deposit() * tillDenominations[loop - 1].getDenom());
                sum=deposit(sum);
                return;
            }
        }

    }

    public void printTill() {
        System.out.println("The Balance is now " + getBalance() + " kr");
        for (TillDenomination loop : tillDenominations) {
            if (loop.getBalance() > 0) {
                loop.printTillDenominations();
            }
        }

    }

    private void setChange(int change) {
        for (Denominations denom : Denominations.values()) {
            addTillDenomination(denom, change);
        }
    }

    private void addTillDenomination(Denominations denom, int change) {
        TillDenomination[] newArray = Arrays.copyOf(tillDenominations, tillDenominations.length + 1);
        newArray[newArray.length - 1] = new TillDenomination(denom.getDenomination(), change);
        tillDenominations = newArray;
    }

    public String[] getDenominationsList() {
        return DENOMINATIONSLIST;
//        return "Till{" + "denominations=" + Arrays.toString(tillDenominations) + '}';
    }

    public int getDenomination(int index) {
        return tillDenominations[index - 1].getDenom();
    }
    //Setters and getters
}