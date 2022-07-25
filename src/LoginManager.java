public class LoginManager {
    private Input input = new Input();
    private User loggedInUser;
    private User Login(int id, String pinCode){
        switch (id%3){
            case 0:
                System.out.println("Admin Manager not ready"); // TODO: 25/07/2022 Add AdminManager
                break;
            case 1:
                System.out.println("Employee Manager not ready"); // TODO: 25/07/2022 Add Employee Manager
                break;
            case 2:
                Client client = null;
                for (Client c :
                        ClientManager.clients) {
                    if (c.getId() == id && c.getPin_code().equals(pinCode)) {
                        client = c;
                        break;
                    }
                }
                return client;
        }
        System.out.println("something went wrong"); return null;
    }

    public User printLoginMenu(){
        boolean askLogin = true;

        while (askLogin) {
            boolean keepgoing = true;

            System.out.println("Welcome to the Bank!");
            while(keepgoing) {
                System.out.println("Enter Your Login Details");
                int id = -1; String pinCode = "";
                //get id
                System.out.println("Id: ");
                id = input.getInt();
                //get pin code
                System.out.println("PIN code: ");
                pinCode = input.getPinCode();
                //attempt login
                loggedInUser = Login(id, pinCode);
                if (loggedInUser != null) //If login details found
                    break; //Leave loop
                else
                    System.out.println("Id or pin code incorrect. Pleases try again.");
            }
            loggedInUser.setManager();  //Set Manager for the current user
            loggedInUser.printMenu();   //Print Menu options for user

            System.out.println("Would you like to exit the application? (y/n)");
            keepgoing = true;
            while(keepgoing){
                char c = input.getChar();
                if(c == 'y' || c == 'n'){
                    askLogin = c == 'y';
                    break;
                }
                System.out.println("Please enter 'y' for yes or 'n' for no: ");
            }
        }
        return loggedInUser;
    }
}
