import java.util.*;

public class Main {
    public static void main(String[] args) {
        // Create a landlord
        Landlord landlord = new Landlord(1);

        // Create some buildings
        Building building1 = new Building(1, 1000.0);
        Building building2 = new Building(2, 2000.0);

        // Create apartments and add to the buildings
        building1.addApartment(new Apartment(500.0));
        building1.addApartment(new Apartment(600.0));
        building1.addApartment(new Apartment(700.0));

        building2.addApartment(new Apartment(800.0));
        building2.addApartment(new Apartment(900.0));

        // Add buildings to the landlord
        landlord.addBuilding(building1);
        landlord.addBuilding(building2);

        // Calculate and print the total profit for the landlord
        System.out.println("Total Profit for Landlord: $" + landlord.calculateTotalProfit());
    }
}
