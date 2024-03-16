import java.util.ArrayList;
import java.util.Date;

import Types.KeyWordTypes;

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
        System.out.println("=".repeat(130));
        System.out.println("|   Title" + " ".repeat(34) + "|   Author" + " ".repeat(3) + "| Date Published | Keywords");
        System.out.println("=".repeat(130));

        for (Document document : documents) {
            String title = document.getTitle();
            String author = document.getAuthor();
            Date datePublished = document.getDatePublished();
            ArrayList<KeyWordTypes> keywords = document.getKeyWords();

            String formattedTitle = formatCell(title, 40);
            String formattedAuthor = formatCell(author, 10);
            String formattedDate = new java.text.SimpleDateFormat("dd/MM/yyyy").format(datePublished);
            String formattedKeywords = formatKeywords(keywords);

            System.out.format("| %-40s | %-10s | %-14s | %-53s |\n", formattedTitle, formattedAuthor, formattedDate, formattedKeywords);
        }
        System.out.println("=".repeat(130));
    }

    private String formatCell(String value, int maxLength) {
    if (value.length() > maxLength) {
        return value.substring(0, maxLength);
    } else {
        return value + " ".repeat(maxLength - value.length());
    }
}

    private String formatKeywords(ArrayList<KeyWordTypes> keywords) {
        StringBuilder builder = new StringBuilder();
        for (KeyWordTypes keyword : keywords) {
            builder.append(keyword.toString()).append(", ");
        }
        String formattedKeywords = builder.toString();
        if (formattedKeywords.length() > 50) {
            formattedKeywords = formattedKeywords.substring(0, 50) + "...";
        }
        return formattedKeywords;
    }


public void displayInputs(Searchbar searchbar) {
        System.out.println("\nBuscador: ");

        if (!searchbar.getSearchedTitle().isEmpty() && searchbar.getSearchedTitle() != null) {
            System.out.println("Título: " + searchbar.getSearchedTitle());
        }

        if (!searchbar.getSearchedKeyWords().isEmpty() && searchbar.getSearchedKeyWords() != null) {
            System.out.print("Palabras claves: ");
            for (KeyWordTypes keyword : searchbar.getSearchedKeyWords()) {
                System.out.print(keyword + ", ");
            }
            System.out.println();
        }

        if (searchbar.getSearchedDate() != null) {
            System.out.println("Fecha: " + searchbar.getSearchedDate());
        }

        if (!searchbar.getSearchedAuthor().isEmpty() && searchbar.getSearchedAuthor() != null) {
            System.out.println("Autor: " + searchbar.getSearchedAuthor());
        }

        if (searchbar.getSearchedDocType() != null) {
            System.out.println("Tipo de documento: " + searchbar.getSearchedDocType());
        }
                
        System.out.println("");
    }

    
    public void displaySearchbarOptions() {
        System.out.println("a - Añadir palabra clave");
        System.out.println("b - Borrar palabra clave");
        System.out.println("t - Modificar título");
        System.out.println("d - Modificar fecha");
        System.out.println("u - Añadir autor");
        System.out.println("i - Borrar autor");
        System.out.println("y - Modificar tipo de documento");
        System.out.println("r - Volver al menú principal");
    }

}
