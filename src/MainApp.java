import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import print.Print;

import java.io.File;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.util.Scanner;

public class MainApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ApplicationContext context =
                new ClassPathXmlApplicationContext("spring-config.xml");
        System.out.println("select the output type: web or console");
        String type = scanner.next();
        String typeOfInput = type.trim();
        Print printer = (Print) context.getBean(typeOfInput);

        switch (typeOfInput) {
            case "web": {
                try (PrintWriter e = new PrintWriter("calendar.html")) {
                    e.append(printer.print());
                } catch (Exception e) {
                    e.getMessage();
                }
                break;
            }
            case "console": {
                System.out.println(printer.print());
            }
        }
    }
}
