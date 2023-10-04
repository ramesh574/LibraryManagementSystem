package com.ramesh.libraryworld.controller;

import com.ramesh.libraryworld.entity.Book;
import com.ramesh.libraryworld.service.BookService;
import com.ramesh.libraryworld.utils.ExtractJWT;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin("http://localhost:3000")
@RestController
@RequestMapping("/api/books")
public class BookController {
    private BookService bookService;
    @Autowired
    public BookController(BookService bookService)
    {
        this.bookService=bookService;
    }
    @GetMapping("/secure/currentloans/count")
    public int currentLoansCount(@RequestHeader(value = "Authorization") String token) {
        String userEmail = ExtractJWT.payloadJWTExtraction(token, "\"sub\"");
        return bookService.currentLoansCount(userEmail);
    }
    @GetMapping("/secure/checkout/byuser")
    public Boolean checkoutBookByUser( @RequestHeader(value = "Authorization") String token,
                                      @RequestParam Long bookId){
            System.out.println(bookId);
            String userEmail=ExtractJWT.payloadJWTExtraction(token, "\"sub\"");
            return bookService.checkoutBookByUser(userEmail,bookId);
    }
    @PutMapping("/secure/checkout")
    public Book checkoutBook ( @RequestHeader(value = "Authorization") String token,
                              @RequestParam Long bookId) throws Exception {
        String userEmail = ExtractJWT.payloadJWTExtraction(token, "\"sub\"");
        return bookService.checkoutBook(userEmail, bookId);
    }

}
