package com.example.useremployee.config;

import com.example.useremployee.model.Employee;
import com.example.useremployee.model.Gender;
import com.example.useremployee.model.User;
import com.example.useremployee.repositories.EmployeeRepository;
import com.example.useremployee.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class InitData implements CommandLineRunner {

    @Autowired
    UserRepository userRepository;

    @Autowired
    EmployeeRepository employeeRepository;


    public void saveWithCascadeAll() {
        User us1 = new User();
        us1.setEmail("Mathilde@gmail.com");
        us1.setPassword("12341234");
        //userRepository.save(us1);

        Employee emp1 = new Employee();
        emp1.setBorn(LocalDateTime.of(1996, 12, 30, 1, 20, 01));
        emp1.setName("Mathilde");
        emp1.setGender(Gender.MALE);
        emp1.setVegetarian(true);
        emp1.setUser(us1);
        //employeeRepository.save(emp1);
        us1.setEmployee(emp1);
        userRepository.save(us1);
    }

    public void saveNoCascadeAll() {
        User us1 = new User();
        us1.setEmail("Nielsen@hotmail.com");
        us1.setPassword("12345");
        userRepository.save(us1);

        Employee emp1 = new Employee();
        emp1.setBorn(LocalDateTime.of(2000, 3, 10, 01, 10, 13));
        emp1.setName("Jens");
        emp1.setGender(Gender.MALE);
        emp1.setVegetarian(true);
        emp1.setUser(us1);
        employeeRepository.save(emp1);
        us1.setEmployee(emp1);
        //userRepository.save(us1);

    }


    @Override
    public void run(String... args) throws Exception {
        saveWithCascadeAll();

    }
}
