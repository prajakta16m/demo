package com.example.demo;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.ResponseBody;

import jakarta.annotation.PostConstruct;

@Repository
public class BookRepository {

  private List<Book> books = new ArrayList<>();

  List<Book> findAll() {
    return books;
  }

  Optional<Book> findByBookName(String name) {
    return books.stream().filter(book -> book.getBook() == name).findFirst();
  }

  Optional<Book> findById(Integer id) {
    return books.stream().filter(b -> b.getId() == id).findFirst();
  }

  void createBook(Book bk) {
    this.books.add(bk);
  }

  @PostConstruct
  private void init() {
    books.add(new Book(1, "Atomic Habits", 5));
    books.add(new Book(2, "Positive Mindset", 4));
  }

}
