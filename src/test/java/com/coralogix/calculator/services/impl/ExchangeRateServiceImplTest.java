package com.coralogix.calculator.services.impl;

import static org.junit.jupiter.api.Assertions.*;

import java.util.HashMap;
import java.util.Map;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.coralogix.calculator.repository.ExchangeRateRepository;
import com.coralogix.calculator.services.ApiCurrencyThirdPartyService;
import com.coralogix.calculator.services.impl.artifact.ApiCurrencyThirdPartyResponse;

@SpringBootTest
class ExchangeRateServiceImplTest {

   @Autowired
   ExchangeRateServiceImpl exchangeRateService;
   @Autowired
   ExchangeRateRepository exchangeRateRepository;
   @MockBean
   ApiCurrencyThirdPartyService apiCurrencyThirdPartyService;

   @BeforeAll()
   void beforeTest() {
      Map<String, String> rates = new HashMap<>();
      rates.put("EUR", "0.9578");
      Mockito.when(apiCurrencyThirdPartyService.getFixerLatest("USD", "EUR"))
            .thenReturn(ApiCurrencyThirdPartyResponse
                  .builder()
                  .base("USD")
                  .success("true")
                  .timestamp(1683733305L)
                  .date("2023-05-10")
                  .rates(rates)
                  .build()
            );

   }

   @Test
   void getExchangeRate() {


   }

   @Test
   void getAllExchangeRate() {
   }
}