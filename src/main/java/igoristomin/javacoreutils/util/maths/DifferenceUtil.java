package igoristomin.javacoreutils.util.maths;

import igoristomin.javacoreutils.util.PrintUtil;
import org.springframework.stereotype.Service;
import java.util.Scanner;

@Service
class DifferenceUtil {

    static void run() {
        Scanner numsInput = new Scanner(System.in);

        while(true) {
            // Print the menu
            PrintUtil.printHead("Difference");
            PrintUtil.printBackClose();

            // Get String value
            PrintUtil.printEnterNums();
            String numsLine = numsInput.nextLine();

            // Do back or close
            if(PrintUtil.doIfBack(numsLine)) break;
            PrintUtil.doIfClose(numsLine, numsInput);

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
                String result = PrintUtil.FORMAT_DECIMAL.format(getDifference(nums));

                // Set the output format and print the result
                String resultOut = String.format("Difference of %s: %s", numsLine, result);
                PrintUtil.printResult(resultOut);
            } catch(NumberFormatException ex) {
                // Print a message with an invalid value on exception
                PrintUtil.printInvalidValue();
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
