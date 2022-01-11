package com.galvanize.tmo.paspringstarter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class LibraryController {

    @GetMapping("/health")
    public void health() {

    }

    @Autowired
    private BookService bookService;

    @RequestMapping("api/books")
    public List<Book> getAllBooks() {
        return bookService.getAllBooks();
    }

    @RequestMapping(method= RequestMethod.POST, value= "api/books")
    public Book addBook(@RequestBody Book book) {
        return bookService.addBook(book);
    }

    @RequestMapping(method= RequestMethod.DELETE, value= "api/books")
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void deleteAllBooks() {
        bookService.deleteAllBooks();
    }
}
