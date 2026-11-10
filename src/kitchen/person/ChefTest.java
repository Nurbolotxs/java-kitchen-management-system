package kitchen.person;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import kitchen.meals.Meal;
import kitchen.meals.MealType;

public class ChefTest {

    @Test
    void testCanCookMeal() {
        Chef chef = new Chef("Alex", MealType.MEAT);
        Meal meal = new Meal("Steak", MealType.MEAT);
        assertTrue(chef.canCookMeal(meal));
    }

    @Test
    void testCannotCookMeal() {
        Chef chef = new Chef("Alex", MealType.MEAT);
        Meal meal = new Meal("Salmon", MealType.FISH);
        assertFalse(chef.canCookMeal(meal));
    }

    @Test
    void testCookMeal() {
        Chef chef = new Chef("Alex", MealType.MEAT);
        Meal meal = new Meal("Steak", MealType.MEAT);

        assertFalse(meal.isFinished());
        chef.cookMeal(meal);
        assertTrue(meal.isFinished());
    }

    @Test
    void testCannotCookDifferentType() {
        Chef chef = new Chef("Alex", MealType.MEAT);
        Meal meal = new Meal("Salmon", MealType.FISH);

        chef.cookMeal(meal);
        assertFalse(meal.isFinished());
    }

    @Test
    void testWage() {
        Chef chef = new Chef("Alex", MealType.MEAT);
        Meal meal = new Meal("Steak", MealType.MEAT);

        chef.cookMeal(meal);

        assertEquals(
            "Chef Alex specializes in MEAT with current wage: 5000",
            chef.toString()
        );
    }
}