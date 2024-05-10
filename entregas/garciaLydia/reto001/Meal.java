package entregas.garciaLydia.reto001;

public class Meal {
    private DayNode first;

    public Meal() {
        first = null;
    }

    public void addDay(Day day) {
        DayNode newNode = new DayNode(day);
        if (first == null) {
            first = newNode;
        } else {
            DayNode current = first;
            while (current.getNext() != null) {
                current = current.getNext();
            }
            current.setNext(newNode);
        }
    }

    public void updateDay(int index, Day newDay) {
        DayNode current = first;
        int count = 0;
        while (current != null) {
            if (count == index) {
                current.setDay(newDay);
                break;
            }
            current = current.getNext();
            count++;
        }
    }

    public void deleteDay(int index) {
        if (index < 0) {
            System.out.println("Índice inválido.");
            return;
        }
        if (index == 0) {
            first = first.getNext();
            return;
        }
        DayNode prevNode = null;
        DayNode current = first;
        int count = 0;
        while (current != null && count != index) {
            prevNode = current;
            current = current.getNext();
            count++;
        }
        if (current == null) {
            System.out.println("Índice fuera de rango.");
            return;
        }
        prevNode.setNext(current.getNext());
    }

    @Override
    public String toString() {
        StringBuilder mealPlanListing = new StringBuilder();
        DayNode current = first;
        while (current != null) {
            mealPlanListing.append(current.getDay()).append("\n");
            current = current.getNext();
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