package com.example.demo;

public class Run {
  private String book;
  private Integer rating;

  public Run(String book, Integer rating) {
    this.book = book;
    this.rating = rating;
  }

  public String getBook() {
    return this.book;
  }

  public Integer getRating() {
    return this.rating;
  }

  public void setBook(String book) {
    this.book = book;
  }

  public void setRating(Integer rating) {
    this.rating = rating;
  }

  @Override
  public String toString() {
    return "Book{" +
        "book=" + this.book + "," +
        "rating=" + this.rating +
        "}";

  }
}
