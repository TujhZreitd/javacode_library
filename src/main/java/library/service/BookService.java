package library.service;

import library.model.Book;

import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;

import java.util.List;

public interface BookService {
    Page<Book> findAllBooks(Pageable pageable);
    List<Book> findAllBooks(Sort sort);
    List<Book> findAllBooks();
    Book findById(int id);
    Book save(Book book);
    void update(Book book);
    void delete(int id);

}
