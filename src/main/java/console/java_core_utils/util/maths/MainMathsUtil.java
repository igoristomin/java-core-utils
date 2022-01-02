package console.java_core_utils.util.maths;

import java.util.Scanner;
import static console.java_core_utils.util.PrintUtil.*;

public class MainMathsUtil {

    public static void run() {
        Scanner utilNameInput = new Scanner(System.in);
        String utilName = "";
        boolean execute = true;

        while (execute) {
            // Print menu
            printHead("Maths utils");
            System.out.println("!average");
            System.out.println("!composition");
            System.out.println("!difference");
            System.out.println("!exponentiation");
            System.out.println("!factorial");
            System.out.println("!less");
            System.out.println("!more");
            System.out.println("!quotient");
            System.out.println("!square-root");
            System.out.println("!sum");
            printBorder("thin");
            printBackClose();

            // Get String value
            utilName = printEnterUtil(utilName, utilNameInput);

            // Check entered value and perform actions
            switch (utilName) {
                case "!average":
                    printDoneCase("!average");
                    AverageUtil.run();
                    break;
                case "!composition":
                    printDoneCase("!composition");
                    CompositionUtil.run();
                    break;
                case "!difference":
                    printDoneCase("!difference");
                    DifferenceUtil.run();
                    break;
                case "!exponentiation":
                    printDoneCase("!exponentiation");
                    ExponentiationUtil.run();
                    break;
                case "!factorial":
                    printDoneCase("!factorial");
                    FactorialUtil.run();
                    break;
                case "!less":
                    printDoneCase("!less");
                    LessUtil.run();
                    break;
                case "!more":
                    printDoneCase("!more");
                    MoreUtil.run();
                    break;
                case "!quotient":
                    printDoneCase("!quotient");
                    QuotientUtil.run();
                    break;
                case "!square-root":
                    printDoneCase("!square-root");
                    SquareRootUtil.run();
                    break;
                case "!sum":
                    printDoneCase("!sum");
                    SumUtil.run();
                    break;
                case COMMAND_BACK:
                case COMMAND_CLOSE:
                    execute = false;
                    break;
                default:
                    // Print message with invalid value
                    printInvalidValue();
                    break;
            }

            // Do back or close
            if (backIf(utilName)) break;
            closeIf(utilName, utilNameInput);
        }
    }

}
