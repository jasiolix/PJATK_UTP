package Task0601_SortingData;

public class Purchase {
    private final Customer customer;
    private final String name;
    private final double price;
    private final double quantity;

    public Purchase(Customer customer, String name, double price, double quantity) {
        this.customer = customer;
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public Customer getCustomer() {
        return customer;
    }

    public double getQuantity() {
        return quantity;
    }

    @Override
    public String toString() {
        return getCustomer().getId()+";"
                + getCustomer().getName()+";"
                + getName()+";"
                + getPrice()+";"
                + getQuantity();
    }

}
