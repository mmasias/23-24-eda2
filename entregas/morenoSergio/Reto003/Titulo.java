class Titulo {
    private static int contadorIds = 0;
    private int id;
    private String name;

    public Titulo(String name) {
        this.id = ++contadorIds;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String newName) {
        this.name = newName;
    }

}