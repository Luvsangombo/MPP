package lesson7.labs.prob3;

import java.util.*;

public class FoodDeliverySystem {
    public static void main(String[] args) {
        // Create an ArrayList of Restaurants
        ArrayList<Restaurant> restaurants = new ArrayList<>();
        restaurants.add(new Restaurant("Sushi Palace", 5.0, 10.0));
        restaurants.add(new Restaurant("Pizza Corner", 3.5, 5.0));
        restaurants.add(new Restaurant("Burger World", 4.0, 7.5));

        // Create an ArrayList of Customers
        ArrayList<Customer> customers = new ArrayList<>();
        customers.add(new Customer("John Doe", 60));
        customers.add(new Customer("Jane Smith", 40));
        customers.add(new Customer("Bob Johnson", 80));

        // Print welcome message
        System.out.println("Welcome to the Food Delivery System!");
        /* Complete the part */
        Random random = new Random();
        for (Restaurant restaurant : restaurants) {
            for (Customer customer : customers) {
                double orderAmount = 50 + (150 * random.nextDouble());

                double deliveryCharge = restaurant.calculateDeliveryCharge(restaurant.getLocalDistance());

                boolean isLoyal = customer.isLoyalCustomer();
                String loyaltyStatus = isLoyal ? "Loyal Customer" : "New Customer";

                double discount = restaurant.calculateDiscount(orderAmount);
                double totalAfterDiscount = orderAmount - discount + deliveryCharge;

                System.out.printf("Processing order for Customer: %s at Restaurant: %s\n", customer.getCustomerName(), restaurant.getRestaurantName());
                System.out.println("Customer Loyalty Status: " + loyaltyStatus);

                RestaurantInterface.printFormattedData(restaurant.getRestaurantName(), customer.getCustomerName(), orderAmount,
                        deliveryCharge, discount, totalAfterDiscount);
            }
        }
    }
}
