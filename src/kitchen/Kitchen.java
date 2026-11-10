package kitchen;

import kitchen.person.Chef;
import kitchen.meals.Meal;
import java.util.ArrayList;

public class Kitchen {
    private Chef[] chefs;
    private ArrayList<Meal> finishedMeals;

    public Kitchen(Chef[] chefs) {
        if (chefs.length > 3) {
            throw new IllegalArgumentException("Too many chefs");
        }
        this.chefs = chefs;
        this.finishedMeals = new ArrayList<>();
    }

    public ArrayList<Meal> getFinishedMeals() {
        return finishedMeals;
    }

    private ArrayList<Meal> getCookableMeals(Meal[] mealsToBeCooked) {
        ArrayList<Meal> cookableMeals = new ArrayList<>();

        for (Meal meal : mealsToBeCooked) {
            for (Chef chef : chefs) {
                if (chef.canCookMeal(meal)) {
                    cookableMeals.add(meal);
                    break;
                }
            }

        }

        return cookableMeals;
    }
    public void cookMeal(Meal[] mealsToBeCooked) {
        ArrayList<Meal> cookableMeals = getCookableMeals(mealsToBeCooked);
        for(Meal meal : cookableMeals) {
            for(Chef chef : chefs) {
                if(chef.canCookMeal(meal)) {
                    chef.cookMeal(meal);
                    finishedMeals.add(meal);
                    break;
                }
            }
        }
    }

}