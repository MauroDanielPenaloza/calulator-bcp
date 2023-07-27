package com.coralogix.calculator.controller.artifact;


import com.coralogix.calculator.model.ExchangeRate;
import com.fasterxml.jackson.databind.ObjectMapper;

public class ExchangeRateResponse {
   private static ObjectMapper objectMapper = new ObjectMapper();
   private Long id;
   private String originCurrency;
   private String finalCurrency;
   private String date;
   private String value;
   private boolean success;

   public void setSuccess(boolean success) {
      this.success = success;
   }

   public boolean isSuccess() {
      return success;
   }

   public static ObjectMapper getObjectMapper() {
      return objectMapper;
   }

   public static void setObjectMapper(ObjectMapper objectMapper) {
      ExchangeRateResponse.objectMapper = objectMapper;
   }

   public Long getId() {
      return id;
   }

   public void setId(Long id) {
      this.id = id;
   }

   public String getOriginCurrency() {
      return originCurrency;
   }

   public void setOriginCurrency(String originCurrency) {
      this.originCurrency = originCurrency;
   }

   public String getFinalCurrency() {
      return finalCurrency;
   }

   public void setFinalCurrency(String finalCurrency) {
      this.finalCurrency = finalCurrency;
   }

   public String getDate() {
      return date;
   }

   public void setDate(String date) {
      this.date = date;
   }

   public String getValue() {
      return value;
   }

   public void setValue(String value) {
      this.value = value;
   }

   public static ExchangeRateResponse mapFromEntity(ExchangeRate entity) {
      ExchangeRateResponse exchangeRateResponse;
      exchangeRateResponse = objectMapper.convertValue(entity, ExchangeRateResponse.class);
      exchangeRateResponse.setSuccess(true);
      return exchangeRateResponse;
   }
}
