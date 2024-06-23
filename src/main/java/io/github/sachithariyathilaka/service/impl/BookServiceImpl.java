package io.github.sachithariyathilaka.service.impl;

import io.github.sachithariyathilaka.entity.Book;
import io.github.sachithariyathilaka.repository.BookRepository;
import io.github.sachithariyathilaka.resource.request.BookRequest;
import io.github.sachithariyathilaka.service.BookService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * Implementation class for the book service.
 *
 * @author  Sachith Ariyathilaka
 * @version 1.0.0
 * @since   2024/06/22
 */
@Service
public class BookServiceImpl implements BookService {
    private final BookRepository bookRepository;

    public BookServiceImpl(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    /**
     * Book saving service method implementations.
     *
     * @param   bookRequest the book request
     *
     * @return  the new book
     */
    @Override
    public Book save(BookRequest bookRequest) {
        Book book = new Book();
        book.setTitle(bookRequest.getTitle());
        book.setDescription(bookRequest.getDescription());
        book.setAuthor(bookRequest.getAuthor());
        book.setOrigin(bookRequest.getOrigin());

        return bookRepository.saveAndFlush(book);
    }

    /**
     * Book updating service method implementations.
     *
     * @param   id the book id
     * @param   bookRequest the book request
     *
     * @return  the updated book
     */
    @Override
    public Book update(int id, BookRequest bookRequest) {
        Optional<Book> optionalBook = bookRepository.findById(id);
        if (optionalBook.isEmpty())
            return null;

        Book book = optionalBook.get();
        book.setTitle(bookRequest.getTitle());
        book.setDescription(bookRequest.getDescription());
        book.setAuthor(bookRequest.getAuthor());
        book.setOrigin(bookRequest.getOrigin());

        return bookRepository.saveAndFlush(book);
    }

    /**
     * Book deleting service method implementations.
     *
     * @param   id the book request
     */
    @Override
    public void delete(int id) {
        bookRepository.deleteById(id);
    }

    /**
     * Find all books service method implementation.
     *
     * @param   page the page number
     * @param   size the page size
     *
     * @return the book page
     */
    @Override
    public Page<Book> findAll(int page, int size) {
        Pageable pageable = PageRequest.of(page - 1, size);
        return bookRepository.findAll(pageable);
    }

    /**
     * Search books service method implementation.
     *
     * @param   page the page number
     * @param   size the page size
     * @param   author the book author
     * @param   origin the origin of the book
     *
     * @return the book page
     */
    @Override
    public Page<Book> search(int page, int size, String author, String origin) {
        Pageable pageable = PageRequest.of(page -1, size);

        if (author != null && origin != null)
            return bookRepository.findAllByAuthorAndOrigin(author, origin, pageable);
        else if (origin == null && author != null)
            return bookRepository.findAllByAuthor(author, pageable);
        else if (origin != null)
            return bookRepository.findAllByOrigin(origin, pageable);
        else
            return bookRepository.findAll(pageable);
    }

    /**
     * Search books service by using native query method implementation.
     *
     * @param   page the page number
     * @param   size the page size
     * @param   author the book author
     * @param   origin the origin of the book
     *
     * @return the book page
     */
    @Override
    public Page<Book> nativeSearch(int page, int size, String author, String origin) {
        Pageable pageable = PageRequest.of(page - 1, size);
        return bookRepository.nativeSearch(author, origin, pageable);
    }

    /**
     * Search books service by using jpql query method implementation.
     *
     * @param   page the page number
     * @param   size the page size
     * @param   author the book author
     * @param   origin the origin of the book
     *
     * @return the book page
     */
    @Override
    public Page<Book> jpqlSearch(int page, int size, String author, String origin) {
        Pageable pageable = PageRequest.of(page - 1, size);
        return bookRepository.jpqlSearch(author, origin, pageable);
    }
}
