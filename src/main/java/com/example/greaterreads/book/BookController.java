package com.example.greaterreads.book;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Optional;

@Controller
public class BookController {

    private BookRepository bookRepository;

    @Autowired
    public BookController(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @GetMapping(value = "/books/{bookId}")
    public String getBook(@PathVariable String bookId, Model model) {
          Optional<Book> optionalBook = bookRepository.findById(bookId);
          if (optionalBook.isPresent()) {
              Book book = optionalBook.get();
              model.addAttribute("book", book);
              return "book";
          }
        return "book-not-found";
    }
}
