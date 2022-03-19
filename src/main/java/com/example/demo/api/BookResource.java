package com.example.demo.api;

import com.example.demo.model.Book;
import com.example.demo.repository.BookRepo;
import com.example.demo.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class BookResource {

    @Autowired
    BookService bookService;
    @Autowired
    BookRepo bookRepo;

    @PostMapping("/book/create")
    public ResponseEntity<Book> createBook(@RequestBody Book book) {
        Book result = bookService.save(book);
        return ResponseEntity.ok().body(result);
    }

    @GetMapping("/book/all")
    public ResponseEntity<List<Book>> getAll() {
        List<Book> list = bookService.getAll();
        return ResponseEntity.ok().body(list);
    }

    @PostMapping("/book/add/list")
    public ResponseEntity<List<Book>> createAll(@RequestBody List<Book> books) {
        List<Book> list = bookService.saveAll(books);
        return ResponseEntity.ok().body(list);
    }
// test commit
    @GetMapping("/book/author/{id}")
    public ResponseEntity<?> getAuthorName(@PathVariable(name = "id") Long id) {
        Book book = bookService.getBook(id);
        String authorName = book.getAuthorName();
        return ResponseEntity.ok().body(authorName);
    }
}
