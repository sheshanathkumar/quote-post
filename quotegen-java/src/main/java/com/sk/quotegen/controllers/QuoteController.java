package com.sk.quotegen.controllers;

import com.sk.quotegen.model.ModelApiResponse;
import com.sk.quotegen.model.QuoteModel;
import com.sk.quotegen.service.QuoteService;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@Log
@RequestMapping("/api")
public class QuoteController {

    @Autowired
    QuoteService quoteService;


    @GetMapping("/test")
    public ResponseEntity<ModelApiResponse> getString () {
        return new ResponseEntity<>(new ModelApiResponse(200, "Success", "This is test body"), HttpStatus.OK);
    }

    @GetMapping("/get-quote")
    @CrossOrigin(origins = "http://localhost:3000")
    public ResponseEntity<ModelApiResponse> getRandomQuote (@RequestParam int id ) {
        log.info ("START");
        QuoteModel quote = quoteService.getQuoteEntityRandom(id);
        if ( quote != null) {
            log.info("END");
            return new ResponseEntity<>( new ModelApiResponse(200, "SUCCESS", quote) , HttpStatus.OK );
        } else {
            log.info("ERROR! no quote found");
            return new ResponseEntity<>( new ModelApiResponse(400, "FAILED", "No Quote Found") , HttpStatus.BAD_REQUEST );
        }
    }

}