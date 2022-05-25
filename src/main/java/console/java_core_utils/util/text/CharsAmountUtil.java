package console.java_core_utils.util.text;

import java.util.Scanner;
import static console.java_core_utils.util.PrintUtil.*;

class CharsAmountUtil {

    static void run() {
        Scanner textInput = new Scanner(System.in);

        while(true) {
            // Print the menu
            printHead("Chars amount");
            printBackClose();

            // Get String value
            printEnterText();
            String textLine = textInput.nextLine();

            // Do back or close
            if(backIf(textLine)) break;
            closeIf(textLine, textInput);

            // Get the results
            int charAmount = textLine.length();
            int charNoSpace = textLine.replaceAll("\\s", "").length();
            int charNoSpacePm = textLine.replaceAll("\\s|\\p{Punct}", "").length();
            int wordAmount = getWordAmount(textLine);

            // Print the results
            System.out.println("Chars amount = " + charAmount);
            System.out.println("Without spaces = " + charNoSpace);
            System.out.println("Without spaces and punctuation marks = " + charNoSpacePm);
            System.out.println("Words amount = " + wordAmount);
            printBorder("fat");
        }
    }

    private static int getWordAmount(String text) {
        int result = 1;

        // Delete extra spaces
        text = text.replaceAll("^[\\s]+", "");
        text = text.replaceAll("\\s{2,}", " ");

        // Return 0 if no characters are entered
        if(text.length() == 0) return result = 0;

        // Count words
        for(int i = 0; i < text.length() - 1; i++) {
            if(text.charAt(i) == ' ' && text.charAt(i+1) != ' ') {
                result++;
            }
        }

        return result;
    }

}
