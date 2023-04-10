package igoristomin.javacoreutils.util;

import igoristomin.javacoreutils.util.maths.MainMathsUtil;
import igoristomin.javacoreutils.util.text.MainTextUtil;
import org.springframework.stereotype.Service;
import java.util.Scanner;
import static igoristomin.javacoreutils.util.PrintUtil.*;

@Service
public class MainUtil {

    public static void run() {
        Scanner utilGroupInput = new Scanner(System.in);
        boolean execute = true;

        while(execute) {
            // Print the menu
            printHead("Java Core Utils");
            System.out.println("!maths");
            System.out.println("!text");
            printBorder("thin");
            System.out.println(CMD_CLOSE);
            printBorder("thin");

            // Get String value
            System.out.print("Enter a group of utils: ");
            String utilGroup = utilGroupInput.nextLine();

            // Check the entered value and perform the following actions
            switch(utilGroup) {
                case "!maths":
                    printDoneCase("!maths");
                    MainMathsUtil.run();
                    break;
                case "!text":
                    printDoneCase("!text");
                    MainTextUtil.run();
                    break;
                case CMD_CLOSE:
                    execute = false;
                    break;
                default:
                    // Print a message with an invalid value
                    printInvalidValue();
                    break;
            }

            // Choose !close
            doIfClose(utilGroup, utilGroupInput);
        }
    }

}
