package antonioGavilanes.reto003;

class Documento {
    private String name;

    public Documento(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "]> Documento: " + name;
    }
}
