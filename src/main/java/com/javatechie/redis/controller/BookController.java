package com.javatechie.redis.controller;

import com.javatechie.redis.entity.Book;
import com.javatechie.redis.respository.BookDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/book")
public class BookController {
    @Autowired
    private BookDao bookDao;

    @PostMapping
    public Book save(@RequestBody Book book) {
        return bookDao.save(book);
    }

    @GetMapping
    public List<Book> getAllbooks() {
        return bookDao.findAll();
    }

    @GetMapping("/{id}")
    public Book findBookById(@PathVariable int id) {
        return bookDao.findBookById(id);
    }

    @DeleteMapping("/{id}")
    public String deleteBookById(@PathVariable int id) {
        return bookDao.deleteBook(id);
    }

    @PutMapping("/{id}")
    public Book updateBook(@PathVariable int id, @RequestBody Book book) {
        return bookDao.update(id, book);
    }
}
