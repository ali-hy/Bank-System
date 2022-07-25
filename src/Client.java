public class Client extends User{
    static int nextId;
    private String pin_code;
    private double balance;
    private final double balanceMin = 1500;

    Client(){
        setId(nextId);
        nextId += 3;
    }

    public void deposit(double amount){
        setBalance(balance + amount);
        System.out.println("Deposit successful.\nYour new balance is: " + currency(balance));
    }
    public void withdraw(double amount){
        if(setBalance(balance - amount))
            System.out.println("Withdrawal Successful. \nYour new balance is: " + currency(balance));
    }
    public void checkBalance(){
        System.out.println("Your current balance is: " + currency(balance));
    }
    public void display() {
        System.out.println("Name:" + getName() +
                "\n\tid: " + getId() +
                "\n\tbalance: " + currency(balance));
    }

    public double getBalance(){
        return balance;
    }

    public boolean setPinCode(String pin_code) {
        boolean valid = Validator.isValidPinCode(pin_code);
        if(!valid) return false;

        this.pin_code = pin_code;
        return true;
    }

    public boolean setBalance(double balance) {
        if(balance < balanceMin) {
            System.out.println("Operation failed. Balance cannot go below $" + balanceMin);
            return false;
        }
        this.balance = balance;
        return true;
    }

    public void setManager() {
        super.setManager(BankSystem.clientManager);
    }

    public String getPin_code() {
        return pin_code;
    }

    @Override
    public String toString() {
        String result = super.toString();
        return result +
                balance + '\n' +
                pin_code + '\n';
    }
}
