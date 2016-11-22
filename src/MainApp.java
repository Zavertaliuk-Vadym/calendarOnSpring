import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import print.Print;

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
        Print obj = (Print) context.getBean(typeOfInput);

        System.out.println("Select your year:");
        int year = scanner.nextInt();
        System.out.println("Select your month:");
        int month = scanner.nextInt();
        System.out.println("Select your day:");
        int day = scanner.nextInt();
        obj.setToday(LocalDate.of(year,month,day));
        System.out.println(obj.print());
        Print obj1 = (Print) context.getBean(typeOfInput);

        System.out.println(obj1.print());
    }
}
