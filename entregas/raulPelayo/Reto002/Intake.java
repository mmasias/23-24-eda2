class Intake {
    private ArrayList<Food> foods;
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Intake() {
        super();
        foods = new ArrayList<>();
    }

    public void addFood(Food food) {
        foods.add(food);
    }

    public void printFoodListing() {
        System.out.println(this.toString());
    }

    public void createIntake() {
        boolean creating = true;
        Scanner userInput = new Scanner(System.in);
        while (creating) {
            System.out.println("Nombre del alimento (-1 para terminar)");
            String foodName = userInput.nextLine();
            if (foodName.equals("-1")) {
                creating = false;
            } else {
                Food food = new Food(foodName);
                addFood(food);
            }
        }
    }

    @Override
    public String toString() {
        StringBuilder foodListing = new StringBuilder(name + "\n");
        for (Food food : foods) {
            foodListing.append(food.toString()).append("\n");
        }
        return foodListing.toString();
    }

    public static void main(String[] args) {
        Intake breakfast = new Intake();
        breakfast.createIntake();
        breakfast.printFoodListing();
    }
}