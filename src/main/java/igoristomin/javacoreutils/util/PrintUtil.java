package igoristomin.javacoreutils.util;

import org.springframework.stereotype.Service;
import java.text.DecimalFormat;
import java.util.Scanner;

@Service
public class PrintUtil {

    public static final String CMD_BACK = "!back";
    public static final String CMD_CLOSE = "!close";
    public static final DecimalFormat DF = new DecimalFormat("0.###");

    public static void printHead(String text) {
        System.out.println("\n======== " + text + " ========");
    }

    public static String printEnterUtil(String utilName, Scanner utilNameInput) {
        System.out.print("Enter the util: ");
        utilName = utilNameInput.nextLine();
        return utilName;
    }

    public static void printDoneCase(String utilName) {
        System.out.println("Done " + utilName);
        printBorder("fat");
    }

    public static void printBackClose() {
        System.out.print(CMD_BACK + " | ");
        System.out.println(CMD_CLOSE);
        printBorder("thin");
    }

    public static boolean backIf(String value) {
        if(value.equals(CMD_BACK)) {
            System.out.println("Done " + CMD_BACK);
            printBorder("fat");
            return true;
        }
        return false;
    }

    public static void closeIf(String value, Scanner valueInput) {
        if(value.equals(CMD_CLOSE)) {
            System.out.println("Done " + CMD_CLOSE);
            printBorder("fat");
            valueInput.close();
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

    public static void printResult(String resultOut) {
        System.out.println(resultOut);
        printBorder("fat");
    }

    public static void printInvalidValue() {
        System.out.println("Invalid value entered!");
        printBorder("fat");
    }

}
