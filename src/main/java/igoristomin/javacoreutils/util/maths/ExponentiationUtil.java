package igoristomin.javacoreutils.util.maths;

import org.springframework.stereotype.Service;
import static igoristomin.javacoreutils.util.InputUtil.inputValue;
import static igoristomin.javacoreutils.util.PrintUtil.*;

@Service
class ExponentiationUtil {

    static void run() {
        while(true) {
            // Print the menu
            printHead("Exponentiation");
            printBackClose();

            try {
                // Print a message and get the entered value into the numLine
                printEnterNum();
                String numLine = inputValue();

                // Execute if the numLine is equal to the CMD_BACK or CMD_CLOSE
                if(doIfBack(numLine)) break;
                doIfClose(numLine);

                // Convert the numLine to a double number. Expect NumberFormatException
                double num = Double.parseDouble(numLine);

                // Print a message and get the entered value into the extentLine
                System.out.print("Enter the extent: ");
                String extentLine = inputValue();

                // Execute if the extentLine is equal to the CMD_BACK or CMD_CLOSE
                if(doIfBack(extentLine)) break;
                doIfClose(extentLine);

                // Convert the extentLine to a double number. Expect NumberFormatException
                double extent = Double.parseDouble(extentLine);

                // Format and get the result from the method
                String result = FORMAT_DECIMAL.format(getExponentiation(num, extent));

                // Set the output format and print the result
                String resultOut = String.format("%s to the extent of %s: %s", numLine, extentLine, result);
                printResult(resultOut);
            } catch(NumberFormatException ex) {
                // Print a message about an invalid value entered
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
