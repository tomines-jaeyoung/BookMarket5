package kr.ac.kopo.kim.bookmarket2.config;

import kr.ac.kopo.kim.bookmarket2.validation.BookValidator;
import kr.ac.kopo.kim.bookmarket2.validation.UnitsInStockValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ValidationConfig {
    @Autowired
    UnitsInStockValidator unitsInStockValidator;

    @Bean
    public BookValidator bookValidator(){
        BookValidator bookValidator = new BookValidator();
        bookValidator.springValidators.add(unitsInStockValidator);
    return bookValidator;
    }
}
