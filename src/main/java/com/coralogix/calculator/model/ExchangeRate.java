package com.coralogix.calculator.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name = "ExchangeRate")
public class ExchangeRate {

   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;
   @Column
   private String originCurrency;
   @Column
   private String finalCurrency;
   @Column
   private String date;
   @Column
   private String value;

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
}
