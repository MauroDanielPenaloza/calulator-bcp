package com.coralogix.calculator.services;

import java.util.List;

import com.coralogix.calculator.controller.artifact.ExchangeRateResponse;

public interface ExchangeRateService {

   ExchangeRateResponse getExchangeRate(String originCurrency, String finalCurrency);

   List<ExchangeRateResponse> getAllExchangeRate();
}
