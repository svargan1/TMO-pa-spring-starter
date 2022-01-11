package com.galvanize.tmo.paspringstarter;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@Service
public class BookService {

    private List<Book> books = new ArrayList<>(Arrays.asList(
            new Book(1, "Douglas Adams", "The Hitchhiker's Guide to the Galaxy", 1979),
            new Book(2, "Philip K. Dick", "Do Androids Dream of Electric Sheep?", 1968),
            new Book(3, "William Gibson", "Neuromancer", 1984)
    ));

    public List<Book> getAllBooks() {
        Collections.sort(books,(b1, b2) -> b1.getTitle().compareTo(b2.getTitle()));
        return books;
    }

    public void addBook(Book book) {
        books.add(book);
    }

    public void deleteAllBooks() {
        books.clear();
    }
}
