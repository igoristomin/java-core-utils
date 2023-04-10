package igoristomin.javacoreutils.util.maths;

import igoristomin.javacoreutils.util.PrintUtil;
import org.springframework.stereotype.Service;
import java.util.Scanner;

@Service
class FactorialUtil {

    static void run() {
        Scanner numInput = new Scanner(System.in);

        while(true) {
            // Print the menu
            PrintUtil.printHead("Factorial");
            PrintUtil.printBackClose();

            // Get String value
            PrintUtil.printEnterNum();
            String numLine = numInput.nextLine();

            // Execute if a value is entered equal to the values CMD_BACK or CMD_CLOSE
            if(PrintUtil.doIfBack(numLine)) break;
            PrintUtil.doIfClose(numLine, numInput);

            try {
                // Convert and get values, format the result from the method
                double num = Double.parseDouble(numLine);
                String result = PrintUtil.FORMAT_DECIMAL.format(getFactorial(num));

                // Set the output format and print the result
                String resultOut = String.format("Factorial of %s: %s", numLine, result);
                PrintUtil.printResult(resultOut);
            } catch(NumberFormatException ex) {
                // Print a message with an invalid value on exception
                PrintUtil.printInvalidValue();
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
