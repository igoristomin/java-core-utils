package igoristomin.javacoreutils.util.text;

import org.springframework.stereotype.Service;
import static igoristomin.javacoreutils.util.InputUtil.inputValue;
import static igoristomin.javacoreutils.util.PrintUtil.*;

@Service
class SymbolsReplacementUtil {

    static void run() {
        while(true) {
            // Print the menu
            printHead("Symbols replacement");
            printBackClose();

            // Print a message and get the entered value into the textLine
            printEnterText();
            String textLine = inputValue();

            // Execute if the textLine is equal to the CMD_BACK or CMD_CLOSE
            if(doIfBack(textLine)) break;
            doIfClose(textLine);

            // Print a message and get the entered value into the symbolsLine
            System.out.print("Enter symbols: ");
            String symbolsLine = inputValue();

            // Execute if the symbolsLine is equal to the CMD_BACK or CMD_CLOSE
            if(doIfBack(symbolsLine)) break;
            doIfClose(symbolsLine);

            // Print a message and get the entered value into the symbolsReplLine
            System.out.print("Enter replacement symbols: ");
            String symbolsReplLine = inputValue();

            // Execute if the symbolsReplLine is equal to the CMD_BACK or CMD_CLOSE
            if(doIfBack(symbolsReplLine)) break;
            doIfClose(symbolsReplLine);

            // Get the result
            String result = textLine.replace(symbolsLine, symbolsReplLine);

            // Set the output format and print the result
            String resultOut = String.format("Replacement result: %s", result);
            printResult(resultOut);
        }
    }

}
