import java.util.Scanner;

class Day {
    private IntakeNode first;
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Day() {
        first = null;
    }
    public void addIntake(Intake intake) {
        IntakeNode newIntakeNode = new IntakeNode(intake);
        if (first == null) {
            first = newIntakeNode;
        } else {
            IntakeNode current = first;
            while (current.getNext() != null) {
                current = current.getNext();
            }
            current.setNext(newIntakeNode);
        }
    }
    public void printIntakeListing() {
        System.out.println(this.toString());
    }
    public void createIntakes() {
        boolean creating = true;
        Scanner userInput = new Scanner(System.in);
        while (creating) {
            System.out.println("Nombre de la ingesta (-1 para terminar)");
            String dayName = userInput.nextLine();
            if (dayName.equals("-1")) {
                creating = !creating;
            } else {
                Intake intake = new Intake();
                intake.setName(dayName);
                intake.createIntake();
                addIntake(intake);
            }
        }
    }
    @Override
    public String toString() {
        String intakeListing = "";
        IntakeNode current = first;
        while (current != null) {
            intakeListing = intakeListing + current.getIntake().toString() + "\n";
            current = current.getNext();
        }
        return intakeListing;
    }
    public static void main(String[] args) {
        Day monday = new Day();
        monday.createIntakes();
        monday.printIntakeListing();
        monday.deleteIntakes();
        monday.printIntakeListing();
        monday.updateIntakes();
        monday.printIntakeListing();
    }
    public void deleteIntakes() {
        Scanner userInput = new Scanner(System.in);
        System.out.println("Nombrame el nombre de la ingesta que quieres eliminar");
        String intakeName = userInput.nextLine();
        IntakeNode current = first;
        IntakeNode previous = null;
        while (current != null) {
            if (current.getIntake().getName().equalsIgnoreCase(intakeName)) {
                if(current == first){
                    first=current.getNext();
                    break;
                }else{
                    previous=current.getNext();
                }
            }
            previous=current;
            current=current.getNext();
        }
    }
    public void updateIntakes() {
        Scanner userInput = new Scanner(System.in);
        System.out.println("Nombrame el nombre de la ingesta que quieres actualizar");
        String intakeName = userInput.nextLine();
        IntakeNode current = first;
        while(current!=null){
            if (current.getIntake().getName().equalsIgnoreCase(intakeName)) {
                System.out.println("Dime la comida que quieres insertar en "+current.getIntake().getName());
                String foodName = userInput.nextLine();
                current.getIntake().addFood(new Food(foodName));
            }
            current=current.getNext();
        }
    }
}