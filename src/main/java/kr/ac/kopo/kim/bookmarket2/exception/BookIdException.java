package kr.ac.kopo.kim.bookmarket2.exception;

import lombok.Data;

@Data
public class BookIdException extends RuntimeException {
    private String bookId;

    public BookIdException(String bookId) {
        this.bookId = bookId;
    }
}