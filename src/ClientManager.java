import java.util.Scanner;
import java.util.Vector;

public class ClientManager extends UserManager{
    Client loggedIn = null;
    Scanner scanner = new Scanner(System.in);
    Input input = new Input();
    static Vector<Client> clients;

    ClientManager(){
        clients = BankSystem.fileManager.getAllClients();
        if(clients.size() > 0)  Client.nextId = clients.get(clients.size()-1).getId() + 3;
        else Client.nextId = 2;
    }

    void setUser(User user) {
        loggedIn = (Client) user;
    }

    public boolean clientExists(int clientId){
        boolean exists = false;
        for (Client c :
                clients) {
            if (c.getId() == clientId) {
                exists = true;
                break;
            }
        }
        return exists;
    }

    public void printMenu(){
        boolean keepgoing = true;
        while (keepgoing){
            System.out.println("Choose an option:\n" +
                    "1- Display my info\n" +
                    "2- Update my PIN code\n" +
                    "3- Withdraw\n" +
                    "4- Deposit\n" +
                    "5- Transfer amount\n" +
                    "6- Logout\n");

            int choice = input.getInt();
            switch (choice){
                case 1:
                    displayInfo();
                    break;
                case 2:
                    updatePinCode();
                    break;
                case 3:
                    promptWithdraw();
                    break;
                case 4:
                    promptDeposit();
                    break;
                case 5:
                    promptTransfer();
                    break;
                case 6:
                    keepgoing = false;
                    break;
            }
        }
    }

    void displayInfo(){
        loggedIn.display();
    }
    void updatePinCode(){
        System.out.println("Please enter your current PIN code: ");
        String currentPinCode = input.getPinCode();
        if(!currentPinCode.equals(loggedIn.getPin_code())) {
            System.out.println("Operation failed due to wrong PIN code. Please try again");
            return;
        }
        System.out.println("Please enter your new pinCode: ");
        String newPinCode = input.getPinCode();
        loggedIn.setPinCode(newPinCode);
        System.out.println("New PIN code set.");
    }
    void promptWithdraw(){
        System.out.println("Please enter the amount you want to withdraw:");
        double amount = input.getDouble();
        loggedIn.withdraw(amount);
    }
    void promptDeposit(){
        System.out.println("Please enter the amount you want to deposit:");
        double amount = input.getDouble();
        loggedIn.deposit(amount);
    }
    void promptTransfer(){
        System.out.println("Please enter the amount you want to transfer:");
        double amount  = input.getDouble();

        System.out.println("Please enter the Id of the recipient client: ");
        int recipientId = input.getInt("Id");

        transferAmount(loggedIn, amount, recipientId);
    }
    public boolean transferAmount(Client sender, double amount, int recipientId){
        boolean success = sender.setBalance(sender.getBalance() - amount);
        if(!success) {
            return false;
        }
        success = false;
        for (Client c :
                clients) {
            if (recipientId  == c.getId()) {
                c.setBalance(c.getBalance() - amount); success = true; break;
            }
        }
        if(success) System.out.println("Transfer successful. Your new balance is: " + loggedIn.currency(loggedIn.getBalance()));
        else System.out.println("Transfer Failed. Couldn't find client#" + recipientId);
        return success;
    }
}
