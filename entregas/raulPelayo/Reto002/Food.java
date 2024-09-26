import java.util.ArrayList;

public class Food implements Comparable<Food> {
    private String name;
    private int grams;
    
    public Food(String name, int grams) {
        super();
        this.name = name;
        this.grams = grams;
    }
    
    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public int getGrams() {
        return grams;
    }
    
    public void setGrams(int grams) {
        this.grams = grams;
    }
   
    @Override
    public int compareTo(Food otherFood) {
        return this.getName().compareTo(otherFood.getName());
    }

    public static void main(String[] args) {
        ArrayList<Food> foods = new ArrayList<>();

        foods.add(new Food("Manzana", 100));
        foods.add(new Food("Plátano", 150));
        foods.add(new Food("Naranja", 120));

        for (Food food : foods) {
            System.out.println("Alimento: " + food.getName() + ", Gramos: " + food.getGrams());
        }
    }
}