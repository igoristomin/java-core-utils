package igoristomin.javacoreutils.util.maths;

import org.springframework.stereotype.Service;
import static igoristomin.javacoreutils.util.InputUtil.inputValue;
import static igoristomin.javacoreutils.util.PrintUtil.*;

@Service
public class MainMathsUtil {

    public static void run() {
        boolean execute = true;
        while(execute) {
            // Print the menu
            printHead("Maths utils");
            System.out.println("average");
            System.out.println("composition");
            System.out.println("difference");
            System.out.println("exponentiation");
            System.out.println("factorial");
            System.out.println("less");
            System.out.println("more");
            System.out.println("quotient");
            System.out.println("square-root");
            System.out.println("sum");
            printBorder("thin");
            printBackClose();

            // Print a message and get the entered value into the util
            printEnterUtil();
            String util = inputValue();

            // Check the util and perform the following actions
            switch(util) {
                case "average":
                    printDoneCase("average");
                    AverageUtil.run();
                    break;
                case "composition":
                    printDoneCase("composition");
                    CompositionUtil.run();
                    break;
                case "difference":
                    printDoneCase("difference");
                    DifferenceUtil.run();
                    break;
                case "exponentiation":
                    printDoneCase("exponentiation");
                    ExponentiationUtil.run();
                    break;
                case "factorial":
                    printDoneCase("factorial");
                    FactorialUtil.run();
                    break;
                case "less":
                    printDoneCase("less");
                    LessUtil.run();
                    break;
                case "more":
                    printDoneCase("more");
                    MoreUtil.run();
                    break;
                case "quotient":
                    printDoneCase("quotient");
                    QuotientUtil.run();
                    break;
                case "square-root":
                    printDoneCase("square-root");
                    SquareRootUtil.run();
                    break;
                case "sum":
                    printDoneCase("sum");
                    SumUtil.run();
                    break;
                case CMD_BACK:
                case CMD_CLOSE:
                    execute = false;
                    break;
                default:
                    // Print a message about an invalid value entered
                    printInvalidValue();
                    break;
            }

            // Execute if the util is equal to the CMD_BACK or CMD_CLOSE
            if(doIfBack(util)) break;
            doIfClose(util);
        }
    }

}
