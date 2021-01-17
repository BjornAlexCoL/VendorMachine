package model;

import java.util.Objects;

public class Foods extends Products {
    int calories;

    public Foods(String name, int price, int inStock, int productType, int calories) {
        super(name, price, inStock, productType);
        setCalories(calories);
    }

    public String examine() {
        return this.getName() + " " + "at cost " + getPrice() + " kr with " + getCalories() + " kcal";

    }

    public int getCalories() {
        return calories;
    }

    public void setCalories(int calories) {
        this.calories = calories;
    }

    @Override
    public String use() {
        return "You eat " + getName() + " with " + getCalories() + " kcal";
    }
    @Override
    public String toString() {
        return  getName() + " " + getCalories() + " "+getPrice()+" "+getProductType();
    }

}

