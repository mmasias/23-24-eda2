class IntakeList {
    private ArrayList<Food> foods;

    public IntakeList() {
        this.foods = new ArrayList<>();
    }

    public void addFood(Food food) {
        foods.add(food);
    }

    public void printFoodListing() {
        System.out.println(this.toString());
    }

    public void updateFood(String oldName, String newName) {
        for (Food food : foods) {
            if (food.getName().equals(oldName)) {
                food.setName(newName);
                System.out.println("Alimento actualizado con éxito.");
                return;
            }
        }
        System.out.println("Alimento no encontrado.");
    }

    public void deleteFood(String name) {
        for (Food food : foods) {
            if (food.getName().equals(name)) {
                foods.remove(food);
                System.out.println("Alimento eliminado con éxito.");
                return;
            }
        }
        System.out.println("Alimento no encontrado.");
    }

    @Override
    public String toString() {
        StringBuilder foodListing = new StringBuilder();
        for (Food food : foods) {
            foodListing.append(food.toString()).append("\n");
        }
        return foodListing.toString();
    }
}