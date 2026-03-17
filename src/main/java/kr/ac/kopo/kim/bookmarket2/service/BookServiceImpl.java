package kr.ac.kopo.kim.bookmarket2.service;

import kr.ac.kopo.kim.bookmarket2.domain.Book;
import kr.ac.kopo.kim.bookmarket2.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookServiceImpl implements BookService{
    @Autowired
    private BookRepository bookRepository;

    @Override
    public List<Book> getAllBookList() {
        return bookRepository.getAllBookList();
    }
}