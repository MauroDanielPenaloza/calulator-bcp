package com.coralogix.calculator.services;

import com.coralogix.calculator.services.impl.artifact.ApiCurrencyThirdPartyResponse;

public interface ApiCurrencyThirdPartyService {

   ApiCurrencyThirdPartyResponse getFixerLatest(String originCurrency, String finalCurrency);
}
