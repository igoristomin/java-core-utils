package igoristomin.javacoreutils.util.maths;

import org.springframework.stereotype.Service;
import java.util.Scanner;
import static igoristomin.javacoreutils.util.PrintUtil.*;

@Service
class QuotientUtil {

    static void run() {
        Scanner numsInput = new Scanner(System.in);

        while(true) {
            // Print the menu
            printHead("Quotient");
            printBackClose();

            // Print a message and get the entered value into the numsLine
            printEnterNums();
            String numsLine = numsInput.nextLine();

            // Execute if the numsLine is equal to the CMD_BACK or CMD_CLOSE
            if(doIfBack(numsLine)) break;
            doIfClose(numsLine, numsInput);

            // Convert the numsLine to a string array numsLineSplit
            String[] numsLineSplit = numsLine
                    .replaceAll("\\s", "")
                    .split(",");

            double[] nums = new double[numsLineSplit.length];
            try {
                // Convert the numsLineSplit to a double array
                for(int i = 0; i < numsLineSplit.length; i++) {
                    nums[i] = Double.parseDouble(numsLineSplit[i]);
                }

                // Format and get the result from the method
                String result = FORMAT_DECIMAL.format(getQuotient(nums));

                // Set the output format and print the result
                String resultOut = String.format("Quotient of %s: %s", numsLine, result);
                printResult(resultOut);
            } catch(NumberFormatException ex) {
                // Print a message about an invalid value entered
                printInvalidValue();
            }
        }
    }

    private static double getQuotient(double[] nums) {
        double result = nums[0];
        for(int i = 1; i < nums.length; i++) {
            result /= nums[i];
        }
        return result;
    }

}
