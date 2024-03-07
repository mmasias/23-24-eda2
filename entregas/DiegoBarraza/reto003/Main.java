package entregas.DiegoBarraza.reto003;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        GestionDocumentos biblioteca = new GestionDocumentos();
        Scanner scanner = new Scanner(System.in);
        ControladorDocumento controladorDocumento = new ControladorDocumento(biblioteca, scanner);
        
        int opcion;
        do {
            System.out.println("\nMenú:");
            System.out.println("1. Agregar documento");
            System.out.println("2. Editar documento");
            System.out.println("3. Leer documento");
            System.out.println("4. Eliminar documento");
            System.out.println("5. Salir");
            System.out.print("Ingrese el número de la opción que desea realizar: ");
            
            opcion = scanner.nextInt();
            scanner.nextLine(); 
            
            switch (opcion) {
                case 1:
                    controladorDocumento.agregarDocumento();
                    break;
                case 2:
                    controladorDocumento.editarDocumento();
                    break;
                case 3:
                    controladorDocumento.leerDocumento();
                    break;
                case 4:
                    controladorDocumento.eliminarDocumento();
                    break;
                case 5:
                    System.out.println("Saliendo del programa...");
                    break;
                default:
                    System.out.println("Opción no válida. Intente de nuevo.");
            }
        } while (opcion != 5);
        
        scanner.close();
    }
}
