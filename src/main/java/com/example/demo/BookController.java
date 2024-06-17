package com.example.demo;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping("/api/books")
public class BookController {

  private final BookRepository bookRepository;

  public BookController(BookRepository bRepository) {
    bookRepository = bRepository;
  }

  @RequestMapping("/hello")
  String home() {
    return "Hello World. You will now get to see Books with ratings.";
  }

  @GetMapping("")
  List<Book> getAllBooks() {
    return bookRepository.findAll();
  }

  @GetMapping("/{id}")
  Book getBookById(@PathVariable Integer id) {

    Optional<Book> o = bookRepository.findById(id);
    if (o.isEmpty()) {
      throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Book not found");
    }
    return o.get();

  }

}
