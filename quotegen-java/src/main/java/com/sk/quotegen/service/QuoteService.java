package com.sk.quotegen.service;

import com.sk.quotegen.entity.Persons;
import com.sk.quotegen.entity.QuoteEntity;
import com.sk.quotegen.model.QuoteModel;
import com.sk.quotegen.repo.PersonsRepo;
import com.sk.quotegen.repo.QuoteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.xml.crypto.Data;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Time;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.concurrent.TimeUnit;

@Service
public class QuoteService {

    SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");

    @Autowired
    QuoteRepository quoteRepository;

    @Autowired
    PersonsRepo personsRepo;

    Random random = new Random();

    public QuoteModel getQuoteEntityRandom(int id) {


        try {

            Persons person = personsRepo.findByPid(id);


            List<QuoteEntity> quotes = quoteRepository.findAll();
            QuoteEntity quote = quotes.get(random.nextInt(quotes.size()));
            String usedAt = quote.getUsedAt().toString();
            String currTime = new Timestamp(System.currentTimeMillis()).toString();

            System.out.println(usedAt + "      " + currTime);
            Date d1 = sdf.parse(usedAt);
            Date d2 = sdf.parse(currTime);

            long diff = d2.getTime() - d1.getTime();

            String lastUsed = getLastUsed (diff) ;



            return QuoteModel.builder()
                    .username("@"+person.getUsername()).name(person.getUser()).image(person.getImage())
                    .quote(quote.getQuote()).author(quote.getAuthor()).category(quote.getCategory()).createdAt(d1.toString())
                    .lastUsed(lastUsed)
                    .build();

        } catch (Exception e) {
            return null;
        }
    }

    private String getLastUsed(long diff) {

        String res = "";
        long daysDiff = TimeUnit.MILLISECONDS.toDays(diff) % 365;
        long yearDiff = TimeUnit.MILLISECONDS.toDays(diff) % 365l;
        long hourDiff = TimeUnit.MILLISECONDS.toHours(diff) % 24;
        long minDiff = TimeUnit.MILLISECONDS.toMinutes(diff) % 60;
        long secDiff = TimeUnit.MILLISECONDS.toSeconds(diff) % 60;

        Map<String, Long> timeMap = new LinkedHashMap<>();
        timeMap.put("year", yearDiff);
        timeMap.put("days", daysDiff);
        timeMap.put("hrs", hourDiff);
        timeMap.put("min", minDiff);
        timeMap.put("seconds", secDiff);

        for (Map.Entry<String, Long> entry : timeMap.entrySet()) {
            if (entry.getValue() != 0 ) {
                res = res + entry.getValue() + entry.getKey() +" ";
            }
        }
        return res ;

    }

}
