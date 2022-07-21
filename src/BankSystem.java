import java.io.File;
import java.io.IOException;
import java.util.Vector;

public class BankSystem{
    public static Vector<Client> clients;
    public static Vector<Employee> employees;
    public static Vector<Admin> admins;

    public static boolean transferToClient(double amount, int clientId){
        boolean success = false;
        for (Client c :
                clients) {
            if (clientId == c.getId()) {
                c.deposit(amount); success = true;
            }
        }
        if(!success) System.out.println("Transfer Failed. Couldn't find client with id '" + clientId + "'");
        return success;
    }

    File clientsFile, employeeFile, adminFile;
    Client loggedInClient;
    Employee loggedInEmployee;
    Admin loggedInAdmin;
    private void getFiles(){
        clientsFile = new File("clients.txt");
        employeeFile = new File("employee.txt");
        adminFile = new File("admin.txt");
        try{
            clientsFile.createNewFile();
            employeeFile.createNewFile();
            adminFile.createNewFile();
        }catch (IOException e){
            e.printStackTrace();
        }
    }
    public static void main(String[] args) {

    }
}