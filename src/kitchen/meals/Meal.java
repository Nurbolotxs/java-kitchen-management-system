package kitchen.meals;

public class Meal {
    private final String name;
    private final MealType type;
    private boolean isFinished;

    public Meal(String name, MealType type) {
        if (name == null || name.isEmpty() || type == null) {
            throw new IllegalArgumentException("Invalid name");
        }
        this.name = name;
        this.type = type;
        this.isFinished = false;
    }
    public String getName() {
        return name;
    }
    public MealType getType(){
        return type;
    }
    public boolean isFinished(){
        return isFinished;
    }
    public void setFinished(boolean isFinished) {
        this.isFinished = isFinished;
    }
}