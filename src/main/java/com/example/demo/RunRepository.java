package com.example.demo;

import java.util.ArrayList;
import java.util.List;

public class RunRepository {

  private List<Book> runs = new ArrayList<>();

  List<Book> findAll() {
    return runs;
  }

}
