
import java.util.Scanner;

class Day {
    private IntakeNode first;

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
    public void deleteIntake(){
        Scanner sc=new Scanner(System.in);
        System.out.println("¿Que ingesta quieres borrar?");
       String ingesta= sc.next();
       IntakeNode current=first;
        IntakeNode previous=null;
        while (current!=null){
            if(current.getIntake().getName().equalsIgnoreCase(ingesta)){
                if (current==first){
                    first=current.getNext();
                }else {
                    previous.setNext(current.getNext());

                }
            }
            previous=current;
            current=current.getNext();
        }
    }
    public void update(){
        Scanner sc=new Scanner(System.in);
        System.out.println("Inserta la ingesta que desea");
        String ingesta= sc.nextLine();
        IntakeNode n=first;
        while (n!=null){
            if(n.getIntake().getName().equalsIgnoreCase(ingesta)){
                System.out.println("Inserta el alimento que desa insertar");
                String alimento= sc.nextLine();
                n.getIntake().addFood(new Food(alimento));

            }
            n=n.getNext();
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
        monday.deleteIntake();
        monday.printIntakeListing();
        monday.update();
        monday.printIntakeListing();
    }
}
