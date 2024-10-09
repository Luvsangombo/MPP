package lesson7.labs.prob3;

public class Restaurant implements RestaurantInterface{
    public String restaurantName;
    public double baseDeliveryCharge;
    public double localDistance;
    Restaurant(String restaurantName, double baseDeliveryCharge, double locationDistance) {
        this.restaurantName = restaurantName;
        this.baseDeliveryCharge = baseDeliveryCharge;
        this.localDistance = locationDistance;
    }

    public double calculateDeliveryCharge(double distance) {
        return baseDeliveryCharge + (distance * 0.05);
    }

    @Override
    public String getRestaurantName() {
        return restaurantName;
    }

    public double getLocalDistance() {
        return localDistance;
    }
}
