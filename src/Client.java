public class Client {
    private String name;
    private String pin_code;
    private int id;
    private double balance;

    public void deposit(double amount){
        setBalance(balance + amount);
        System.out.println("Deposit successful.\nYour new balance is: " + balanceString());
    }
    public void withdraw(double amount){
        if(amount > balance){
            System.out.println("Withdrawal failed due to in sufficient funds.\n Your Balance is:" + balanceString());
        }

        balance -= amount;
        System.out.printf("Withdrawal Successful. \n Your new balance is: " + balanceString());
    }
    public void transferTo(String clientID){

    }

    @Override
    public String toString() {
        return "Client:" + name +
                "\tid: " + id +
                "\tbalance: " + balanceString();
    }

    public double getBalance(){
        return balance;
    }

    private String balanceString(){
        return String.format("%.2f", balance);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        boolean valid = nameIsValid(name);

        this.name = name;
    }

    private boolean nameIsValid(String name){
        return name.matches("[a-zA-Z ]+") && Validator.validateLength(name, 5, 20);
    }

    public boolean setPinCode(String pin_code) {
        boolean valid = pinCodeIsValid(pin_code);

        this.pin_code = pin_code;
        return(true);
    }

    private boolean pinCodeIsValid(String pin_code){
        return pin_code.length() == 4 && pin_code.matches("\\d+");
    }

    public int getId() {
        return id;
    }

    public void setBalance(double balance) {
        if(balance < 1500) return;
        this.balance = balance;
    }
}
