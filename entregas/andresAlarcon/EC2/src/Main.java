public class Main {
    public static void main(String[] args) {
        // Test for Intake
        System.out.println("Tests for Intake:");
        Intake breakfast = new Intake();
        breakfast.addFood(new Food("Eggs"));
        breakfast.addFood(new Food("Bacon"));
        breakfast.addFood(new Food("Toast"));
        System.out.println("Before update and delete:");
        System.out.println(breakfast.toString());

        breakfast.updateFood(new Food("Pancakes"), 1);
        System.out.println("After update:");
        System.out.println(breakfast.toString());

        breakfast.deleteFood(0);
        System.out.println("After delete:");
        System.out.println(breakfast.toString());

        // Test for Day
        System.out.println("\nTests for Day:");
        Day monday = new Day();
        breakfast = new Intake();
        breakfast.addFood(new Food("Eggs"));
        breakfast.addFood(new Food("Bacon"));
        breakfast.addFood(new Food("Toast"));
        monday.addIntake(breakfast);
        System.out.println("Before update and delete:");
        System.out.println(monday.toString());

        Intake lunch = new Intake();
        lunch.addFood(new Food("Sandwich"));
        lunch.addFood(new Food("Chips"));
        lunch.addFood(new Food("Apple"));
        monday.updateIntake(lunch, 0);
        System.out.println("After update:");
        System.out.println(monday.toString());

        monday.deleteIntake(0);
        System.out.println("After delete:");
        System.out.println(monday.toString());

        // Test for Diet
        System.out.println("\nTests for Diet:");
        Diet diet = new Diet();
        monday = new Day();
        breakfast = new Intake();
        breakfast.addFood(new Food("Eggs"));
        breakfast.addFood(new Food("Bacon"));
        breakfast.addFood(new Food("Toast"));
        monday.addIntake(breakfast);
        diet.addDay(monday);
        System.out.println("Before update and delete:");
        System.out.println(diet.toString());

        Day tuesday = new Day();
        lunch = new Intake();
        lunch.addFood(new Food("Sandwich"));
        lunch.addFood(new Food("Chips"));
        lunch.addFood(new Food("Apple"));
        tuesday.addIntake(lunch);
        diet.updateDay(tuesday, 0);
        System.out.println("After update:");
        System.out.println(diet.toString());

        diet.deleteDay(0);
        System.out.println("After delete:");
        System.out.println(diet.toString());
    }
}
