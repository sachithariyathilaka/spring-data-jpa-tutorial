package io.github.sachithariyathilaka.controller;

import io.github.sachithariyathilaka.entity.Book;
import io.github.sachithariyathilaka.resource.request.BookRequest;
import io.github.sachithariyathilaka.resource.response.APIResponse;
import io.github.sachithariyathilaka.service.BookService;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * Controller class for the book service.
 *
 * @author  Sachith Ariyathilaka
 * @version 1.0.0
 * @since   2024/06/22
 */
@RequestMapping("/api/v1/book")
@RestController
public class BookController {
    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    /**
     * Book saving post rest api.
     *
     * @param   bookRequest the book request
     *
     * @return  the new book
     */
    @PostMapping("/")
    public ResponseEntity<?> save(@RequestBody BookRequest bookRequest) {
        APIResponse<Book> apiResponse;
        Book book = bookService.save(bookRequest);

        if (book != null)
            apiResponse = new APIResponse<>(HttpStatus.OK.value(), "Book saved successfully!", book);
        else
            apiResponse = new APIResponse<>(HttpStatus.INTERNAL_SERVER_ERROR.value(), "Error occurred while saving the book", null);

        return new ResponseEntity<>(apiResponse, HttpStatusCode.valueOf(apiResponse.getCode()));
    }

    /**
     * Book updating put rest api.
     *
     * @param   id the book id
     * @param   bookRequest the book request
     *
     * @return  the new book
     */
    @PutMapping("/")
    public ResponseEntity<?> update(@RequestParam int id,
                                    @RequestBody BookRequest bookRequest) {
        APIResponse<Book> apiResponse;
        Book book = bookService.update(id, bookRequest);

        if (book != null)
            apiResponse = new APIResponse<>(HttpStatus.OK.value(), "Book updated successfully!", book);
        else
            apiResponse = new APIResponse<>(HttpStatus.INTERNAL_SERVER_ERROR.value(), "Error occurred while updating the book", null);

        return new ResponseEntity<>(apiResponse, HttpStatusCode.valueOf(apiResponse.getCode()));
    }

    /**
     * Book deleting delete rest api.
     *
     * @param   id the book id
     *
     * @return  the book id
     */
    @DeleteMapping("/")
    public ResponseEntity<?> delete(@RequestParam int id) {
        bookService.delete(id);
        APIResponse<Integer> apiResponse = new APIResponse<>(HttpStatus.OK.value(), "Book deleted successfully!", id);
        return new ResponseEntity<>(apiResponse, HttpStatusCode.valueOf(apiResponse.getCode()));
    }

    /**
     * Find all books get rest api.
     *
     * @param   page the page number
     * @param   size the page size
     *
     * @return  the page book
     */
    @GetMapping("/")
    public ResponseEntity<?> findAll(@RequestParam int page,
                                     @RequestParam int size) {
        APIResponse<Page<Book>> apiResponse;
        Page<Book> bookPage = bookService.findAll(page, size);

        if (!bookPage.isEmpty())
            apiResponse = new APIResponse<>(HttpStatus.OK.value(), "Books fetched successfully!", bookPage);
        else
            apiResponse = new APIResponse<>(HttpStatus.NO_CONTENT.value(), "No books found!", bookPage);

        return new ResponseEntity<>(apiResponse, HttpStatusCode.valueOf(apiResponse.getCode()));
    }

    /**
     * Search books get rest api.
     *
     * @param   page the page number
     * @param   size the page size
     * @param   author the author of the book
     * @param   origin the origin of the book
     *
     * @return  the page book
     */
    @GetMapping("/search")
    public ResponseEntity<?> search(@RequestParam int page,
                                    @RequestParam int size,
                                    @RequestParam(required = false) String author,
                                    @RequestParam(required = false) String origin) {
        APIResponse<Page<Book>> apiResponse;
        Page<Book> bookPage = bookService.search(page, size, author, origin);

        if (!bookPage.isEmpty())
            apiResponse = new APIResponse<>(HttpStatus.OK.value(), "Books fetched successfully!", bookPage);
        else
            apiResponse = new APIResponse<>(HttpStatus.NO_CONTENT.value(), "No books found!", bookPage);

        return new ResponseEntity<>(apiResponse, HttpStatusCode.valueOf(apiResponse.getCode()));
    }

    /**
     * Search books get rest api by native query.
     *
     * @param   page the page number
     * @param   size the page size
     * @param   author the author of the book
     * @param   origin the origin of the book
     *
     * @return  the page book
     */
    @GetMapping("/native-search")
    public ResponseEntity<?> nativeSearch(@RequestParam int page,
                                          @RequestParam int size,
                                          @RequestParam(required = false) String author,
                                          @RequestParam(required = false) String origin) {
        APIResponse<Page<Book>> apiResponse;
        Page<Book> bookPage = bookService.nativeSearch(page, size, author, origin);

        if (!bookPage.isEmpty())
            apiResponse = new APIResponse<>(HttpStatus.OK.value(), "Books fetched successfully!", bookPage);
        else
            apiResponse = new APIResponse<>(HttpStatus.NO_CONTENT.value(), "No books found!", bookPage);

        return new ResponseEntity<>(apiResponse, HttpStatusCode.valueOf(apiResponse.getCode()));
    }

    /**
     * Search books get rest api by jpql query.
     *
     * @param   page the page number
     * @param   size the page size
     * @param   author the author of the book
     * @param   origin the origin of the book
     *
     * @return  the page book
     */
    @GetMapping("/jpql-search")
    public ResponseEntity<?> jpqlSearch(@RequestParam int page,
                                          @RequestParam int size,
                                          @RequestParam(required = false) String author,
                                          @RequestParam(required = false) String origin) {
        APIResponse<Page<Book>> apiResponse;
        Page<Book> bookPage = bookService.jpqlSearch(page, size, author, origin);

        if (!bookPage.isEmpty())
            apiResponse = new APIResponse<>(HttpStatus.OK.value(), "Books fetched successfully!", bookPage);
        else
            apiResponse = new APIResponse<>(HttpStatus.NO_CONTENT.value(), "No books found!", bookPage);

        return new ResponseEntity<>(apiResponse, HttpStatusCode.valueOf(apiResponse.getCode()));
    }
}
