package com.inimeve.springbootgettingstarted.quotes;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class QuoteResource {

  private List<Quote> quotes;

  public QuoteResource() {
      //
  }


  public List<Quote> getQuotes() {
    return this.quotes;
  }

  public void setQuotes(List<Quote> quotes) {
    this.quotes = quotes;
  }

  @Override
  public String toString() {
    return "{" +
      " quotes='" + getQuotes() + "'" +
      "}";
  }

}