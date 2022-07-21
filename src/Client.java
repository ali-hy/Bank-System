public class Client extends User{
    private String name;
    private String pin_code;
    private int id;
    private double balance;
    private final double balanceMin = 1500;

    public void deposit(double amount){
        setBalance(balance + amount);
        System.out.println("Deposit successful.\nYour new balance is: " + currency(balance));
    }
    public void withdraw(double amount){
        if(amount > balance){
            System.out.println("Withdrawal failed due to in sufficient funds.\n Your Balance is:" + currency(balance));
        }

        if(setBalance(balance - amount))
            System.out.printf("Withdrawal Successful. \n Your new balance is: " + currency(balance));
    }
    public void transferTo(double amount, int clientId){
        boolean transferValid = setBalance(this.balance - amount);
        if(!transferValid){
            System.out.println("Operation failed. Balance cannot fall below $" + balanceMin);
        }
            transferValid = BankSystem.transferToClient(amount, clientId);
    }
    public void checkBalance(){
        System.out.println("Your current balance is: " + currency(balance));
    }
    public void display() {
        System.out.println("Client:" + name +
                "\n\tid: " + id +
                "\n\tbalance: " + currency(balance));
    }

    public double getBalance(){
        return balance;
    }

    public boolean setPinCode(String pin_code) {
        boolean valid = Validator.pinCodeIsValid(pin_code);
        if(!valid) return false;

        this.pin_code = pin_code;
        return true;
    }

    public int getId() {
        return id;
    }

    public boolean setBalance(double balance) {
        if(balance < balanceMin) {
            System.out.println("Operation failed. Balance cannot go below $" + balanceMin);
            return false;
        }
        this.balance = balance;
        return true;
    }
}
