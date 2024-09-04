package io.github.sachithariyathilaka.service;

import io.github.sachithariyathilaka.entity.Book;
import io.github.sachithariyathilaka.resource.request.BookRequest;
import org.springframework.data.domain.Page;

/**
 * Interface for the book service.
 *
 * @author  Sachith Ariyathilaka
 * @version 1.0.0
 * @since   2024/06/22
 */
public interface BookService {
    Book save(BookRequest bookRequest);
    Book update(long id, BookRequest bookRequest);
    void delete(long id);
    Page<Book> findAll(int page, int size);
    Page<Book> search(int page, int size, String author, String origin);
    Page<Book> nativeSearch(int page, int size, String author, String origin);
    Page<Book> jpqlSearch(int page, int size, String author, String origin);
}
