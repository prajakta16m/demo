package com.example.demo;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.core.simple.JdbcClient;
import org.springframework.stereotype.Repository;

import jakarta.annotation.PostConstruct;

@Repository
public class BookRepository {

  private static final Logger logger = LoggerFactory.getLogger(BookRepository.class);
  private final JdbcClient jdbcClient;

  /**
   * This variable earlier held in-memmory books. We have no switched to h2
   * database
   */
  private List<Book> books = new ArrayList<>();

  public BookRepository(JdbcClient jdbcClient) {
    this.jdbcClient = jdbcClient;
  }

  List<Book> findAll() {
    // return books;
    return this.jdbcClient.sql("select * from book").query(Book.class).list();
  }

  public Optional<Book> findByBookName(String name) {
    // return books.stream().filter(book -> book.getBook() == name).findFirst();
    return this.jdbcClient.sql("select * from book where name= :name ")
        .param("name", name)
        .query(Book.class)
        .optional();
  }

  Optional<Book> findById(Integer id) {
    // return books.stream().filter(b -> b.getId() == id).findFirst();
    return this.jdbcClient.sql("select * from book where id= :id ")
        .param("id", id)
        .query(Book.class)
        .optional();
  }

  void createBook(Book bk) {
    // this.books.add(bk);

    /*
     * Adding / Creating data instance with namesd parameters.
     */
    var updated = this.jdbcClient.sql("INSERT INTO Book(id, book, rating) values (?,?,?)")
        .param(bk.getId())
        .param(bk.getBook())
        .param(bk.getRating())
        .update();

  }

  @PostConstruct
  private void init() {
    books.add(new Book(1, "Atomic Habits", 5));
    books.add(new Book(2, "Positive Mindset", 4));
  }

}
