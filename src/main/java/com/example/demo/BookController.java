package com.example.demo;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

@RestController
@ControllerAdvice
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
      // throw new ResponseStatusException(HttpStatus.NOT_FOUND, "This Book not
      // found");
      throw new CustomException("Book not found");
    }
    return o.get();

  }

  @PostMapping("/create")
  @ResponseStatus(HttpStatus.CREATED)
  void createBook(@RequestBody Book book) {
    bookRepository.createBook(book);
  }

  @ExceptionHandler(value = CustomException.class)
  public ResponseEntity<ApiError> handleNoBookFoundException() {
    ApiError err = new ApiError(400, "Your Book not Found");
    return new ResponseEntity<ApiError>(err, HttpStatus.BAD_REQUEST);
  }

}
