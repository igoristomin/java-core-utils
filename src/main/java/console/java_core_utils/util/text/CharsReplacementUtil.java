package console.java_core_utils.util.text;

import java.util.Scanner;
import static console.java_core_utils.util.PrintUtil.*;

class CharsReplacementUtil {

    static void run() {
        Scanner textInput = new Scanner(System.in);
        Scanner charsInput = new Scanner(System.in);
        Scanner charsReplInput = new Scanner(System.in);

        while(true) {
            // Print menu
            printHead("Chars replacement");
            printBackClose();

            // Get String value
            printEnterText();
            String textLine = textInput.nextLine();

            // Do back or close
            if(backIf(textLine)) break;
            closeIf(textLine, textInput);

            System.out.print("Enter chars: ");
            String charsLine = charsInput.nextLine();

            // Do back or close
            if(backIf(charsLine)) break;
            closeIf(charsLine, charsInput);

            System.out.print("Enter replacement chars: ");
            String charsReplLine = charsReplInput.nextLine();

            // Do back or close
            if(backIf(charsReplLine)) break;
            closeIf(charsReplLine, charsReplInput);

            // Get result
            String result = textLine.replace(charsLine, charsReplLine);

            // Set output format and print the result
            String resultOut = String.format("Replacement result: %s", result);
            printResult(resultOut);
        }
    }

}
