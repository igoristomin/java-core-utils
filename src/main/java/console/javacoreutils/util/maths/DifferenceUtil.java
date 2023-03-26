package console.javacoreutils.util.maths;

import org.springframework.stereotype.Service;
import java.util.Scanner;
import static console.javacoreutils.util.PrintUtil.*;
import static console.javacoreutils.util.PrintUtil.printInvalidValue;

@Service
class DifferenceUtil {

    static void run() {
        Scanner numsInput = new Scanner(System.in);

        while(true) {
            // Print the menu
            printHead("Difference");
            printBackClose();

            // Get String value
            printEnterNums();
            String numsLine = numsInput.nextLine();

            // Do back or close
            if(backIf(numsLine)) break;
            closeIf(numsLine, numsInput);

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
                String result = DF.format(getDifference(nums));

                // Set the output format and print the result
                String resultOut = String.format("Difference of %s = %s", numsLine, result);
                printResult(resultOut);
            } catch(NumberFormatException ex) {
                // Print a message with an invalid value on exception
                printInvalidValue();
            }
        }
    }

    private static double getDifference(double[] nums) {
        double result = nums[0];
        for(int i = 1; i < nums.length; i++) {
            result -= nums[i];
        }
        return result;
    }

}
