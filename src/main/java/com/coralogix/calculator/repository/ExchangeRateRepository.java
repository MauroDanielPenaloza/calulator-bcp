package com.coralogix.calculator.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.coralogix.calculator.model.ExchangeRate;

public interface ExchangeRateRepository extends CrudRepository<ExchangeRate, Long> {

   Optional<ExchangeRate> findOneByOriginCurrencyAndFinalCurrency(String originCurrency, String finalCurrency);
}
