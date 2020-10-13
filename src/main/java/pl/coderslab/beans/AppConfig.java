package pl.coderslab.beans;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("pl.coderslab.beans")
public class AppConfig {


    @Bean
    public FileCustomerLogger fileCustomerLogger(){
        return new FileCustomerLogger("Users.txt", memoryCustomerRepository());
    }

    @Bean
    public SimpleCustomerLogger simpleCustomerLogger() {
        return new SimpleCustomerLogger();
    }

    @Bean
    public MemoryCustomerRepository memoryCustomerRepository() {
        return new MemoryCustomerRepository(simpleCustomerLogger());
    }
}
