package console.javacoreutils.util.text;

import java.util.Scanner;
import static console.javacoreutils.util.PrintUtil.*;

public class MainTextUtil {

    public static void run() {
        Scanner utilNameInput = new Scanner(System.in);
        String utilName = "";
        boolean execute = true;

        while(execute) {
            // Print the menu
            printHead("Text utils");
            System.out.println("!chars-amount");
            System.out.println("!chars-replacement");
            printBorder("thin");
            printBackClose();

            // Get String value
            utilName = printEnterUtil(utilName, utilNameInput);

            // Check the entered value and perform the following actions
            switch(utilName) {
                case "!chars-amount":
                    printDoneCase("!chars-amount");
                    CharsAmountUtil.run();
                    break;
                case "!chars-replacement":
                    printDoneCase("!chars-replacement");
                    CharsReplacementUtil.run();
                    break;
                case CMD_BACK:
                case CMD_CLOSE:
                    execute = false;
                    break;
                default:
                    // Print a message with an invalid value
                    printInvalidValue();
                    break;
            }

            // Do back or close
            if(backIf(utilName)) break;
            closeIf(utilName, utilNameInput);
        }
    }

}
