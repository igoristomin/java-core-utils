package console.java_core_utils.util.text;

import java.util.Scanner;
import static console.java_core_utils.util.PrintUtil.*;

public class MainTextUtil {

    public static void run() {
        Scanner utilNameInput = new Scanner(System.in);
        String utilName = "";
        boolean execute = true;

        while(execute) {
            // Print menu
            printHead("Text utils");
            System.out.println("!chars-amount");
            System.out.println("!chars-replacement");
            printBorder("thin");
            printBackClose();

            // Get String value
            utilName = printEnterUtil(utilName, utilNameInput);

            // Check entered value and perform actions
            switch(utilName) {
                case "!chars-amount":
                    printDoneCase("!chars-amount");
                    CharsAmountUtil.run();
                    break;
                case "!chars-replacement":
                    printDoneCase("!chars-replacement");
                    CharsReplacementUtil.run();
                    break;
                case COMMAND_BACK:
                case COMMAND_CLOSE:
                    execute = false;
                    break;
                default:
                    // Print message with invalid value
                    printInvalidValue();
                    break;
            }

            // Do back or close
            if(backIf(utilName)) break;
            closeIf(utilName, utilNameInput);
        }
    }

}
