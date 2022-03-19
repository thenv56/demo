package com.example.demo.service;

import com.example.demo.model.Book;
import com.example.demo.repository.BookRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookServiceImpl implements BookService {
    @Autowired
    BookRepo bookRepo;
    @Override
    public Book save(Book book) {
        return bookRepo.save(book);
    }

    @Override
    public List<Book> saveAll(List<Book> books) {
        return bookRepo.saveAll(books);
    }

    @Override
    public Book getBook(Long id) {
        return bookRepo.findById(id).orElseThrow(()-> new NullPointerException("Not found in dâtbase"));
    }

    @Override
    public List<Book> getAll() {
        return bookRepo.findAll();
    }

    @Override
    public void deleteBook(Long id) {
        bookRepo.deleteById(id);
    }
}
