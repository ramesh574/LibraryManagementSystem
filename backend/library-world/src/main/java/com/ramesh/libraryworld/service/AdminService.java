package com.ramesh.libraryworld.service;

import com.ramesh.libraryworld.dao.BookRepository;
import com.ramesh.libraryworld.entity.Book;
import com.ramesh.libraryworld.requestmodels.AddBookRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class AdminService {

    private BookRepository bookRepository;

    public AdminService(BookRepository bookRepository)
    {
        this.bookRepository=bookRepository;
    }
    public void postBook(AddBookRequest addBookRequest)
    {
        Book book=new Book();
        book.setTitle(addBookRequest.getTitle());
        book.setAuthor(addBookRequest.getAuthor());
        book.setDescription(addBookRequest.getDescription());
        book.setCopies(addBookRequest.getCopies());
        book.setCopiesAvailable(addBookRequest.getCopies());
        book.setCategory(addBookRequest.getCategory());
        book.setImg(addBookRequest.getImg());
        bookRepository.save(book);
    }

}
