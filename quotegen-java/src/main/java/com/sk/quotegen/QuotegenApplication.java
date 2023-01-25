package com.sk.quotegen;

import com.sk.quotegen.repo.PersonsRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class QuotegenApplication  {

    @Autowired
    PersonsRepo personsRepo;

    public static void main(String[] args) {
        SpringApplication.run(QuotegenApplication.class, args);
        System.out.println("Hello");
    }


}
