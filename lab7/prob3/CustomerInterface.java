package lesson7.labs.prob3;

public interface CustomerInterface {
    default Boolean isLoyalCustomer(int loyaltyPoints){
        return loyaltyPoints > 50;
    };
}
