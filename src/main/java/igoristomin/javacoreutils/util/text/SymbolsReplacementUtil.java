package igoristomin.javacoreutils.util.text;

import org.springframework.stereotype.Service;
import java.util.Scanner;
import static igoristomin.javacoreutils.util.PrintUtil.*;

@Service
class SymbolsReplacementUtil {

    static void run() {
        Scanner textInput = new Scanner(System.in);
        Scanner symbolsInput = new Scanner(System.in);
        Scanner symbolsReplInput = new Scanner(System.in);

        while(true) {
            // Print the menu
            printHead("Symbols replacement");
            printBackClose();

            // Get String value
            printEnterText();
            String textLine = textInput.nextLine();

            // Execute if a value is entered equal to the values CMD_BACK or CMD_CLOSE
            if(doIfBack(textLine)) break;
            doIfClose(textLine, textInput);

            System.out.print("Enter symbols: ");
            String symbolsLine = symbolsInput.nextLine();

            // Execute if a value is entered equal to the values CMD_BACK or CMD_CLOSE
            if(doIfBack(symbolsLine)) break;
            doIfClose(symbolsLine, symbolsInput);

            System.out.print("Enter replacement symbols: ");
            String symbolsReplLine = symbolsReplInput.nextLine();

            // Execute if a value is entered equal to the values CMD_BACK or CMD_CLOSE
            if(doIfBack(symbolsReplLine)) break;
            doIfClose(symbolsReplLine, symbolsReplInput);

            // Get the result
            String result = textLine.replace(symbolsLine, symbolsReplLine);

            // Set the output format and print the result
            String resultOut = String.format("Replacement result: %s", result);
            printResult(resultOut);
        }
    }

}
