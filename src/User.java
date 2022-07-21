abstract public class User {
    String name;
    int id;

    public boolean setName(String name) {
        boolean valid = Validator.nameIsValid(name);

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

    public String currency(double value){
        return String.format("$%.2f", value);
    }

    abstract void display();
}
