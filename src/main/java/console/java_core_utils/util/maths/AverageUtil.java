package console.java_core_utils.util.maths;

import java.util.Scanner;
import static console.java_core_utils.util.PrintUtil.*;

class AverageUtil {

    static void run() {
        Scanner numsInput = new Scanner(System.in);

        while(true) {
            // Print the menu
            printHead("Average");
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
                String result = DF.format(getAverage(nums));

                // Set the output format and print the result
                String resultOut = String.format("Average of %s = %s", numsLine, result);
                printResult(resultOut);
            } catch(NumberFormatException ex) {
                // Print a message with an invalid value on exception
                printInvalidValue();
            }
        }
    }

    private static double getAverage(double[] nums) {
        double result = 0;
        for(double num : nums) {
            result += num;
        }
        return result / nums.length;
    }

}
