import java.util.Scanner;

public class ClientManager {
    Scanner scanner = new Scanner(System.in);

    public static boolean transferToClient(double amount, int clientId){
        boolean success = false;
        for (Client c :
                BankSystem.clients) {
            if (clientId == c.getId()) {
                c.deposit(amount); success = true;
            }
        }
        if(!success) System.out.println("Transfer Failed. Couldn't find client with id '" + clientId + "'");
        return success;
    }

    public static boolean clientExists(int clientId){
        boolean exists = false;
        for (Client c :
                BankSystem.clients) {
            if (c.getId() == clientId) {
                exists = true;
                break;
            }
        }
        return exists;
    }

    public void printLoginMenu(){
        System.out.println("Welcome to the Bank!" +
                "\nPlease Login:");
        boolean keepgoing = true;
        while(keepgoing) {
            int id; String pinCode;

            boolean keepGettingId = true;
            while (keepGettingId) {
                System.out.println("Id: ");
                String idString = scanner.nextLine();
                if (idString.matches("\\d+")) keepGettingId = false;
                else System.out.println("Id should consist of only numerical digits");
            }

            boolean keepGettingPin = true;
            while(keepGettingPin){
                System.out.println("PIN code: ");
                pinCode = scanner.nextLine();
                if (Validator.isValidPinCode(pinCode)) keepGettingPin = false;
                else System.out.println("Id should consist of digits");
            }

            
        }
        System.out.println("\tPIN code: ");
        String pinCode = scanner.nextLine();
    }
}
