package com.Infotrix.week1.Task1.Currency.Converter.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Service
public class CurrencyExchangeService {

    private final WebClient.Builder webClientBuilder;

    @Autowired
    public CurrencyExchangeService(WebClient.Builder webClientBuilder) {
        this.webClientBuilder = webClientBuilder;
    }

    public Mono<String> getExchangeRate(String baseCurrency, String targetCurrency) {
        return webClientBuilder.build()
                .get()
                .uri("https://api.exchangeratesapi.io/latest?base={base}&symbols={target}", baseCurrency, targetCurrency)
                .retrieve()
                .bodyToMono(String.class);
    }
}

