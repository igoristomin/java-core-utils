package console.java_core_utils.util.maths;

import java.util.Scanner;
import static console.java_core_utils.util.PrintUtil.*;

class FactorialUtil {

    static void run() {
        Scanner numInput = new Scanner(System.in);

        while(true) {
            // Print menu
            printHead("Factorial");
            printBackClose();

            // Get String value
            printEnterNum();
            String numLine = numInput.nextLine();

            // Do back or close
            if(backIf(numLine)) break;
            closeIf(numLine, numInput);

            try {
                // Convert values and get, format result from method
                double num = Double.parseDouble(numLine);
                String result = DF.format(getFactorial(num));

                // Set output format and print the result
                String resultOut = String.format("Factorial of %s = %s", numLine, result);
                printResult(resultOut);
            } catch(NumberFormatException e) {
                // Print message with invalid value on exception
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
