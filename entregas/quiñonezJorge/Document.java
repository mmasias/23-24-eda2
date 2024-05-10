
import java.util.ArrayList;
import java.util.Scanner;

public class Document {
  private String title;
  private ArrayList<Author> authors;
  private String releaseDate;
  private String documentType;
  private ArrayList<String> keywords;

  public Document() {
    authors = new ArrayList<Author>();
    keywords = new ArrayList<String>();
  }

  public String getTitle() {
    return title;
  }

  public void create() {
    Scanner input = new Scanner(System.in);
    System.out.print("Insert document type: ");
    documentType = input.nextLine();
    System.out.print("Insert document title: ");
    title = input.nextLine();
    System.out.print("Insert release date: ");
    releaseDate = input.nextLine();
    addAuthors();
    addKeywords();
  }

  private void addAuthors() {
    boolean creating = true;
    Scanner input = new Scanner(System.in);
    while (creating) {
      System.out.print("Insert author name (0 to finish): ");
      String name = input.nextLine();
      if (name.equals("0")) {
        creating = !creating;
      } else {
        authors.add(new Author(name));
      }
    }
  }

  private void addKeywords() {
    boolean creating = true;
    Scanner input = new Scanner(System.in);
    while (creating) {
      System.out.print("Insert keyword (0 to finish): ");
      String name = input.nextLine();
      if (name.equals("0")) {
        creating = !creating;
      } else {
        keywords.add(name);
      }
    }
  }

  public void edit() {
    boolean editing = true;
    Scanner input = new Scanner(System.in);
    while (editing) {
      System.out.print("Insert document type (0 to cancel): ");
      String type = input.nextLine();
      if (!type.equals("0") || !type.equals("")) {
        documentType = type;
      }
      System.out.print("Insert document title (0 to cancel): ");
      String title = input.nextLine();
      if (!title.equals("0") || !title.equals("")) {
        this.title = title;
      }
      System.out.print("Insert release date (0 to cancel): ");
      String date = input.nextLine();
      if (!date.equals("0") || !date.equals("")) {
        releaseDate = date;
      }
      editAuthors();
      editKeywords();
      editing = !editing;
    }
  }

  private void editAuthors() {
    Scanner input = new Scanner(System.in);
    for (int i = 0; i < authors.size(); i++) {
      System.out.println("Old name: " + authors.get(i).getName());
      System.out.print("Insert new name (0 to cancel): ");
      String name = input.nextLine();
      if (!name.equals("0") || !name.equals("")) {
        authors.get(i).setName(name);
      }
    }
    System.out.println("Do you want to add a new author? (y/n)");
    if (input.nextLine().equals("y")) {
      addAuthors();
    }
  }

  private void editKeywords() {
    Scanner input = new Scanner(System.in);
    for (int i = 0; i < keywords.size(); i++) {
      System.out.println("Old keyword: " + keywords.get(i));
      System.out.print("Insert new keyword (0 to cancel): ");
      String name = input.nextLine();
      if (!name.equals("0") || !name.equals("")) {
        keywords.set(i, name);
      }
    }
    System.out.println("Do you want to add a new keyword? (y/n)");
    if (input.nextLine().equals("y")) {
      addKeywords();
    }
  }

  @Override
  public String toString() {
    String content = "";
    content += "Title: " + title + "\n" + "Type: " + documentType + "\n" + "Release date: " + releaseDate + "\n";

    content += "Authors: ";
    for (Author author : authors) {
      content += author.getName() + ", ";
    }

    content += "\n" + "Keywords: ";
    for (String keyword : keywords) {
      content += keyword + ", ";
    }

    return content;
  }
}
