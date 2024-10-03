import java.util.ArrayList;
import java.util.List;

public class Building {
    private int id;
    private List<Apartment> apartments;
    private double maintenanceCost;

    public Building(int id, double maintenanceCost) {
        this.id = id;
        this.apartments = new ArrayList<>();
        this.maintenanceCost = maintenanceCost;
    }

    public void addApartment(Apartment apartment) {
        apartments.add(apartment);
    }

    public double calculateProfit() {
        double totalRent = 0;
        for (Apartment apartment : apartments) {
            totalRent += apartment.getRent();
        }
        return totalRent - maintenanceCost;
    }
}
