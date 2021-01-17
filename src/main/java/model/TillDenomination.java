package model;

public class TillDenomination {
    private int denom;
    private int amount;

    public TillDenomination() {
    }

    public TillDenomination(int denom, int amount) {
        this.denom = denom;
        this.amount = amount;
    }

    public int deposit() {
        return deposit(1);
    }

    public int deposit(int amountToAdd) {
        if (amountToAdd < 1) {
            System.out.println("Depositvalue to low");
            return 0;
        }
        this.amount += amountToAdd;
        return amountToAdd;
    }

    public int getBalance() {
        return denom * amount;
    }

    public void printTillDenominations() {
        System.out.println(amount + " of " + denom + " kr" + " (" + getBalance() + " kr)");
    }

    public int withDraw() {
        return withDraw(1);
    }

    public int withDraw(int amountToWithDraw) {
        if ((amountToWithDraw <= this.amount && amountToWithDraw > 0)) {
            this.amount -= amountToWithDraw;
            return amountToWithDraw;
        }
        if ((amountToWithDraw > this.amount)) {
            amountToWithDraw = this.amount;
            this.amount = 0;
            return amountToWithDraw;
        }

        return 0;
    }
    //getters and setters
    public int getAmount(){ return this.amount; }

    public int getDenom() {
        return denom;
    }

    @Override
    public String toString() {
        return "TillDenomination{" + "denom=" + ", amount=" + amount + '}';
    }

}
