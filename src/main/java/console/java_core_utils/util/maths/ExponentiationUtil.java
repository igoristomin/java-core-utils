package console.java_core_utils.util.maths;

import java.util.Scanner;
import static console.java_core_utils.util.PrintUtil.*;

class ExponentiationUtil {

    static void run() {
        Scanner numInput = new Scanner(System.in);
        Scanner extentInput = new Scanner(System.in);

        while (true) {
            // Print menu
            printHead("Exponentiation");
            printBackClose();

            try {
                // Get String value
                printEnterNum();
                String numLine = numInput.nextLine();

                // Do back or close
                if (backIf(numLine)) break;
                closeIf(numLine, numInput);

                // Convert value. Expect NumberFormatException
                double num = Double.parseDouble(numLine);

                // Get String value
                System.out.print("Enter the extent: ");
                String extentLine = extentInput.nextLine();

                // Do back or close
                if (backIf(extentLine)) break;
                closeIf(extentLine, extentInput);

                // Convert value. Expect NumberFormatException
                double extent = Double.parseDouble(extentLine);

                // Get and format result from method
                String result = DF.format(getExponentiation(num, extent));

                // Set output format and print the result
                String resultOut = String.format("%s to the extent of %s = %s", numLine, extentLine, result);
                printResult(resultOut);
            } catch (NumberFormatException e) {
                // Print message with invalid value on exception
                printInvalidValue();
            }
        }
    }

    private static double getExponentiation(double num, double extent) {
        double result = 1;
        for (int i = 1; i <= extent; i++) {
            result *= num;
        }
        return result;
    }

}
