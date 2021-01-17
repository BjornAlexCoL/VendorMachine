package model;


public class Drinks extends Products {
    String volume;

    public Drinks(String name, int price, int inStock, int productType, String volume) {
        super(name, price, inStock, productType);
        this.setVolume(volume);
    }

    public String examine() {
        return getName() + " " + getVolume() + "cl " + "at cost " + getPrice() + " kr";
    }

    public String getVolume() {
        return volume;
    }

    public void setVolume(String volume) {
        this.volume = volume;
    }


    @Override
    public String use() {
        return "You drink " + getVolume() + "cl of " + this.getName();
    }

    @Override
    public String toString() {
        return getName() + " " + getVolume() + " " + getPrice() + " " + getProductType();
    }

}
