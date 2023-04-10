package igoristomin.javacoreutils.util.maths;

import igoristomin.javacoreutils.util.PrintUtil;
import org.springframework.stereotype.Service;
import java.util.Scanner;

@Service
class ExponentiationUtil {

    static void run() {
        Scanner numInput = new Scanner(System.in);
        Scanner extentInput = new Scanner(System.in);

        while(true) {
            // Print the menu
            PrintUtil.printHead("Exponentiation");
            PrintUtil.printBackClose();

            try {
                // Get String value
                PrintUtil.printEnterNum();
                String numLine = numInput.nextLine();

                // Do back or close
                if(PrintUtil.doIfBack(numLine)) break;
                PrintUtil.closeIf(numLine, numInput);

                // Convert the value. Expect NumberFormatException
                double num = Double.parseDouble(numLine);

                // Get String value
                System.out.print("Enter the extent: ");
                String extentLine = extentInput.nextLine();

                // Do back or close
                if(PrintUtil.doIfBack(extentLine)) break;
                PrintUtil.closeIf(extentLine, extentInput);

                // Convert the value. Expect NumberFormatException
                double extent = Double.parseDouble(extentLine);

                // Get and format the result from the method
                String result = PrintUtil.DF.format(getExponentiation(num, extent));

                // Set the output format and print the result
                String resultOut = String.format("%s to the extent of %s: %s", numLine, extentLine, result);
                PrintUtil.printResult(resultOut);
            } catch(NumberFormatException ex) {
                // Print a message with an invalid value on exception
                PrintUtil.printInvalidValue();
            }
        }
    }

    private static double getExponentiation(double num, double extent) {
        double result = 1;
        for(int i = 1; i <= extent; i++) {
            result *= num;
        }
        return result;
    }

}
