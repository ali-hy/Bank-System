import java.io.IOException;
import java.util.Scanner;

public class Input {
    Scanner scanner = new Scanner(System.in);

    public int getInt(){
        boolean keepgoing = true;
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
    public int getInt(String inputName){
        boolean keepgoing = true;
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
    public double getDouble(){
        boolean keepgoing = true;
        double number = 0;

        while(keepgoing) {
            String dString = scanner.nextLine();
            if(dString.matches("\\d*\\.?\\d+")) {
                number = Double.parseDouble(dString);
                keepgoing = false;
            }
            else System.out.println("Input invalid. Please use numerical digits only.");
        }
        return number;
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
    public char getChar(){
        String str = "";
        char c;
        boolean keepgoing = true;

        while(keepgoing){
            str = scanner.nextLine();
            if(str.length() == 1)
                break;
            System.out.println("Input should only be 1 character long");
        }

        c = str.charAt(0);
        return c;
    }
}
