package model;

// Ctrl + Alt + L
public abstract class Products {
    //fields
    // variable name always should start with lo
    private String name;
    private int price;
    private int inStock;
    private int productType;


    //constructors

    public Products(String name, int price, int inStock, int productType) {
        setName(name);
        setPrice(price);
        setInStock(inStock);
        setProductType(productType);
    }

    // methods
    public String examine() {
        return "Name: " + getName() + "\tType: " + getProductType() + "\tprice: " + getPrice() + "\t inStock:" + getInStock();
    }


    public abstract String use();

    // getter/setter

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getInStock() {
        return inStock;
    }

    public void setInStock(int inStock) {
        this.inStock = inStock;
    }

    public int getProductType() {
        return productType;
    }

    public void setProductType(int productType) {
        this.productType = productType;
    }
    // override methods

}
