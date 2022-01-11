package com.galvanize.tmo.paspringstarter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.*;

@Service
public class BookService {
    @Autowired
    private BookRepository bookRepository;

    public Map<String, List<Book>> getAllBooks() {
        List<Book> books = new ArrayList<>();
        bookRepository.findAll().forEach(books::add);
        Collections.sort(books,(b1, b2) -> b1.getTitle().compareTo(b2.getTitle()));
        Map<String, List<Book>> bookMap = new HashMap<>();
        bookMap.put("books", books);
        return bookMap;
    }

    public Book addBook(Book book) {
        return bookRepository.save(book);
    }

    public void deleteAllBooks() {
       bookRepository.deleteAll();
    }
}