package console.java_core_utils.util.maths;

import java.util.Scanner;
import static console.java_core_utils.util.PrintUtil.*;
import static console.java_core_utils.util.PrintUtil.printInvalidValue;

class MoreUtil {

    static void run() {
        Scanner numsInput = new Scanner(System.in);

        while (true) {
            // Print menu
            printHead("More");
            printBackClose();

            // Get String value
            printEnterNums();
            String numsLine = numsInput.nextLine(); // Set numsInput to String numsLine

            // Do back or close
            if (backIf(numsLine)) break;
            closeIf(numsLine, numsInput);

            // Convert String value to String[] array
            String[] numsLineSplit = numsLine
                    .replaceAll("\\s", "")
                    .split(",");

            double[] nums = new double[numsLineSplit.length];

            try {
                // Convert String[] array to double[] array
                for (int i = 0; i < numsLineSplit.length; i++) {
                    nums[i] = Double.parseDouble(numsLineSplit[i]);
                }

                // Get result from method
                double result = getMore(nums);

                // Set output format and print the result
                String resultOut = String.format("More of %s = " + FORMAT_RESULT, numsLine, result);
                printResult(resultOut);
            } catch (NumberFormatException e) {
                // Print message with invalid value on exception
                printInvalidValue();
            }
        }
    }

    private static double getMore(double[] nums) {
        double result = nums[0];
        for (int i = 1; i < nums.length - 1; i++) {
            if (result < nums[i]) result = nums[i];
        }
        return result;
    }

}
