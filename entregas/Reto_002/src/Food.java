

class Food {
    private String name;

    public Food(String name) {
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
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("]> Alimento: ");
        stringBuilder.append(name);
        return stringBuilder.toString();
    }
}
