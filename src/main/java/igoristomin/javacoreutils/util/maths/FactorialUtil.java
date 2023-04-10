package igoristomin.javacoreutils.util.maths;

import org.springframework.stereotype.Service;
import java.util.Scanner;
import static igoristomin.javacoreutils.util.PrintUtil.*;

@Service
class FactorialUtil {

    static void run() {
        Scanner numInput = new Scanner(System.in);

        while(true) {
            // Print the menu
            printHead("Factorial");
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
                String result = FORMAT_DECIMAL.format(getFactorial(num));

                // Set the output format and print the result
                String resultOut = String.format("Factorial of %s: %s", numLine, result);
                printResult(resultOut);
            } catch(NumberFormatException ex) {
                // Print a message with an invalid value on exception
                printInvalidValue();
            }
        }
    }

    private static double getFactorial(double num) {
        int result = 1;
        for(int i = 1; i <= num; i++) {
            result *= i;
        }
        return result;
    }

}
