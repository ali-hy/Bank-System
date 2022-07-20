public class Validator {
    static boolean validateLength(String string, int min, int max){
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
