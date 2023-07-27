package com.coralogix.calculator.services.impl;

import java.net.URI;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.coralogix.calculator.services.ApiCurrencyThirdPartyService;
import com.coralogix.calculator.services.impl.artifact.ApiCurrencyThirdPartyResponse;

@Service
public class ApiCurrencyThirdPartyServiceImpl implements ApiCurrencyThirdPartyService {
   @Value("${app.endpoints.api.rate}")
   private String endpointRate;

   @Override
   public ApiCurrencyThirdPartyResponse getFixerLatest(String originCurrency, String finalCurrency) {
      RestTemplate restTemplate = new RestTemplate();
      String url =  endpointRate.replace("$MO", originCurrency).replace("$MD", finalCurrency);
      return restTemplate.getForObject(url, ApiCurrencyThirdPartyResponse.class);
   }
}
