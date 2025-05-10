package com.spring.boot;

import com.spring.boot.dto.Employee;
import com.spring.boot.repository.EmployeeDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Hello world!
 *
 */
@SpringBootApplication
public class SpringBootApp implements CommandLineRunner {

    @Autowired
    private EmployeeDao employeeDao;

    public static void main( String[] args ) {
        SpringApplication.run(SpringBootApp.class);
        System.out.println( "Hello Your SpringBootApp has Initialize!" );
    }

    @Override
    public void run(String... args) throws Exception {
        employeeDao.setEmployee(new Employee(1, "Neeraj"));
        employeeDao.setEmployee(new Employee(2,"Shweta"));
        employeeDao.setEmployee(new Employee(3,"Ditya"));
    }
}
