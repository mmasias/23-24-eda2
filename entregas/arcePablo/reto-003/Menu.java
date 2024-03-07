import java.util.ArrayList;
import java.util.Date;

public class Menu {

    public void welcome() {
        System.out.println("### Bienvenido a la Librería Digital ###");
    }

    public void displayMainOptions() {
        System.out.println("\n=== Menú de la Librería Digital ===");
        System.out.println("a - Añadir documento");
        System.out.println("f - Modificar buscador");
        System.out.println("l - Listar documentos");
        System.out.println("s - Salir\n");
    }

public void listDocuments(ArrayList<Document> documents) {
    System.out.println("=== Lista de Documentos ===");
    System.out.println("|   Title"+" ".repeat(34)+ "|   Author"+" ".repeat(3)+"|  Date Published |");

    for (Document document : documents) {
        String title = document.getTitle();
        String author = document.getAuthor();
        Date datePublished = document.getDatePublished();

        String formattedTitle = formatCell(title, 40);
        String formattedAuthor = formatCell(author, 10);
        String formattedDate = new java.text.SimpleDateFormat("dd/MM/yyyy").format(datePublished);

        System.out.format("| %-40s | %-10s | %-14s |\n", formattedTitle, formattedAuthor, formattedDate);
    }
}

private String formatCell(String value, int maxLength) {
    if (value.length() > maxLength) {
        return value.substring(0, maxLength);
    } else {
        return value + " ".repeat(maxLength - value.length());
    }
}

    
    public void displaySearchbarOptions() {
        System.out.println("a - Añadir palabra clave");
        System.out.println("b - Borrar palabra clave");
    }

}
