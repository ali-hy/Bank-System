import java.util.Vector;

abstract public class DataSourceInterface {
    abstract void addClient(Client client);
    abstract void addEmployee(Employee employee);
    abstract void addAdmin(Admin admin);
    abstract Vector<Client> getAllClients();
    abstract Vector<Employee> getAllEmployees();
    abstract Vector<Admin> getAllAdmins();
    abstract void removeAllClients();
    abstract void removeAllEmployees();
    abstract void removeAllAdmins();
}