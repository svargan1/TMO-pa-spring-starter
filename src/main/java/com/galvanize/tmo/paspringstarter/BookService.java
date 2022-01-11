package com.galvanize.tmo.paspringstarter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@Service
public class BookService {
    @Autowired
    private BookRepository bookRepository;

    /*private List<Book> books = new ArrayList<>(Arrays.asList(
            new Book(1, "Douglas Adams", "The Hitchhiker's Guide to the Galaxy", 1979),
            new Book(2, "Philip K. Dick", "Do Androids Dream of Electric Sheep?", 1968),
            new Book(3, "William Gibson", "Neuromancer", 1984)
    ));*/

    public List<Book> getAllBooks() {
        List<Book> books = new ArrayList<>();
        bookRepository.findAll().forEach(books::add);
        Collections.sort(books,(b1, b2) -> b1.getTitle().compareTo(b2.getTitle()));
        return books;
    }

    @ResponseBody
    public Book addBook(Book book) {
        return bookRepository.save(book);
    }

    public void deleteAllBooks() {
       bookRepository.deleteAll();
    }
}
