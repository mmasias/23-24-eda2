package entregas.quiñonezJorge;

import java.util.ArrayList;
import java.util.Scanner;

public class DocumentManager {
  private Menu menu;
  private ArrayList<Document> documents;
  private boolean running;

  public DocumentManager() {
    menu = new Menu();
    documents = new ArrayList<Document>();
    running = true;
  }

  public void start() {
    running = true;
    Scanner input = new Scanner(System.in);
    while (running) {
      menu.showMenu();
      System.out.print("Choose an option: ");
      String option = input.nextLine();
      manageInput(option);
    }
  }

  private void manageInput(String option) {
    switch (option) {
      case "1":
        addDocument();
        break;
      case "2":
        editDocument();
        break;
      case "3":
        removeDocument();
        break;
      case "4":
        listDocuments();
        break;
      case "5":
        filterDocuments();
        break;
      case "0":
        running = !running;
        break;
      default:
        System.out.println("Invalid option");
        break;
    }
  }

  private void addDocument() {
    boolean creating = true;
    Scanner input = new Scanner(System.in);
    while (creating) {
      System.out.print("Do you want to create a document? (y/n): ");
      String option = input.nextLine();
      if (option.equals("n")) {
        creating = !creating;
      } else {
        Document document = new Document();
        document.create();
        documents.add(document);
      }
    }
  }

  private void editDocument() {
    for (Document document : documents) {
      System.out.println("Do you want to edit the document: " + document.getTitle() + "? (y/n)");
      Scanner input = new Scanner(System.in);
      if (input.nextLine().equals("y")) {
        document.edit();
      }
    }
  }

  private void removeDocument() {
    for (Document document : documents) {
      System.out.println("Do you want to remove the document: " + document.getTitle() + "? (y/n)");
      Scanner input = new Scanner(System.in);
      if (input.nextLine().equals("y")) {
        documents.remove(document);
      }
    }
  }

  private void listDocuments() {
    System.out.println();
    for (Document document : documents) {
      System.out.println(document.toString() + "\n");
    }
    new Scanner(System.in).nextLine();
  }

  private void filterDocuments() {
    Scanner input = new Scanner(System.in);
    System.out.println("You can search documents by title, author, release date, document type, keywords");
    System.out.print("Search: ");
    String search = input.nextLine();
    System.out.println();
    for (Document document : documents) {
      if (document.toString().contains(search)) {
        System.out.println(document.toString() + "\n");
      }
    }
    new Scanner(System.in).nextLine();
  }

}
