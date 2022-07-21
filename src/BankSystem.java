import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import java.util.Vector;

public class BankSystem{
    public static Vector<Client> clients;
    public static Vector<Employee> employees;
    public static Vector<Admin> admins;

    public static File clientsFile, employeeFile, adminFile;
    User loggedIn;
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