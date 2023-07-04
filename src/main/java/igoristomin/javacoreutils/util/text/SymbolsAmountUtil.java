package igoristomin.javacoreutils.util.text;

import org.springframework.stereotype.Service;
import java.util.Scanner;
import static igoristomin.javacoreutils.util.PrintUtil.*;

@Service
class SymbolsAmountUtil {

    static void run() {
        Scanner textInput = new Scanner(System.in);

        while(true) {
            // Print the menu
            printHead("Symbols amount");
            printBackClose();

            // Get String value
            printEnterText();
            String textLine = textInput.nextLine();

            // Execute if a value is entered equal to the values CMD_BACK or CMD_CLOSE
            if(doIfBack(textLine)) break;
            doIfClose(textLine, textInput);

            // Get the results
            int symbolsAmount = textLine.length();
            int symbolsNoSpaces = textLine.replaceAll("\\s", "").length();
            int symbolsNoSpacesPunctMarks = textLine.replaceAll("\\s|\\p{Punct}", "").length();
            int wordsAmount = getWordsAmount(textLine);

            // Print the results
            System.out.printf("Symbols amount: %d%n", symbolsAmount);
            System.out.printf("Without spaces: %d%n", symbolsNoSpaces);
            System.out.printf("Without spaces and punctuation marks: %d%n", symbolsNoSpacesPunctMarks);
            System.out.printf("Words amount: %d%n", wordsAmount);
            printBorder("fat");
        }
    }

    private static int getWordsAmount(String text) {
        int result = 1;

        // Delete extra spaces
        text = text.replaceAll("^[\\s]+", "");
        text = text.replaceAll("\\s{2,}", " ");

        // Return 0 if no symbols are entered
        if(text.length() == 0) return result = 0;

        // Count words
        for(int i = 0; i < text.length() - 1; i++) {
            if(text.charAt(i) == ' ' && text.charAt(i + 1) != ' ') {
                result++;
            }
        }

        return result;
    }

}
