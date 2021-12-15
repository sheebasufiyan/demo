package com.example.demo.controller;

import com.example.demo.entity.Book;
import com.example.demo.service.BookService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/book")
public class BookController {

//    private Map<Long, Book> map = new HashMap<>();
    BookService bookService=new BookService();

    @GetMapping("/all")
    public ResponseEntity<Collection<Book>> getAll() {
        return ResponseEntity.ok(bookService.getMap().values());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Book> getById(@PathVariable long id) {
        Book book = bookService.getMap().get(id);
        if (book == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(book);
    }

    @PostMapping("/insert")
    public ResponseEntity<Void> insert(@RequestBody Book book) {
        boolean result=bookService.insert(book);
        if (result) {
            return ResponseEntity.ok().build();
        }else {
        return ResponseEntity.badRequest().build();}
    }

    @PutMapping("/update")
    public ResponseEntity<Void> update(@RequestBody Book book) {
        boolean result=bookService.insert(book);
        if (result) {
            return ResponseEntity.ok().build();
        }else {
            return ResponseEntity.badRequest().build();}
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> delete(@PathVariable Book book) {
        boolean result=bookService.insert(book);
        if (result) {
            return ResponseEntity.ok().build();
        }else {
            return ResponseEntity.badRequest().build();}
    }

}
