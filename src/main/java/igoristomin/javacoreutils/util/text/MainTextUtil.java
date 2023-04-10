package igoristomin.javacoreutils.util.text;

import igoristomin.javacoreutils.util.PrintUtil;
import org.springframework.stereotype.Service;
import java.util.Scanner;

@Service
public class MainTextUtil {

    public static void run() {
        Scanner utilInput = new Scanner(System.in);
        boolean execute = true;

        while(execute) {
            // Print the menu
            PrintUtil.printHead("Text utils");
            System.out.println("!symbols-amount");
            System.out.println("!symbols-replacement");
            PrintUtil.printBorder("thin");
            PrintUtil.printBackClose();

            // Get String value
            String util = PrintUtil.printEnterUtil(utilInput);

            // Check the entered value and perform the following actions
            switch(util) {
                case "!symbols-amount":
                    PrintUtil.printDoneCase("!symbols-amount");
                    SymbolsAmountUtil.run();
                    break;
                case "!symbols-replacement":
                    PrintUtil.printDoneCase("!symbols-replacement");
                    SymbolsReplacementUtil.run();
                    break;
                case PrintUtil.CMD_BACK:
                case PrintUtil.CMD_CLOSE:
                    execute = false;
                    break;
                default:
                    // Print a message with an invalid value
                    PrintUtil.printInvalidValue();
                    break;
            }

            // Execute if a value is entered equal to the values CMD_BACK or CMD_CLOSE
            if(PrintUtil.doIfBack(util)) break;
            PrintUtil.doIfClose(util, utilInput);
        }
    }

}
