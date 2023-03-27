package igoristomin.javacoreutils;

import igoristomin.javacoreutils.util.MainUtil;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class JavaCoreUtilsApplication {

    public static void main(String[] args) {
        SpringApplication.run(JavaCoreUtilsApplication.class, args);
        MainUtil.run();
    }

}
