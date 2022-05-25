package console.java_core_utils.util;

import console.java_core_utils.util.maths.MainMathsUtil;
import console.java_core_utils.util.text.MainTextUtil;
import java.util.Scanner;
import static console.java_core_utils.util.PrintUtil.*;

public class MainUtil {

    public static void run() {
        Scanner utilGroupInput = new Scanner(System.in);
        String utilGroup;
        boolean execute = true;

        while(execute) {
            // Print the menu
            printHead("Java Core Utils");
            System.out.println("!maths");
            System.out.println("!text");
            printBorder("thin");
            System.out.println(CMD_CLOSE);
            printBorder("thin");

            // Get String value
            System.out.print("Enter a group of utils: ");
            utilGroup = utilGroupInput.nextLine();

            // Check the entered value and perform the following actions
            switch(utilGroup) {
                case "!maths":
                    printDoneCase("!maths");
                    MainMathsUtil.run();
                    break;
                case "!text":
                    printDoneCase("!text");
                    MainTextUtil.run();
                    break;
                case CMD_CLOSE:
                    execute = false;
                    break;
                default:
                    // Print a message with an invalid value
                    printInvalidValue();
                    break;
            }

            // Choose !close
            closeIf(utilGroup, utilGroupInput);
        }
    }

}
