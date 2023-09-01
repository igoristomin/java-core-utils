package igoristomin.javacoreutils.util;

import org.springframework.stereotype.Service;
import java.util.Scanner;

@Service
public class InputUtil {

    public static String inputValue() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }

}
