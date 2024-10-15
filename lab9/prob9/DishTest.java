import java.util.List;
import java.util.Optional;

public class DishTest {

    public static void main(String[] args) {

        // Task (a): Is there any Vegetarian meal available? (return type boolean)
        boolean isVegetarianAvailable = Dish.menu.stream()
                .anyMatch(Dish::isVegetarian);
        System.out.println("Is there any vegetarian meal available? " + isVegetarianAvailable);

        // Task (b): Is there any healthy menu having calories less than 1000? (return
        // type boolean)
        boolean isHealthyMenuAvailable = Dish.menu.stream()
                .anyMatch(dish -> dish.getCalories() < 1000);
        System.out.println("Is there any healthy menu with calories less than 1000? " + isHealthyMenuAvailable);

        // Task (c): Is there any unhealthy menu having calories greater than 1000?
        // (return type boolean)
        boolean isUnhealthyMenuAvailable = Dish.menu.stream()
                .anyMatch(dish -> dish.getCalories() > 1000);
        System.out.println("Is there any unhealthy menu with calories greater than 1000? " + isUnhealthyMenuAvailable);

        // Task (d): Find and return the first item for the type of MEAT (return type
        // Optional<Dish>)
        Optional<Dish> firstMeatDish = Dish.menu.stream()
                .filter(dish -> dish.getType() == Dish.Type.MEAT)
                .findFirst();
        System.out.println("First MEAT dish: " + firstMeatDish);

        // Task (e): Calculate total calories in the menu using reduce (return type int)
        int totalCalories = Dish.menu.stream()
                .map(Dish::getCalories)
                .reduce(0, Integer::sum);
        System.out.println("Total calories in the menu: " + totalCalories);

        // Task (f): Calculate total calories in the menu using method references
        // (return type int)
        int totalCaloriesMethodRef = Dish.menu.stream()
                .mapToInt(Dish::getCalories)
                .sum();
        System.out.println("Total calories using method references: " + totalCaloriesMethodRef);
    }
}
