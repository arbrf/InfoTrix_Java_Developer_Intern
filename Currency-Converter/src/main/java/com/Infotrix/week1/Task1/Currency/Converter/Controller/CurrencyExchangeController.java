package com.Infotrix.week1.Task1.Currency.Converter.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.Infotrix.week1.Task1.Currency.Converter.Service.CurrencyExchangeService;

import reactor.core.publisher.Mono;

@RestController
public class CurrencyExchangeController {

    private final CurrencyExchangeService currencyExchangeService;

    @Autowired
    public CurrencyExchangeController(CurrencyExchangeService currencyExchangeService) {
        this.currencyExchangeService = currencyExchangeService;
    }

    @GetMapping("/exchange-rate")
    public Mono<String> getExchangeRate(@RequestParam String baseCurrency, @RequestParam String targetCurrency) {
        return currencyExchangeService.getExchangeRate(baseCurrency, targetCurrency);
    }
}
