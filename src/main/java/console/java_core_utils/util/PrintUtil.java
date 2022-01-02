package console.java_core_utils.util;

import java.util.Scanner;

public class PrintUtil {

    public static final String COMMAND_BACK = "!back";
    public static final String COMMAND_CLOSE = "!close";
    public static final String FORMAT_RESULT = "%.3f";

    public static void printHead(String text) {
        System.out.println("\n======== " + text + " ========");
    }

    public static String printEnterUtil(String utilName, Scanner utilNameInput) {
        System.out.print("Enter util: ");
        utilName = utilNameInput.nextLine();
        return utilName;
    }

    public static void printDoneCase(String utilName) {
        System.out.println("Done " + utilName);
        printBorder("fat");
    }

    public static void printBackClose() {
        System.out.print(COMMAND_BACK + " | ");
        System.out.println(COMMAND_CLOSE);
        printBorder("thin");
    }

    public static boolean backIf(String value) {
        if (value.equals(COMMAND_BACK)) {
            System.out.println("Done " + COMMAND_BACK);
            printBorder("fat");
            return true;
        }
        return false;
    }

    public static void closeIf(String value, Scanner valueInput) {
        if (value.equals(COMMAND_CLOSE)) {
            System.out.println("Done " + COMMAND_CLOSE);
            printBorder("fat");
            valueInput.close();
            System.exit(0);
        }
    }

    public static void printBorder(String type) {
        switch (type) {
            case "thin":
                System.out.println("--------------------------------");
                break;
            case "fat":
                System.out.println("================================");
                break;
        }
    }

    public static void printEnterNum() {
        System.out.print("Enter number: ");
    }

    public static void printEnterNums() {
        System.out.print("Enter numbers separated by commas: ");
    }

    public static void printEnterText() {
        System.out.print("Enter text: ");
    }

    public static void printResult(String resultOut) {
        System.out.println(resultOut); // Get the result
        printBorder("fat");
    }

    public static void printInvalidValue() {
        System.out.println("Invalid value entered!");
        printBorder("fat");
    }

}
