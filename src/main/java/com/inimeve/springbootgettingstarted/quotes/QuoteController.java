package com.inimeve.springbootgettingstarted.quotes;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/quotes")
public class QuoteController {

    private final AtomicLong counter = new AtomicLong();

    @GetMapping("/")
    public Quote getQuote() {
        RestTemplate restTemplate = new RestTemplate();

        QuoteResource quoteResource = restTemplate.getForObject("https://goquotes-api.herokuapp.com/api/v1/random?count=1", QuoteResource.class);

        return quoteResource.getQuotes().get(0);
    }

}
