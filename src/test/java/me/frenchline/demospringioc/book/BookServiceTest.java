package me.frenchline.demospringioc.book;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

/**
 * Created by frenchline707@gmail.com on 2020-09-25
 * Blog : http://frenchline707.tistory.com
 * Github : http://github.com/frenchLineCigar
 */

@RunWith(SpringRunner.class)
public class BookServiceTest {

    //Spring IoC 컨테이너를 이용하면 의존성 주입을 받을 수 있게끔 코드를 만들었기 때문에
    //테스트 작성 시 다음처럼 얼마든지 가짜 객체를 만들어서 의존성 주입을 할 수도 있다.
    @Mock
    BookRepository bookRepository;

    @Test
    public void save() {
        Book book = new Book();

        when(bookRepository.save(book)).thenReturn(book); //가짜 객체 Mocking
        BookService bookService = new BookService(bookRepository);

        Book result = bookService.save(book);

        assertThat(book.getCreated()).isNotNull();
        assertThat(book.getBookStatus()).isEqualTo(BookStatus.DRAFT);
        assertThat(result).isNotNull();
    }
}