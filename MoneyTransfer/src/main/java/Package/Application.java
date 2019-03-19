package Package;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import java.sql.Connection;
import java.util.Properties;

@SpringBootApplication
@ComponentScan(basePackageClasses = CustomerController.class)
public class Application {

    public static void main(String[] args) {
        try {

            String test = "test";
        }
        catch(Exception ex)
        {

        }


        SpringApplication.run(Application.class, args);
    }
}
