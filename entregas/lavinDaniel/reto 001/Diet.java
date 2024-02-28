class Diet {
    private DayNode first;

    public Diet() {
        first = null;
    }

    public void addDay(Day day){
        DayNode newDayNode = new DayNode(day);
        if (first == null){
            first = newDayNode;
        } else {
            DayNode current = first;
            while(current.getNext()!=null){
                current = current.getNext();
            }
            current.setNext(newDayNode);
        }
    }

    public void updateDay(Day day, int index) {
        DayNode current = first;
        int count = 0;
        while (current != null) {
            if (count == index) {
                current.setDay(day);
                break;
            }
            current = current.getNext();
            count++;
        }
    }

    public void deleteDay(int index) {
        if (index == 0) {
            first = first.getNext();
        } else {
            DayNode current = first;
            int count = 0;
            while (current != null) {
                if (count == index - 1) {
                    current.setNext(current.getNext().getNext());
                    break;
                }
                current = current.getNext();
                count++;
            }
        }
    }

    @Override
    public String toString() {
        String daysListing = "";
        DayNode current = first;
        while (current != null) {
            daysListing = daysListing + current.getDay().toString() + "\n";
            current = current.getNext();
        }
        return daysListing;
    }

    public static void main(String[] args) {
        Diet diet = new Diet();
        Day monday = new Day();
        Intake breakfast = new Intake();
        breakfast.addFood(new Food("Eggs"));
        breakfast.addFood(new Food("Bacon"));
        breakfast.addFood(new Food("Toast"));
        monday.addIntake(breakfast);
        diet.addDay(monday);
        System.out.println("Before update and delete:");
        System.out.println(diet.toString());

        Day tuesday = new Day();
        Intake lunch = new Intake();
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