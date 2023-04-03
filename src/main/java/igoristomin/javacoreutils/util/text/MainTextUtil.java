package igoristomin.javacoreutils.util.text;

import igoristomin.javacoreutils.util.PrintUtil;
import org.springframework.stereotype.Service;
import java.util.Scanner;

@Service
public class MainTextUtil {

    public static void run() {
        Scanner utilInput = new Scanner(System.in);
        String util = "";
        boolean execute = true;

        while(execute) {
            // Print the menu
            PrintUtil.printHead("Text utils");
            System.out.println("!symbols-amount");
            System.out.println("!symbols-replacement");
            PrintUtil.printBorder("thin");
            PrintUtil.printBackClose();

            // Get String value
            util = PrintUtil.printEnterUtil(util, utilInput);

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

            // Do back or close
            if(PrintUtil.backIf(util)) break;
            PrintUtil.closeIf(util, utilInput);
        }
    }

}
