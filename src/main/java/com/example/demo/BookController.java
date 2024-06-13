package com.example.demo;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BookController {

  private final BookRepository bookRepository;

  public BookController(BookRepository bRepository) {
    bookRepository = bRepository;
  }

  @RequestMapping("/hello")
  String home() {
    return "Hello World. You will now get to see Books with ratings.";
  }

  @GetMapping("/api/books")
  List<Book> getAllBooks() {
    return bookRepository.findAll();
  }

}
