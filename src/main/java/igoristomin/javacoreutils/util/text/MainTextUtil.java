package igoristomin.javacoreutils.util.text;

import org.springframework.stereotype.Service;
import java.util.Scanner;
import static igoristomin.javacoreutils.util.PrintUtil.*;

@Service
public class MainTextUtil {

    public static void run() {
        Scanner utilInput = new Scanner(System.in);
        boolean execute = true;

        while(execute) {
            // Print the menu
            printHead("Text utils");
            System.out.println("symbols-amount");
            System.out.println("symbols-replacement");
            printBorder("thin");
            printBackClose();

            // Print a message and get the entered value into the util
            String util = printEnterUtil(utilInput);

            // Check the util and perform the following actions
            switch(util) {
                case "symbols-amount":
                    printDoneCase("symbols-amount");
                    SymbolsAmountUtil.run();
                    break;
                case "symbols-replacement":
                    printDoneCase("symbols-replacement");
                    SymbolsReplacementUtil.run();
                    break;
                case CMD_BACK:
                case CMD_CLOSE:
                    execute = false;
                    break;
                default:
                    // Print a message about an invalid value entered
                    printInvalidValue();
                    break;
            }

            // Execute if the util is equal to the CMD_BACK or CMD_CLOSE
            if(doIfBack(util)) break;
            doIfClose(util, utilInput);
        }
    }

}
