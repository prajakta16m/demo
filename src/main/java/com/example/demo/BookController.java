package com.example.demo;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BookController {

  @RequestMapping("/hello")
  String home() {
    return "Hello World. You will now get to see Books with ratings.";
  }

}
