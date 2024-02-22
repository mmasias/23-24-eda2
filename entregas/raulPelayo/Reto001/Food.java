public class Food implements Comparable<Food> {
    private String name;
    private int grams;
    
    public Food(String name, int grams) {
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
        if (this.getName().compareTo(otherFood.getName()) > 0) {
            return 1;
        } else if (this.getName().compareTo(otherFood.getName()) < 0) {
            return -1;
        } else {
            return 0;
        }
    }
}