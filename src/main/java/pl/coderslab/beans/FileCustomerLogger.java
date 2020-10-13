package pl.coderslab.beans;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

@Component
@Primary
public class FileCustomerLogger implements CustomerLogger{
    String filename;
    MemoryCustomerRepository memoryCustomerRepository;
    public FileCustomerLogger(String filename, MemoryCustomerRepository memoryCustomerRepository){
        this.filename = filename;
        this.memoryCustomerRepository = memoryCustomerRepository;
    }
    @Override
    public void log(){

        try(PrintWriter printWriter = new PrintWriter(filename)){
            printWriter.append(memoryCustomerRepository.getCustomers().toString());
        }catch (FileNotFoundException e){
            System.out.println("File not found");
        }
    }

}
