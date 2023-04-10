package igoristomin.javacoreutils.util.maths;

import org.springframework.stereotype.Service;
import java.util.Scanner;
import static igoristomin.javacoreutils.util.PrintUtil.*;

@Service
class SumUtil {

    static void run() {
        Scanner numsInput = new Scanner(System.in);

        while(true) {
            // Print the menu
            printHead("Sum");
            printBackClose();

            // Get String value
            printEnterNums();
            String numsLine = numsInput.nextLine();

            // Execute if a value is entered equal to the values CMD_BACK or CMD_CLOSE
            if(doIfBack(numsLine)) break;
            doIfClose(numsLine, numsInput);

            // Convert String value to String array
            String[] numsLineSplit = numsLine
                    .replaceAll("\\s", "")
                    .split(",");

            double[] nums = new double[numsLineSplit.length];

            try {
                // Convert String array to double array
                for(int i = 0; i < numsLineSplit.length; i++) {
                    nums[i] = Double.parseDouble(numsLineSplit[i]);
                }

                // Get and format the result from the method
                String result = FORMAT_DECIMAL.format(getSum(nums));

                // Set the output format and print the result
                String resultOut = String.format("Sum of %s: %s", numsLine, result);
                printResult(resultOut);
            } catch(NumberFormatException ex) {
                // Print a message with an invalid value on exception
                printInvalidValue();
            }
        }
    }

    private static double getSum(double[] nums) {
        double result = 0;
        for(double num : nums) {
            result += num;
        }
        return result;
    }

}
