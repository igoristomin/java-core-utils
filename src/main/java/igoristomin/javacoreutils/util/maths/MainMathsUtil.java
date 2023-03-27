package igoristomin.javacoreutils.util.maths;

import igoristomin.javacoreutils.util.PrintUtil;
import org.springframework.stereotype.Service;
import java.util.Scanner;

@Service
public class MainMathsUtil {

    public static void run() {
        Scanner utilNameInput = new Scanner(System.in);
        String utilName = "";
        boolean execute = true;

        while(execute) {
            // Print the menu
            PrintUtil.printHead("Maths utils");
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
            PrintUtil.printBorder("thin");
            PrintUtil.printBackClose();

            // Get String value
            utilName = PrintUtil.printEnterUtil(utilName, utilNameInput);

            // Check the entered value and perform the following actions
            switch(utilName) {
                case "!average":
                    PrintUtil.printDoneCase("!average");
                    AverageUtil.run();
                    break;
                case "!composition":
                    PrintUtil.printDoneCase("!composition");
                    CompositionUtil.run();
                    break;
                case "!difference":
                    PrintUtil.printDoneCase("!difference");
                    DifferenceUtil.run();
                    break;
                case "!exponentiation":
                    PrintUtil.printDoneCase("!exponentiation");
                    ExponentiationUtil.run();
                    break;
                case "!factorial":
                    PrintUtil.printDoneCase("!factorial");
                    FactorialUtil.run();
                    break;
                case "!less":
                    PrintUtil.printDoneCase("!less");
                    LessUtil.run();
                    break;
                case "!more":
                    PrintUtil.printDoneCase("!more");
                    MoreUtil.run();
                    break;
                case "!quotient":
                    PrintUtil.printDoneCase("!quotient");
                    QuotientUtil.run();
                    break;
                case "!square-root":
                    PrintUtil.printDoneCase("!square-root");
                    SquareRootUtil.run();
                    break;
                case "!sum":
                    PrintUtil.printDoneCase("!sum");
                    SumUtil.run();
                    break;
                case PrintUtil.CMD_BACK:
                case PrintUtil.CMD_CLOSE:
                    execute = false;
                    break;
                default:
                    // Print a message with an invalid value
                    PrintUtil.printInvalidValue();
                    break;
            }

            // Do back or close
            if(PrintUtil.backIf(utilName)) break;
            PrintUtil.closeIf(utilName, utilNameInput);
        }
    }

}