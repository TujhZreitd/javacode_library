package library.controller;

import library.model.Book;
import library.service.BookService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PagedResourcesAssembler;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/books")
@AllArgsConstructor
public class BookController {
    private final BookService bookService;
    private PagedResourcesAssembler<Book> pagedResourcesAssembler;

    @GetMapping
    public Page<Book> getAllBooksWithPage(Pageable pageable) {
        return bookService.findAllBooks(pageable);
    }

    @GetMapping("/all")
    public List<Book> getAllBooks() {
        return bookService.findAllBooks();
    }

    @GetMapping("/sorted")
    public List<Book> getSortedBooks(@RequestParam String sortBy) {
        Sort sort = Sort.by(sortBy);
        return bookService.findAllBooks(sort);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Book> findById(@PathVariable int id) {
        return ResponseEntity.ok(bookService.findById(id));
    }
    @PostMapping
    public ResponseEntity<String> addBook(@RequestBody Book book) {
        bookService.save(book);
        return ResponseEntity.ok("Operation complete");
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateBook(@RequestBody Book book) {
        bookService.update(book);
        return ResponseEntity.ok("Operation complete");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteBook(@PathVariable int id) {
        bookService.delete(id);
        return ResponseEntity.ok("Operation complete");
    }

}
