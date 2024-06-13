package com.example.demo;

import java.util.ArrayList;
import java.util.List;

import jakarta.annotation.PostConstruct;

public class BookRepository {

  private List<Book> books = new ArrayList<>();

  List<Book> findAll() {
    return books;
  }

  @PostConstruct
  private void init() {
    books.add(new Book("Atomic Habits", 5));
    books.add(new Book("Positive Mindset", 4));
  }

}
