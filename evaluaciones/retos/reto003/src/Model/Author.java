package Model;
public class Author {
    private String name;
    private String surnames;

    public Author(String name, String surnames){
        this.name = name;
        this.surnames = surnames;
    }

    public String getName() {
        return name;
    }

    public String getSurnames() {
        return surnames;
    }

    public void setName(String authorName) {
        name = authorName;
    }

    public void setSurnames(String authorSurname) {
        surnames = authorSurname;
    }

}
