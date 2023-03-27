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

            // Do back or close
            if(PrintUtil.backIf(numLine)) break;
            PrintUtil.closeIf(numLine, numInput);

            try {
                // Convert and get values, format the result from the method
                double num = Double.parseDouble(numLine);
                String result = PrintUtil.DF.format(getFactorial(num));

                // Set the output format and print the result
                String resultOut = String.format("Factorial of %s = %s", numLine, result);
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
