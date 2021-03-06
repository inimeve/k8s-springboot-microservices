package com.inimeve.springbootgettingstarted.quotes;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Quote {

  private String text;
  private String author;
  private String tag;

  public Quote() {
      //
  }

  public String getText() {
    return text;
  }

  public void setText(String text) {
    this.text = text;
  }

  public String getAuthor() {
    return author;
  }

  public void setAuthor(String author) {
    this.author = author;
  }

  public String getTag() {
    return this.tag;
  }

  public void setTag(String tag) {
    this.tag = tag;
  }

  @Override
  public String toString() {
    return "{" +
      " text='" + getText() + "'" +
      ", author='" + getAuthor() + "'" +
      ", tag='" + getTag() + "'" +
      "}";
  }

}