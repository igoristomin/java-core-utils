package console.javacoreutils.util.text;

import java.util.Scanner;
import static console.javacoreutils.util.PrintUtil.*;

class SymbolsAmountUtil {

    static void run() {
        Scanner textInput = new Scanner(System.in, "UTF-8");

        while(true) {
            // Print the menu
            printHead("Symbols amount");
            printBackClose();

            // Get String value
            printEnterText();
            String textLine = textInput.nextLine();

            // Do back or close
            if(backIf(textLine)) break;
            closeIf(textLine, textInput);

            // Get the results
            int symbolsAmount = textLine.length();
            int symbolsNoSpaces = textLine.replaceAll("\\s", "").length();
            int symbolsNoSpacesPunctMarks = textLine.replaceAll("\\s|\\p{Punct}", "").length();
            int wordsAmount = getWordsAmount(textLine);

            // Print the results
            System.out.println("Symbols amount = " + symbolsAmount);
            System.out.println("Without spaces = " + symbolsNoSpaces);
            System.out.println("Without spaces and punctuation marks = " + symbolsNoSpacesPunctMarks);
            System.out.println("Words amount = " + wordsAmount);
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
