package pl.coderslab.beans;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.time.LocalDateTime;

@Qualifier("db")
@Component
public class DBCustomerLogger implements CustomerLogger{
    private static final String CREATE_CUSTOMER_QUERY =
            "INSERT INTO customers(logs) VALUES (?)";

    String DBUrl;
    String DBUser;
    String DBPassword;


    public DBCustomerLogger(String DBUrl, String DBUser, String DBPassword) {
        this.DBUrl = DBUrl;
        this.DBUser = DBUser;
        this.DBPassword = DBPassword;
    }

    @Override
    public void log(){
           try(Connection connection = DriverManager.getConnection(DBUrl, DBUser, DBPassword)) {

            PreparedStatement statement = connection.prepareStatement(CREATE_CUSTOMER_QUERY);
            statement.setString(1, String.valueOf(LocalDateTime.now()) + ": Customer operation");

            statement.executeUpdate();
           System.out.println("aaa");
           }catch (SQLException e){
               System.out.println("Data access problem");
           }
       };

}
