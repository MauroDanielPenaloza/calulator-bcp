package com.coralogix.calculator.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.coralogix.calculator.controller.artifact.ExchangeRateResponse;
import com.coralogix.calculator.services.ExchangeRateService;

@RestController
@RequestMapping("exchange-rate")
public class ExchangeRateController {

   private final ExchangeRateService exchangeRateService;

   public ExchangeRateController(ExchangeRateService exchangeRateService) {
      this.exchangeRateService = exchangeRateService;
   }

   @GetMapping("one")
   public ExchangeRateResponse getExchangeRate(@RequestParam("originCurrency") String originCurrency,
         @RequestParam("finalCurrency") String finalCurrency) {
      ExchangeRateResponse exchangeRateResponse = exchangeRateService.getExchangeRate(originCurrency, finalCurrency);
      return exchangeRateResponse;
   }
   @GetMapping("all")
   public List<ExchangeRateResponse> getAllExchangeRate() {
      List<ExchangeRateResponse> exchangeRateResponse = exchangeRateService.getAllExchangeRate();
      return exchangeRateResponse;
   }

}
