import java.io.File;
import java.io.IOException;

public class BankSystem{
    static FileManager fileManager = new FileManager();
    static ClientManager clientManager = new ClientManager();
    static LoginManager loginManager = new LoginManager();

    public static void main(String[] args) {
        loginManager.printLoginMenu();
    }
}