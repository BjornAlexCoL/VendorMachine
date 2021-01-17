package model;

public class Snacks extends Products {
    int sugarPercent;

    public Snacks(String name, int price, int inStock, int productType, int sugarPercent) {
        super(name, price, inStock, productType);
        setSugarPercent(sugarPercent);
    }

    public String examine() {
        return this.getName() + " " + "at cost " + getPrice() + " kr with " + getSugarPercent() + "% sugar";

    }

    public int getSugarPercent() {
        return sugarPercent;
    }

    public void setSugarPercent(int sugarPercent) {
        this.sugarPercent = sugarPercent;
    }

    @Override
    public String use() {
        return "You eat " + getName() + " with " + getSugarPercent()+"% sugar";
    }

    @Override
    public String toString() {
        return getName() + " " + getSugarPercent() + " " + getPrice() + " " + getProductType();
    }
}
