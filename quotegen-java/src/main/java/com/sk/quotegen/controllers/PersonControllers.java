package com.sk.quotegen.controllers;

import com.sk.quotegen.entity.Persons;
import com.sk.quotegen.model.ModelApiResponse;
import com.sk.quotegen.repo.PersonsRepo;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Log
@RestController
@RequestMapping("/api")
public class PersonControllers {


    @Autowired
    PersonsRepo personsRepo;


    @GetMapping ("/login")
    public ResponseEntity<ModelApiResponse> getLogin (@RequestParam String username, @RequestParam String password ) {
        log.info("START username: "+ username);
        Persons persons = personsRepo.findByUsernameAndPasscode(username, password);
        if (persons != null) {
            return new ResponseEntity<>(new ModelApiResponse(200, "SUCCESS", "Login Success"), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(new ModelApiResponse(400, "FAILED", "Login Failed"), HttpStatus.BAD_REQUEST);
        }
    }



}
