package igoristomin.javacoreutils.util.maths;

import igoristomin.javacoreutils.util.PrintUtil;
import org.springframework.stereotype.Service;
import java.util.Scanner;

@Service
class CompositionUtil {

    static void run() {
        Scanner numsInput = new Scanner(System.in);

        while(true) {
            // Print the menu
            PrintUtil.printHead("Composition");
            PrintUtil.printBackClose();

            // Get String value
            PrintUtil.printEnterNums();
            String numsLine = numsInput.nextLine();

            // Do back or close
            if(PrintUtil.backIf(numsLine)) break;
            PrintUtil.closeIf(numsLine, numsInput);

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
                String result = PrintUtil.DF.format(getComposition(nums));

                // Set the output format and print the result
                String resultOut = String.format("Composition of %s = %s", numsLine, result);
                PrintUtil.printResult(resultOut);
            } catch(NumberFormatException ex) {
                // Print a message with an invalid value on exception
                PrintUtil.printInvalidValue();
            }
        }
    }

    private static double getComposition(double[] nums) {
        double result = 1;
        for(double num : nums) {
            result *= num;
        }
        return result;
    }

}