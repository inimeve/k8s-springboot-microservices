package com.inimeve.springbootgettingstarted;

import com.inimeve.springbootgettingstarted.quotes.QuoteResource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class SpringBootGettingStartedApplication {

	private static final Logger log = LoggerFactory.getLogger(SpringBootGettingStartedApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(SpringBootGettingStartedApplication.class, args);
	}

	@Bean
	public RestTemplate restTemplate(RestTemplateBuilder builder) {
		return builder.build();
	}

	@Bean
	public CommandLineRunner run(RestTemplate restTemplate) throws Exception {
		return args -> {
			QuoteResource quoteResource = restTemplate.getForObject("https://goquotes-api.herokuapp.com/api/v1/random?count=1", QuoteResource.class);

			log.info(quoteResource.getQuotes().get(0).toString());
		};
	}

}
