package pl.coderslab.beans;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class MemoryCustomerRepository implements CustomerRepository{
    private final CustomerLogger customerLogger;
    List<Customer> customers;

    @Autowired
    public MemoryCustomerRepository(CustomerLogger customerLogger){
        this.customerLogger = customerLogger;
        this.customers = new ArrayList<>();
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
