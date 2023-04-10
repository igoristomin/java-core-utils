package igoristomin.javacoreutils.util.maths;

import igoristomin.javacoreutils.util.PrintUtil;
import org.springframework.stereotype.Service;
import java.util.Scanner;

@Service
class SquareRootUtil {

    static void run() {
        Scanner numInput = new Scanner(System.in);

        while(true) {
            // Print the menu
            PrintUtil.printHead("Square root");
            PrintUtil.printBackClose();

            // Get String value
            PrintUtil.printEnterNum();
            String numLine = numInput.nextLine();

            // Do back or close
            if(PrintUtil.doIfBack(numLine)) break;
            PrintUtil.doIfClose(numLine, numInput);

            try {
                // Convert and get values, format the result from the method
                double num = Double.parseDouble(numLine);
                String result = PrintUtil.DF.format(getRoot(num));

                // Set the output format and print the result
                String resultOut = String.format("Square root of %s: %s", numLine, result);
                PrintUtil.printResult(resultOut);
            } catch(NumberFormatException ex) {
                // Print a message with an invalid value on exception
                PrintUtil.printInvalidValue();
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
