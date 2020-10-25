package pl.coderslab.beans;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

@Configuration
@ComponentScan("pl.coderslab.beans")
public class AppConfig {



    @Bean
    public FileCustomerLogger fileCustomerLogger(){
        return new FileCustomerLogger("Users.txt");
    }

    @Bean
    public SimpleCustomerLogger simpleCustomerLogger() {
        return new SimpleCustomerLogger();
    }

    @Bean
    public MemoryCustomerRepository memoryCustomerRepository() {
        return new MemoryCustomerRepository(dbCustomerLogger());
    }

    @Bean
    public DBCustomerLogger dbCustomerLogger(){
        return new DBCustomerLogger("jdbc:mysql://localhost:3306/homeworkSpring1?useSSL=false&characterEncoding=utf8&serverTimezone=UTC",
                "root", "coderslab");
    }


}
