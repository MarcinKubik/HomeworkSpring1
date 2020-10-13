package pl.coderslab.beans;

import java.sql.*;

public class DBCustomerLogger implements CustomerLogger{
    private static final String CREATE_CUSTOMER_QUERY =
            "INSERT INTO customers(id, firstName, lastName) VALUES (?, ?, ?)";

    String DBUrl;
    String DBUser;
    String DBPassword;
    MemoryCustomerRepository memoryCustomerRepository;

    public DBCustomerLogger(String DBUrl, String DBUser, String DBPassword, MemoryCustomerRepository memoryCustomerRepository) {
        this.DBUrl = DBUrl;
        this.DBUser = DBUser;
        this.DBPassword = DBPassword;
        this.memoryCustomerRepository = memoryCustomerRepository;
    }

    @Override
    public void log(){
       memoryCustomerRepository.getCustomers().forEach(customer ->{
           try(Connection connection = DriverManager.getConnection(DBUrl, DBUser, DBPassword)) {

           }catch (SQLException e){
               System.out.println("Data access problem");
           }
       });
    }
}
