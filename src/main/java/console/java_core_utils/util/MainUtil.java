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

        while (execute) {
            // Print menu
            printHead("Java Core Utils");
            System.out.println("!maths");
            System.out.println("!text");
            printBorder("thin");
            System.out.println(COMMAND_CLOSE);
            printBorder("thin");

            // Get String value
            System.out.print("Enter util group: ");
            utilGroup = utilGroupInput.nextLine();

            // Check entered value and perform actions
            switch (utilGroup) {
                case "!maths":
                    printDoneCase("!maths");
                    MainMathsUtil.run();
                    break;
                case "!text":
                    printDoneCase("!text");
                    MainTextUtil.run();
                    break;
                case COMMAND_CLOSE:
                    execute = false;
                    break;
                default:
                    // Print message with invalid value
                    printInvalidValue();
                    break;
            }

            // Choose !close
            closeIf(utilGroup, utilGroupInput);
        }
    }

}
