abstract public class User {
    private String name;
    private int id;

    public boolean setName(String name) {
        boolean valid = Validator.isValidName(name);

        if(valid)
            this.name = name;

        return  valid;
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }
    public void setId(int id) {this.id = id;}
    public String currency(double value){
        return String.format("$%.2f", value);
    }

    abstract void display();

    @Override
    public String toString() {
        return id + '\n' +
                name + '\n';
    }
}
