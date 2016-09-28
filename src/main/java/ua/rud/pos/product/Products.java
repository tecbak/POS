package ua.rud.pos.product;

public enum Products implements Product {
    TEA("Tea", 25),
    COFFEE("Coffee", 35),
    JUICE("Juice", 45);

    private final long price;
    private final String description;

    /*Constructor*/
    Products(String description, long price) {
        this.description = description;
        this.price = price;
    }

    /*Getters*/
    public long getPrice() {
        return price;
    }

    public String getDescription() {
        return description;
    }

    @Override
    public String toString() {
        return description + " " + price;
    }
}
