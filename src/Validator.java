public class Validator {
    static boolean isValidName(String name){
        return name.matches("[a-zA-Z ]+") && lengthInRange(name, 5, 20);
    }
    public static boolean isValidPinCode(String pin_code){
        if (pin_code.length() != 4){
            System.out.println("Pin code invalid. Length should be 4.");
            return false;
        }
        if(!pin_code.matches("\\d+")){
            System.out.println("Pin code invalid. Should only contain digits.");
            return false;
        }
        return true;
    }
    static boolean isNumber(String string){
        return string.matches("\\d+");
    }
    static boolean lengthInRange(String string, int min, int max){
        return inRange(string.length(), min, max);
    };
    static boolean inRange(int number, int min, int max){
        return !outOfRange(number, min, max);
    }
    static boolean outOfRange(int number, int min, int max){
        return number < min || number > max;
    }
    static boolean outOfRange(double number, double min, double max){
        return number < min || number > max;
    }
}
