package library.service;

import library.model.Book;
import library.repository.AuthorRepository;
import library.repository.BookRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class SimpleBookService implements BookService {
    private final BookRepository bookRepository;
    private final AuthorRepository authorRepository;

    @Override
    public Page<Book> findAllBooks(Pageable pageable) {
        return bookRepository.findAll(pageable);
    }

    @Override
    public List<Book> findAllBooks(Sort sort) {
        return bookRepository.findAll(sort);
    }

    @Override
    public List<Book> findAllBooks() {
        return bookRepository.findAll();
    }

    @Override
    public Book findById(int id) {
        Optional<Book> optionalBook = bookRepository.findById(id);
        if (optionalBook.isEmpty()) {
            throw new RuntimeException("Book not found");
        }
        return optionalBook.get();
    }

    @Override
    public Book save(Book book) {
        return bookRepository.save(book);

    }

    @Override
    public void update(Book book) {
        Optional<Book> optionalBook = bookRepository.findById(book.getId());
        if (optionalBook.isEmpty()) {
            throw new RuntimeException("Book not found");
        }
        bookRepository.save(book);
    }

    @Override
    public void delete(int id) {
        Optional<Book> optionalBook = bookRepository.findById(id);
        if (optionalBook.isEmpty()) {
            throw new RuntimeException("Book not found");
        }
        bookRepository.deleteById(id);
    }
}
