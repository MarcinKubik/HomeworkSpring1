package pl.coderslab.beans;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class MemoryCustomerRepository implements CustomerRepository{
    private final CustomerLogger customerLogger;
    List<Customer> customers;

    public MemoryCustomerRepository(CustomerLogger customerLogger){
        this.customerLogger = customerLogger;
        this.customers = new ArrayList<>();
    }

    public CustomerLogger getCustomerLogger(){
        return customerLogger;
    }
    @Override
    public void addCustomer(Customer customer){
        customerLogger.log();
        customers.add(customer);
    }

    @Override
    public void deleteCustomer(Customer customer){
        customerLogger.log();
        customers.remove(customer);
    }

    @Override
    public List<Customer> getCustomers(){
        customerLogger.log();
        return customers;
    }
}
