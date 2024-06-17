package com.example.demo;

public class Book {
  private Integer id;
  private String book;
  private Integer rating;

  public Book(Integer id, String book, Integer rating) {
    this.id = id;
    this.book = book;
    this.rating = rating;
  }

  public Integer getId() {
    return this.id;
  }

  public void setId(Integer i) {
    this.id = i;
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
        "id=" + this.id + "," +
        "book=" + this.book + "," +
        "rating=" + this.rating +
        "}";

  }
}
