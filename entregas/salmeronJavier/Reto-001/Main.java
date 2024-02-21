public class Main {
    public static void main(String[] args) {
        Food apple = new Food("Apple");
        Food banana = new Food("Banana");
        Food pineapple = new Food("Pineapple");
        Food carrot = new Food("Carrot");

        Intake breakfast = new Intake("Breakfast");
        breakfast.addFood(apple);
        breakfast.addFood(banana);
        breakfast.addFood(pineapple);
        breakfast.addFood(carrot);

        System.out.println("Breakfast intake:");
        breakfast.printFoodListing();

        breakfast.updateFood("Banana", "Blueberry");
        System.out.println("Breakfast intake:");
        breakfast.printFoodListing();

        breakfast.deleteFood("Carrot");
        System.out.println("Breakfast intake:");
        breakfast.printFoodListing();

        Day monday = new Day("Monday");
        monday.addIntake(breakfast);

        System.out.println("Monday Intake:");
        monday.printIntakeListing();

        Diet myDiet = new Diet();
        myDiet.addDay(monday);

        System.out.println("Diet:");
        myDiet.printDayListing();

    }
}
