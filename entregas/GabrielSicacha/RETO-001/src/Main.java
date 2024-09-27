import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        //meramente ejemplos, aun a terminar

        Scanner scanner = new Scanner(System.in);

        Diet diet0 = new Diet("Gabriel");
        diet0.addDay(new Day("21/02"));
        diet0.getFirst().getDay().addIntake(new Intake("Almuerzo"));
        diet0.getFirst().getDay().getFirst().getIntake().addFood(new Food("Cerdo"));
        diet0.getFirst().getDay().getFirst().getIntake().addFood(new Food("Arroz"));
        diet0.getFirst().getDay().getFirst().getIntake().addFood(new Food("Esparragos"));
        diet0.getFirst().getDay().getFirst().getIntake().addFood(new Food("Oreos"));
        diet0.getFirst().getDay().getFirst().getIntake().deleteFood("Oreos");
        diet0.getFirst().getDay().addIntake(new Intake("Cena"));
        diet0.getFirst().getDay().getFirst().getNext().getIntake().addFood(new Food("Pancakes"));
        diet0.getFirst().getDay().getFirst().getNext().getIntake().addFood(new Food("Miel"));
        diet0.getFirst().getDay().getFirst().getNext().getIntake().addFood(new Food("Leche"));
        System.out.println("Dietas V2");
        System.out.println("__________________________________________________");
        System.out.println("1. Crear dieta");
        System.out.println("2. Ver dieta Previa");
        System.out.println("3. Salir");
        int r = scanner.nextInt();
        switch (r){
            case 1:
                System.out.println("crear dieta");
                Diet diet1 = new Diet(scanner.next());
                break;
            case 2:
                diet0.readDays();
                break;
            case 3:
                System.exit(0);
        }
    }

}