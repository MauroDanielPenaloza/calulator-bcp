package com.coralogix.calculator.services.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import io.reactivex.rxjava3.core.Observable;

import org.springframework.stereotype.Service;

import com.coralogix.calculator.controller.artifact.ExchangeRateResponse;
import com.coralogix.calculator.model.ExchangeRate;
import com.coralogix.calculator.repository.ExchangeRateRepository;
import com.coralogix.calculator.services.ApiCurrencyThirdPartyService;
import com.coralogix.calculator.services.ExchangeRateService;
import com.coralogix.calculator.services.impl.artifact.ApiCurrencyThirdPartyResponse;

@Service
public class ExchangeRateServiceImpl implements ExchangeRateService {

   private final ApiCurrencyThirdPartyService apiCurrencyThirdPartyService;
   private final ExchangeRateRepository exchangeRateRepository;

   public ExchangeRateServiceImpl(ApiCurrencyThirdPartyService apiCurrencyThirdPartyService, ExchangeRateRepository exchangeRateRepository) {
      this.apiCurrencyThirdPartyService = apiCurrencyThirdPartyService;
      this.exchangeRateRepository = exchangeRateRepository;
   }

   @Override
   public ExchangeRateResponse getExchangeRate(String originCurrency, String finalCurrency) {

      ExchangeRate exchangeRate = exchangeRateRepository
            .findOneByOriginCurrencyAndFinalCurrency(originCurrency, finalCurrency) // 3-
            .orElseGet(() -> {
               ApiCurrencyThirdPartyResponse apiResponse = apiCurrencyThirdPartyService.getFixerLatest(originCurrency, finalCurrency); //Blo
               ExchangeRate newExchangeRate = new ExchangeRate();
               newExchangeRate.setDate(apiResponse.getDate());
               newExchangeRate.setOriginCurrency(originCurrency);
               newExchangeRate.setFinalCurrency(finalCurrency);
               newExchangeRate.setValue(apiResponse.getRates().get(finalCurrency));
               return exchangeRateRepository.save(newExchangeRate);
            })
      ;


      return ExchangeRateResponse.mapFromEntity(exchangeRate);
   }

   @Override
   public List<ExchangeRateResponse> getAllExchangeRate() {
      return Observable
            .fromIterable(this.exchangeRateRepository.findAll())
            .map(ExchangeRateResponse::mapFromEntity)
            .blockingStream()
            .collect(Collectors.toList());

   }
}
