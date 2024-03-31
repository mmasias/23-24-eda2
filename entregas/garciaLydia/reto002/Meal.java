package entregas.garciaLydia.reto002;

import java.util.ArrayList;

public class Meal {
    private ArrayList<Day> days;

    public Meal() {
        days = new ArrayList<>();
    }

    public void addDay(Day day) {
        days.add(day);
    }

    public void updateDay(int index, Day newDay) {
        if (index >= 0 && index < days.size()) {
            days.set(index, newDay);
        } else {
            System.out.println("Índice inválido.");
        }
    }

    public void deleteDay(int index) {
        if (index >= 0 && index < days.size()) {
            days.remove(index);
        } else {
            System.out.println("Índice inválido.");
        }
    }

    @Override
    public String toString() {
        StringBuilder mealPlanListing = new StringBuilder();
        for (Day day : days) {
            mealPlanListing.append(day.toString()).append("\n");
        }
        return mealPlanListing.toString();
    }

    public static void main(String[] args) {
        Meal mealPlan = new Meal();
        Day monday = new Day();
        mealPlan.addDay(monday);
        System.out.println("Antes de la actualización:");
        System.out.println(mealPlan.toString());
        Day updatedMonday = new Day();
        mealPlan.updateDay(0, updatedMonday);
        System.out.println("Después de la actualización:");
        System.out.println(mealPlan.toString());
        mealPlan.deleteDay(0);
        System.out.println("Después de la eliminación:");
        System.out.println(mealPlan.toString());
    }
}