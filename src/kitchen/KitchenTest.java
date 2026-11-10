package kitchen;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import kitchen.person.Chef;
import kitchen.meals.Meal;
import kitchen.meals.MealType;

public class KitchenTest {

    @Test
    void testEmptyKitchen() {
        Kitchen kitchen = new Kitchen(new Chef[]{});

        assertTrue(kitchen.getFinishedMeals().isEmpty());
    }

    @Test
    void testTooManyChefs() {
        Chef[] chefs = {
            new Chef("Alex", MealType.MEAT),
            new Chef("Bob", MealType.FISH),
            new Chef("Anna", MealType.PASTRY),
            new Chef("John", MealType.SAUCE)
        };

        assertThrows(IllegalArgumentException.class,
            () -> new Kitchen(chefs));
    }

    @Test
    void testCookOneMeal() {
        Chef chef = new Chef("Alex", MealType.MEAT);
        Kitchen kitchen = new Kitchen(new Chef[]{chef});

        Meal meal = new Meal("Steak", MealType.MEAT);
        kitchen.cookMeal(new Meal[]{meal});

        assertTrue(meal.isFinished());
        assertEquals(1, kitchen.getFinishedMeals().size());
    }

    @Test
    void testCannotCookMeal() {
        Chef chef = new Chef("Alex", MealType.MEAT);
        Kitchen kitchen = new Kitchen(new Chef[]{chef});

        Meal meal = new Meal("Salmon", MealType.FISH);
        kitchen.cookMeal(new Meal[]{meal});

        assertFalse(meal.isFinished());
        assertEquals(0, kitchen.getFinishedMeals().size());
    }

    @Test
    void testMultipleMeals() {
        Chef chef1 = new Chef("Alex", MealType.MEAT);
        Chef chef2 = new Chef("Bob", MealType.FISH);

        Kitchen kitchen = new Kitchen(new Chef[]{chef1, chef2});

        Meal meat = new Meal("Steak", MealType.MEAT);
        Meal fish = new Meal("Salmon", MealType.FISH);
        Meal pastry = new Meal("Cake", MealType.PASTRY);

        kitchen.cookMeal(new Meal[]{meat, fish, pastry});

        assertTrue(meat.isFinished());
        assertTrue(fish.isFinished());
        assertFalse(pastry.isFinished());

        assertEquals(2, kitchen.getFinishedMeals().size());
    }
}