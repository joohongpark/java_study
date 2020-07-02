package tools;

public class Tools {
    public static Boolean isDigit(String str) {
        for(int i = 0; i < str.length(); i++) {
            if( (str.charAt(i) < '0') || (str.charAt(i) > '9') ) {
                return false;
            }
        }
        return true;
    }
}
