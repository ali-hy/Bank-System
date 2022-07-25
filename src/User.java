abstract public class User {
    private UserManager manager;
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

    public void setManager(UserManager manager) {
        this.manager = manager;
        manager.setUser(this);
    }
    abstract void setManager();

    public String currency(double value){
        return String.format("$%.2f", value);
    }

    public void printMenu(){
        manager.printMenu();
    }
    abstract void display();

    @Override
    public String toString() {
        return id + '\n' +
                name + '\n';
    }
}
