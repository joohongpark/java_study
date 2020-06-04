package useful;

import java.util.Scanner;

public class GetInteger {
    public static int consoleGetNumber(Scanner scan, int startRange, int endRange) {
        boolean loop = true;
        String str = "";
        int returnNumber = 0;
        while(loop) {
            System.out.print(">> ");
            str = scan.next();
            if(!isNumber(str)) {
                System.out.println("[error] 올바른 숫자를 입력해 주세요!");
            } else {
                returnNumber = Integer.parseInt(str);
                if( (startRange <= returnNumber) && (endRange >= returnNumber) ) {
                    loop = false;
                } else {
                    System.out.printf("[error] 올바른 범위 내의 숫자(%d ~ %d)를 입력해 주세요!\n", startRange, endRange);
                }
            }
        }
        return returnNumber;
    }
    public static int consoleGetNumber(Scanner scan) {
        boolean isNumber = false;
        String str = "";
        while(!isNumber) {
            System.out.print(">> ");
            str = scan.next();
            isNumber = isNumber(str);
            if(!isNumber) {
                System.out.println("[error] 올바른 숫자를 입력해 주세요!");
            }
        }
        return Integer.parseInt(str);
    }
    public static int getNumber(Scanner scan) {
        boolean isNumber = false;
        String str = "";
        while(!isNumber) {
            str = scan.next();
            isNumber = isNumber(str);
            if(!isNumber) {
                System.out.println("[error] 올바른 숫자를 입력해 주세요!");
            }
        }
        return Integer.parseInt(str);
    }
    static boolean isNumber(String str) {
        boolean result = true;
        for (int i = 0; i < str.length(); i++) {
            if( ('0' > str.charAt(i)) || ('9') < str.charAt(i) ) {
                result = false;
                break;
            }
        }
        return result;
    }
}