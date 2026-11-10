package kitchen.person;

import kitchen.meals.Meal;
import kitchen.meals.MealType;

public class Chef {
    private static final int payPerFinishedMeals = 5000;
    private final String name;
    private final MealType specialty;
    private int finishedMeals;

    public Chef(String name, MealType specialty) {
        if (name == null || name.isEmpty() || specialty == null) {
            throw new IllegalArgumentException("Invalid name");
        }
        this.name = name;
        this.specialty = specialty;
    }

    public boolean canCookMeal(Meal meal) {
        if (meal.getType() == specialty) {
            return true;
        }
        return false;
    }

    public void cookMeal(Meal meal) {
        if (canCookMeal(meal)) {
            meal.setFinished(true);
            finishedMeals++;
        }
    }

    private int getWage() {
        return finishedMeals * payPerFinishedMeals;
    }

    @Override
    public String toString() {
        return "Chef " + name + " specializes in " + specialty + " with current wage: " + getWage();
    }

}