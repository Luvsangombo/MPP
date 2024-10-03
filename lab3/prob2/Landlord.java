import java.util.ArrayList;
import java.util.List;

public class Landlord {
    private int id;
    private List<Building> buildings;

    public Landlord(int id) {
        this.id = id;
        this.buildings = new ArrayList<>();
    }

    public void addBuilding(Building building) {
        buildings.add(building);
    }

    public double calculateTotalProfit() {
        double totalProfit = 0;
        for (Building building : buildings) {
            totalProfit += building.calculateProfit();
        }
        return totalProfit;
    }

}
