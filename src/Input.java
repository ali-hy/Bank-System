import java.io.IOException;
import java.util.Scanner;

public class Input {
    Scanner scanner = new Scanner(System.in);

    public int getInt(){
        boolean keepgoing = false;
        int result = 0;
        String input;

        while(keepgoing){
            input = scanner.nextLine();
            if(Validator.isNumber(input)){
                result = Integer.parseInt(input);
                keepgoing = false;
            } else {
                System.out.println("Input should consist only of numerical digits");
            }
        }

        return result;
    }
    public double getDouble(){
        boolean keepgoing = true;
        double number = 0;

        while(keepgoing) {
            String dString = scanner.nextLine();
            if(dString.matches("[+-]?\\d*\\.\\d+")) {
                number = Double.parseDouble(dString);
                keepgoing = false;
            }
        }
        return number;
    }
    public int getInt(String inputName){
        boolean keepgoing = false;
        int num = 0;
        String numString;

        while(keepgoing){
            numString = scanner.nextLine();
            if(Validator.isNumber(numString)){
                num = Integer.parseInt(numString);
                keepgoing = false;
            } else {
                System.out.println(inputName + " should consist only of numerical digits");
            }
        }

        return num;
    }
    public String getPinCode(){
        String pinCode = "";
        boolean keepgoing = true;

        while(keepgoing) {
            pinCode = scanner.nextLine();
            if (Validator.isValidPinCode(pinCode)) keepgoing = false;
            else System.out.println("PIN code should consist of 4 digits");
        }

        return pinCode;
    }

}
