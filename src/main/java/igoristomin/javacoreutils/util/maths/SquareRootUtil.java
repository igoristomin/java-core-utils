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

            // Print a message and get the entered value into the numLine
            printEnterNum();
            String numLine = numInput.nextLine();

            // Execute if the numLine is equal to the CMD_BACK or CMD_CLOSE
            if(doIfBack(numLine)) break;
            doIfClose(numLine, numInput);

            try {
                // Convert the numLine to a double number
                double num = Double.parseDouble(numLine);

                // Format and get the result from the method
                String result = FORMAT_DECIMAL.format(getRoot(num));

                // Set the output format and print the result
                String resultOut = String.format("Square root of %s: %s", numLine, result);
                printResult(resultOut);
            } catch(NumberFormatException ex) {
                // Print a message about an invalid value entered
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
