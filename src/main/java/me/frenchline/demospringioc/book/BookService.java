package me.frenchline.demospringioc.book;

/**
 * Created by frenchline707@gmail.com on 2020-09-25
 * Blog : http://frenchline707.tistory.com
 * Github : http://github.com/frenchLineCigar
 */

import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.Date;

/**
 * BookService -> BookRepository
 */
@Service
public class BookService {

    private BookRepository bookRepository;

    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public Book save(Book book) {
        book.setCreated(new Date());
        book.setBookStatus(BookStatus.DRAFT);
        return bookRepository.save(book);
    }

    //Lifecycle Callback
    //BookService 빈이 만들어지자마자 아래처럼 라이프사이클 콜백에 해당하는 애노테이션이 붙어있는 메서드가 호출된다
    @PostConstruct
    public void postConstruct() {
        System.out.println("===============");
        System.out.println("Hello");
    }

}
