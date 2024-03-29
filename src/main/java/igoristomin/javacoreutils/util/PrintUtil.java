package igoristomin.javacoreutils.util;

import org.springframework.stereotype.Service;
import java.text.DecimalFormat;

@Service
public class PrintUtil {

    public static final String CMD_BACK = "back";
    public static final String CMD_CLOSE = "close";
    public static final DecimalFormat FORMAT_DECIMAL = new DecimalFormat("0.###");

    public static void printHead(String text) {
        System.out.println("\n======== " + text + " ========");
    }

    public static void printEnterUtil() {
        System.out.print("Enter the util: ");
    }

    public static void printDoneCase(String util) {
        System.out.println("Done " + util);
        printBorder("fat");
    }

    public static void printBackClose() {
        System.out.print(CMD_BACK + " | ");
        System.out.println(CMD_CLOSE);
        printBorder("thin");
    }

    public static boolean doIfBack(String value) {
        if(value.equals(CMD_BACK)) {
            printDoneCase(value);
            return true;
        }
        return false;
    }

    public static void doIfClose(String value) {
        if(value.equals(CMD_CLOSE)) {
            printDoneCase(value);
            System.exit(0);
        }
    }

    public static void printBorder(String type) {
        switch(type) {
            case "thin":
                System.out.println("--------------------------------");
                break;
            case "fat":
                System.out.println("================================");
                break;
        }
    }

    public static void printEnterNum() {
        System.out.print("Enter a number: ");
    }

    public static void printEnterNums() {
        System.out.print("Enter comma-separated numbers: ");
    }

    public static void printEnterText() {
        System.out.print("Enter the text: ");
    }

    public static void printResult(String result) {
        System.out.println(result);
        printBorder("fat");
    }

    public static void printInvalidValue() {
        System.out.println("Invalid value entered!");
        printBorder("fat");
    }

}
