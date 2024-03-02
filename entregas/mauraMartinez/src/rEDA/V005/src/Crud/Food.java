package Crud;

import java.util.ArrayList;
import java.util.List;

class Food {
    private String name;
    private static List<Food> foodList = new ArrayList<>();

    public Food(String name) {
        this.name = name;
        foodList.add(this);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "]> Alimento: " + name;
    }

    public static List<Food> getFoodList() {
        return foodList;
    }
}
