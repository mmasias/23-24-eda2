package Model;

import java.util.Scanner;

public class App {
    public Option options;
    public boolean isAppRunning = true;
    Scanner userInput = new Scanner(System.in); 

    do {
        System.out.println("Seleccione la acción que desea: ");
        System.out.println("C - Crear Documento | E - Editar Documento | D - Eliminar Documento | M - Mostrar Documentos | S - Salir");
        String userResponse = userInput.nextLine();

        switch(userResponse) {
            case "C": 
                System.out.println("Introduzca el tipo de documento a editar: ");
                String documentType = userInput.nextLine();
                options.createDocument(documentType);

            case "E":
                System.out.println("Introduzca el título del documento a editar: ");
                String documentTitle = userInput.nextLine();
                options.editDocument(documentTitle);  
                break;
            case "D": 
                System.out.println("Introduzca el título del documento a eliminar: ");
                String documentToDelete = userInput.nextLine();
                options.deleteDocument(documentToDelete);
                break;
            case "M": 
                options.showDocuments();              
                break;
            case "S":
                isAppRunning = false;
                break;
        }
    } while(isAppRunning);
    

}
