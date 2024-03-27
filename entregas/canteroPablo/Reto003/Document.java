package entregas.canteroPablo.Reto003;

import java.util.ArrayList;

class Document {
    private String tittle;
    private ArrayList<Author> author;
    private int age;
    private String typeDocument;
    private ArrayList<String> keyWords;

    public Document(String tittle, ArrayList<Author> author, int age, String typeDocument, ArrayList<String> keyWords) {
        this.tittle = tittle;
        this.author = author;
        this.age = age;
        this.typeDocument = typeDocument;
        this.keyWords = keyWords;
    }

    public String getTittle() {
        return tittle;
    }

    public void setTittle(String tittle) {
        this.tittle = tittle;
    }

    public ArrayList<Author> getAuthor() {
        return author;
    }

    public void setAuthor(ArrayList<Author> author) {
        this.author = author;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getTypeDocument() {
        return typeDocument;
    }

    public void setTypeDocument(String typeDocument) {
        this.typeDocument = typeDocument;
    }

    public ArrayList<String> getKeyWords() {
        return keyWords;
    }
    public void setKeyWords(ArrayList<String> keyWords) {
        this.keyWords = keyWords;
    }
    @Override
    public String toString() {
        return "Titulo: " + tittle + "Autor: " + author + "Año: " + age + "Tipo de Documento: " + typeDocument
                + "Palabras Clave: " + keyWords;
    }

}
