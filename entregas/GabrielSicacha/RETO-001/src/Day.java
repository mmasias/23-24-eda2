import java.util.Scanner;

public class Day {
    String date;
    IntakeNode first;

    public Day(String date){
        this.date = date;
        this.first = null;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public IntakeNode getFirst() {
        return first;
    }

    public void setFirst(IntakeNode first) {
        this.first = first;
    }

    public void addIntake(Intake intake){
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

    public void deleteIntake(String intakeName){
        IntakeNode iterator=this.first;
        while ((iterator.getNext().getIntake()!=null)||(iterator.getNext().getIntake().getName().equals(intakeName))){
            iterator=iterator.getNext();
        }
        if (iterator.getIntake()!=null){
            iterator.setNext(iterator.getNext().getNext());
        }
    }

    public void editIntake(String intakeName){
        IntakeNode iterator=this.first;
        while ((iterator.getNext().getIntake()!=null)||(iterator.getNext().getIntake().getName().equals(intakeName))){
            iterator=iterator.getNext();
        }
        if (iterator.getIntake()!=null){
            Scanner scanner = new Scanner(System.in);
            String newName = scanner.nextLine();
            iterator.getIntake().setName(newName);
        }
    }

    public void readIntakeListing() {
        System.out.println(this.toString());
    }
    public String toString() {
        String intakeListing = "";
        IntakeNode current = first;
        while (current != null) {
            intakeListing = intakeListing + current.getIntake().toString() + "\n";
            current = current.getNext();
        }
        return intakeListing;
    }
}
