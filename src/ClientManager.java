import java.util.Scanner;
import java.util.Vector;

public class ClientManager {
    Client loggedIn = null;
    Scanner scanner = new Scanner(System.in);
    Input input = new Input();
    FileManager fileManager = new FileManager();
    Vector<Client> clients = fileManager.getAllClients();

    public boolean transferAmount(Client sender, double amount, int recipientId){
        boolean success = sender.setBalance(sender.getBalance() - amount);
        if(!success) {
            System.out.println("Transfer failed. Balance not sufficient");
            return false;
        }
        success = false;
        for (Client c :
                clients) {
            if (recipientId  == c.getId()) {
                c.deposit(amount); success = true; break;
            }
        }
        if(success) System.out.println("Transfer successful. Your new balance is: " + loggedIn.balanceAsString());
        else System.out.println("Transfer Failed. Couldn't find client with id '" + recipientId + "'");
        return success;
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

    private Client Login(int id, String pinCode){
        Client client = null;
        for (Client c :
                clients) {
            if (c.getId() == id && c.getPin_code() == pinCode) {
                client = c;
                break;
            }
        }
        return client;
    }

    public void printLoginMenu(){
        System.out.println("Welcome to the Bank!" +
                "\nPlease Login:");
        boolean keepgoing = true;
        while(keepgoing) {
            int id = -1; String pinCode = "";
            System.out.println("Id: ");
            id = input.getInt();

            System.out.println("PIN code: ");
            pinCode = input.getPinCode();

            loggedIn = Login(id, pinCode);
            if (loggedIn != null) {
                keepgoing = false;
            } else {
                System.out.println("Id or pin code incorrect. Pleases try again.");
            }
        }
        printClientMenu();
    }

    public void printClientMenu(){
        boolean keepgoing = true;
        while (keepgoing){
            System.out.println("Choose an option: " +
                    "1- Display my info\n" +
                    "2- Update my PIN code\n" +
                    "3- Withdraw\n" +
                    "4- Deposit\n" +
                    "5- Transfer amount\n" +
                    "6- Logout\n");

            int choice = input.getInt();
            switch (choice){
                case 1:
                    displayClientDetails();
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

    void displayClientDetails(){
        loggedIn.display();
    }
    void updatePinCode(){
        System.out.println("Please enter your current PIN code: ");
        String currentPinCode = input.getPinCode();
        if(currentPinCode != loggedIn.getPin_code()) {
            System.out.println("Operation failed due to wrong PIN code. Please try again");
            return;
        }
        System.out.println("Please enter your new pinCode: ");
        String newPinCode = input.getPinCode();
        loggedIn.setPinCode(newPinCode);
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


    }
}
