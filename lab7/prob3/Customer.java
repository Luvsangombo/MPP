package lesson7.labs.prob3;

public class Customer implements CustomerInterface {
    private String customerName;
    private Integer loyaltyPoints;
    public Customer(String customerName, int loyaltyPoints) {
        this.customerName = customerName;
        this.loyaltyPoints = loyaltyPoints;
    }

    public String getCustomerName() {
        return customerName;
    }

    public Integer getLoyaltyPoints() {
        return loyaltyPoints;
    }

    public boolean isLoyalCustomer() {
        return isLoyalCustomer(loyaltyPoints);
    }
}
