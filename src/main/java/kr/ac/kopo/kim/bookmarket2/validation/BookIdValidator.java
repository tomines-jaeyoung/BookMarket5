package kr.ac.kopo.kim.bookmarket2.validation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import kr.ac.kopo.kim.bookmarket2.domain.Book;
import kr.ac.kopo.kim.bookmarket2.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;

public class BookIdValidator implements ConstraintValidator<BookId, String> {
    @Autowired
    private BookService bookService;

    @Override
    public void initialize(BookId constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(String bookId, ConstraintValidatorContext constraintValidatorContext) {
        // 도서ID(isbn) 중복되는 경우에 false(오류)
        Book book;
        try {
            book = bookService.getBookById(bookId);
        } catch (RuntimeException e) {
            return true;
        }

        if (book != null)
            return false;
        return true;
    }
}