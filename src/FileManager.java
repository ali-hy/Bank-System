import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.Vector;

public class FileManager extends DataSourceInterface{
    public static Vector<Employee> employees;
    public static Vector<Admin> admins;
    public static File adminFile;
    public static File clientsFile;
    public static File employeeFile;

    @Override
    void addClient(Client client) {
        try {
            FileWriter writer = new FileWriter(clientsFile);
            writer.write(client.toString());
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    void addEmployee(Employee employee) {
        try {
            FileWriter writer = new FileWriter(employeeFile);
            writer.write(employee.toString());
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    void addAdmin(Admin admin) {
        try {
            FileWriter writer = new FileWriter(adminFile);
            writer.write(admin.toString());
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    Vector<Client> getAllClients() {
        Vector<Client> clients = new Vector<>();
        try{
            Scanner scanner = new Scanner(clientsFile);

            while (scanner.hasNext()) {
                Client client = new Client();
                //Set `client` to values on lines
                client.setId(Integer.parseInt(scanner.nextLine()));
                client.setName(scanner.nextLine());
                client.setBalance(Double.parseDouble(scanner.nextLine()));
                client.setPinCode(scanner.nextLine());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return clients;
    }

    @Override
    Vector<Employee> getAllEmployees() {
        Vector<Employee> employees = new Vector<>();
        try{
            Scanner scanner = new Scanner(employeeFile);


            while (scanner.hasNext()) {
                Employee employee = new Employee();

                //Set 'employee' to values in file
                employee.setId(Integer.parseInt(scanner.nextLine()));
                employee.setName(scanner.nextLine());
                employee.setSalary(Double.parseDouble(scanner.nextLine()));
                employee.setPassword(scanner.nextLine());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return employees;
    }

    @Override
    Vector<Admin> getAllAdmins() {
        Vector<Admin> admins = new Vector<>();
        try{
            Scanner scanner = new Scanner(employeeFile);


            while (scanner.hasNext()) {
                Admin admin = new Admin();

                //Set 'employee' to values in file
                admin.setId(Integer.parseInt(scanner.nextLine()));
                admin.setName(scanner.nextLine());
                admin.setSalary(Double.parseDouble(scanner.nextLine()));
                admin.setPassword(scanner.nextLine());

                admins.add(admin);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return admins;
    }

    @Override
    void removeAllClients() {
        try {
            FileWriter writer = new FileWriter(clientsFile, false);
            writer.write("");
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    void removeAllEmployees() {
        try {
            FileWriter writer = new FileWriter(employeeFile, false);
            writer.write("");
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    void removeAllAdmins() {
        try {
            FileWriter writer = new FileWriter(adminFile, false);
            writer.write("");
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
