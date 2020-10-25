package pl.coderslab.app;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import pl.coderslab.beans.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class SpringDiApplication {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(AppConfig.class);

       /* SimpleCustomerLogger customerLogger = context.getBean("simpleCustomerLogger", SimpleCustomerLogger.class);
        customerLogger.log();

        MemoryCustomerRepository memoryCustomerRepository = context.getBean("memoryCustomerRepository", MemoryCustomerRepository.class);
        Customer customer1 = new Customer(1, "Marcin", "Kubik");
        Customer customer2 = new Customer(1, "Marcin", "Kkk");
        memoryCustomerRepository.addCustomer(customer1);
        memoryCustomerRepository.addCustomer(customer2);
        List<Customer> customers = memoryCustomerRepository.getCustomers();
        for (Customer c : customers){
            System.out.println(c);
        }*/


        DBCustomerLogger dbCustomerLogger = context.getBean("dbCustomerLogger", DBCustomerLogger.class);
        dbCustomerLogger.log();
        context.close();
    }
}
