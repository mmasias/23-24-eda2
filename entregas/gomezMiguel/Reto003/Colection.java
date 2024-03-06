import java.util.Scanner;

public class Colection{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean SystemOn = true;
        while(SystemOn){
        System.out.println("¿Qué quieres hacer?");
        System.out.println("1. Crear un documento");
        System.out.println("2. Modificar un documento");
        System.out.println("3. Eliminar un documento");
        System.out.println("4. Ver un documento");
        System.out.println("5. Salir");
        String option = scanner.nextLine();
        
        switch(option){
            case "1":
                System.out.println("Creando un documento");
                break;
            case "2":
                System.out.println("Modificando un documento");
                break;
            case "3":
                System.out.println("Eliminando un documento");
                break;
            case "4":
                System.out.println("Viendo un documento");
                break;
            case "5":
                System.out.println("Saliendo del sistema");
                SystemOn = false;
                break;
            default:
                System.out.println("Opción no válida");
                break;
        }
        
        }
        
    }
}
