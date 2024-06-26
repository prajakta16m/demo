package com.example.demo;

import java.io.IOException;
import java.io.InputStream;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

@Component
public class RunJsonDataLoader {

  private static final Logger logger = LoggerFactory.getLogger(RunJsonDataLoader.class);
  private BookRepository bookRepository;
  private ObjectMapper objectMapper;

  RunJsonDataLoader(BookRepository bookRepository, ObjectMapper objectMapper) {
    this.bookRepository = bookRepository;
    this.objectMapper = objectMapper;
  }

  /*
   * @Override
   * public void run(String... args) throws Exception {
   * System.out.println("");
   * // TODO Auto-generated method stub
   * throw new UnsupportedOperationException("Unimplemented method 'run'");
   * 
   * /*
   * try{
   * 
   * InputStream inputStream =
   * TypeReference.class.getResourceAsStream("/data/books.json");
   * Book allBooks = objectMapper.readValue(inputStream, Book.class);
   * 
   * 
   * 
   * } catch(IOException e) {
   * 
   * }
   * 
   * }
   */
}
