package prob2B;

public class OrderLine {
    private int orderLineNumber;
    private double price;
    private int qty;

    public OrderLine(int orderLineNumber, double price, int qty) {
        this.orderLineNumber = orderLineNumber;
        this.price = price;
        this.qty = qty;
    }

    public int getOrderLineNumber() {
        return orderLineNumber;
    }

    public double getPrice() {
        return price;
    }

    public int getQty() {
        return qty;
    }
}
