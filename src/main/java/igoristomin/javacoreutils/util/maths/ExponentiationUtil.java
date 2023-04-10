package igoristomin.javacoreutils.util.maths;

import org.springframework.stereotype.Service;
import java.util.Scanner;
import static igoristomin.javacoreutils.util.PrintUtil.*;

@Service
class ExponentiationUtil {

    static void run() {
        Scanner numInput = new Scanner(System.in);
        Scanner extentInput = new Scanner(System.in);

        while(true) {
            // Print the menu
            printHead("Exponentiation");
            printBackClose();

            try {
                // Get String value
                printEnterNum();
                String numLine = numInput.nextLine();

                // Execute if a value is entered equal to the values CMD_BACK or CMD_CLOSE
                if(doIfBack(numLine)) break;
                doIfClose(numLine, numInput);

                // Convert the value. Expect NumberFormatException
                double num = Double.parseDouble(numLine);

                // Get String value
                System.out.print("Enter the extent: ");
                String extentLine = extentInput.nextLine();

                // Execute if a value is entered equal to the values CMD_BACK or CMD_CLOSE
                if(doIfBack(extentLine)) break;
                doIfClose(extentLine, extentInput);

                // Convert the value. Expect NumberFormatException
                double extent = Double.parseDouble(extentLine);

                // Get and format the result from the method
                String result = FORMAT_DECIMAL.format(getExponentiation(num, extent));

                // Set the output format and print the result
                String resultOut = String.format("%s to the extent of %s: %s", numLine, extentLine, result);
                printResult(resultOut);
            } catch(NumberFormatException ex) {
                // Print a message with an invalid value on exception
                printInvalidValue();
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
