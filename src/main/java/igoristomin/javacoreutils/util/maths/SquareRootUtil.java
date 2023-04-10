package igoristomin.javacoreutils.util.maths;

import org.springframework.stereotype.Service;
import java.util.Scanner;
import static igoristomin.javacoreutils.util.PrintUtil.*;

@Service
class SquareRootUtil {

    static void run() {
        Scanner numInput = new Scanner(System.in);

        while(true) {
            // Print the menu
            printHead("Square root");
            printBackClose();

            // Get String value
            printEnterNum();
            String numLine = numInput.nextLine();

            // Execute if a value is entered equal to the values CMD_BACK or CMD_CLOSE
            if(doIfBack(numLine)) break;
            doIfClose(numLine, numInput);

            try {
                // Convert and get values, format the result from the method
                double num = Double.parseDouble(numLine);
                String result = FORMAT_DECIMAL.format(getRoot(num));

                // Set the output format and print the result
                String resultOut = String.format("Square root of %s: %s", numLine, result);
                printResult(resultOut);
            } catch(NumberFormatException ex) {
                // Print a message with an invalid value on exception
                printInvalidValue();
            }
        }
    }

    private static double getRoot(double num) {
        double tempResult, result;
        result = num / 2;

        do {
            tempResult = result;
            result = (result + (num / tempResult)) / 2;
        } while((tempResult - result) != 0);

        return result;
    }

}
