package pl.coderslab.beans;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Component
public class FileCustomerLogger implements CustomerLogger{
    String filename;

    public FileCustomerLogger(String filename){
        this.filename = filename;
    }
    @Override
    public void log(){

        try(PrintWriter printWriter = new PrintWriter(filename)){
            printWriter.append(LocalDateTime.now() + ": Customer operation");
        }catch (FileNotFoundException e){
            System.out.println("File not found");
        }
    }

}
