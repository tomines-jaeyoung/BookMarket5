package kr.ac.kopo.kim.bookmarket2.repository;

import kr.ac.kopo.kim.bookmarket2.domain.Book;
import java.util.List;

public interface BookRepository {
    List<Book> getAllBookList();
}