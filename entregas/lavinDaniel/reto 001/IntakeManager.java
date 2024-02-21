class IntakeManager {
    private IntakeList intakeList;

    public IntakeManager() {
        this.intakeList = new IntakeList();
    }

    public void createIntake() {
        boolean creating = true;
        Scanner userInput = new Scanner(System.in);
        while (creating) {
            System.out.println("Nombre del alimento (-1 para terminar)");
            String foodName = userInput.nextLine();
            if (foodName.equals("-1")) {
                creating = !creating;
            } else {
                Food food = new Food(foodName);
                intakeList.addFood(food);
            }
        }
    }

    public void performCRUDOperations() {
        intakeList.printFoodListing();

        // Ejemplo de uso de operaciones CRUD
        intakeList.updateFood("Pan", "Pan Integral");
        intakeList.deleteFood("Manzana");
        intakeList.printFoodListing();
    }
}