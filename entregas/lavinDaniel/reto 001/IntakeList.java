class IntakeList {
    private FoodNode first;

    public IntakeList() {
        first = null;
    }

    public void addFood(Food food) {
        FoodNode newFoodNode = new FoodNode(food);
        if (first == null) {
            first = newFoodNode;
        } else {
            FoodNode current = first;
            while (current.getNext() != null) {
                current = current.getNext();
            }
            current.setNext(newFoodNode);
        }
    }

    public void printFoodListing() {
        System.out.println(this.toString());
    }

    public void updateFood(String oldName, String newName) {
        FoodNode current = first;
        while (current != null) {
            if (current.getFood().getName().equals(oldName)) {
                current.getFood().setName(newName);
                System.out.println("Alimento actualizado con éxito.");
                return;
            }
            current = current.getNext();
        }
        System.out.println("Alimento no encontrado.");
    }

    public void deleteFood(String name) {
        if (first == null) {
            System.out.println("La lista de alimentos está vacía.");
            return;
        }

        if (first.getFood().getName().equals(name)) {
            first = first.getNext();
            System.out.println("Alimento eliminado con éxito.");
            return;
        }

        FoodNode current = first;
        while (current.getNext() != null && !current.getNext().getFood().getName().equals(name)) {
            current = current.getNext();
        }

        if (current.getNext() == null) {
            System.out.println("Alimento no encontrado.");
        } else {
            current.setNext(current.getNext().getNext());
            System.out.println("Alimento eliminado con éxito.");
        }
    }

    @Override
    public String toString() {
        StringBuilder foodListing = new StringBuilder();
        FoodNode current = first;
        while (current != null) {
            foodListing.append(current.getFood().toString()).append("\n");
            current = current.getNext();
        }
        return foodListing.toString();
    }
}
