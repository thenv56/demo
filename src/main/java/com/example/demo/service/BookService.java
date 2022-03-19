package com.example.demo.service;

import com.example.demo.model.Book;

import java.util.List;

public interface BookService {
    Book save(Book book);
    List<Book> saveAll(List<Book> books);
    Book getBook(Long id);
    List<Book> getAll();
    void deleteBook(Long id);
}
