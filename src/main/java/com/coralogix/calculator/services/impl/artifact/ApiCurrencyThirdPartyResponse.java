package com.coralogix.calculator.services.impl.artifact;

import java.util.LinkedHashMap;
import java.util.Map;

import lombok.Builder;

/**
 * {
 * 	"success": true,
 * 	"timestamp": 1683733305,
 * 	"base": "USD",
 * 	"date": "2023-05-10",
 * 	"rates": {
 * 		"EUR": 0.95798
 *      }
 * }
 */

@Builder
public class ApiCurrencyThirdPartyResponse {

   private String success;
   private Long timestamp;
   private String base;
   private String date;

   private Map<String, String> rates;

   public String getSuccess() {
      return success;
   }

   public void setSuccess(String success) {
      this.success = success;
   }

   public Long getTimestamp() {
      return timestamp;
   }

   public void setTimestamp(Long timestamp) {
      this.timestamp = timestamp;
   }

   public String getBase() {
      return base;
   }

   public void setBase(String base) {
      this.base = base;
   }

   public String getDate() {
      return date;
   }

   public void setDate(String date) {
      this.date = date;
   }

   public Map<String, String> getRates() {
      return rates;
   }

   public void setRates(Map<String, String> rates) {
      this.rates = rates;
   }
}
