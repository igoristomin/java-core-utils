package console.java_core_utils.util.maths;

import java.util.Scanner;
import static console.java_core_utils.util.PrintUtil.*;
import static console.java_core_utils.util.PrintUtil.printInvalidValue;

class SquareRootUtil {

    static void run() {
        Scanner numInput = new Scanner(System.in);

        while(true) {
            // Print menu
            printHead("Square root");
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
                String result = DF.format(getRoot(num));

                // Set output format and print the result
                String resultOut = String.format("Square root of %s = %s", numLine, result);
                printResult(resultOut);
            } catch(NumberFormatException e) {
                // Print message with invalid value on exception
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
