package igoristomin.javacoreutils.util.text;

import org.springframework.stereotype.Service;
import static igoristomin.javacoreutils.util.InputUtil.inputValue;
import static igoristomin.javacoreutils.util.PrintUtil.*;

@Service
class SymbolsAmountUtil {

    static void run() {
        while(true) {
            // Print the menu
            printHead("Symbols amount");
            printBackClose();

            // Print a message and get the entered value into the textLine
            printEnterText();
            String textLine = inputValue();

            // Execute if the textLine is equal to the CMD_BACK or CMD_CLOSE
            if(doIfBack(textLine)) break;
            doIfClose(textLine);

            // Get the results
            int symbolsAmount = textLine.length();
            int symbolsNotSpaces = textLine.replaceAll("\\s", "").length();
            int symbolsNotSpacesPunctMarks = textLine.replaceAll("\\s|\\p{Punct}", "").length();
            int wordsAmount = getWordsAmount(textLine);

            // Print the results
            System.out.printf("Symbols amount: %d%n", symbolsAmount);
            System.out.printf("Without spaces: %d%n", symbolsNotSpaces);
            System.out.printf("Without spaces and punctuation marks: %d%n", symbolsNotSpacesPunctMarks);
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
