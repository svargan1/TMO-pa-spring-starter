package com.galvanize.tmo.paspringstarter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class LibraryController {

    @GetMapping("/health")
    public void health() {

    }

    @Autowired
    private BookService bookService;

    @RequestMapping("/books")
    public List<Book> getAllBooks() {
        return bookService.getAllBooks();
    }

    @RequestMapping(method= RequestMethod.POST, value= "/books")
    public void addBook(@RequestBody Book book) {
        bookService.addBook(book);
    }

    @RequestMapping(method= RequestMethod.DELETE, value= "/books")
    public void deleteAllBooks() {
        bookService.deleteAllBooks();
    }
}
