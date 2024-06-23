package io.github.sachithariyathilaka.repository;

import io.github.sachithariyathilaka.entity.Book;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/**
 * Book repository interface.
 *
 * @author  Sachith Ariyathilaka
 * @version 1.0.0
 * @since   2024/06/22
 */
@Repository
public interface BookRepository extends JpaRepository<Book, Integer> {
    Page<Book> findAllByAuthor(String author, Pageable pageable);
    Page<Book> findAllByOrigin(String origin, Pageable pageable);
    Page<Book> findAllByAuthorAndOrigin(String author, String origin, Pageable pageable);
    @Query(value = "SELECT * FROM Book WHERE (:author IS NULL OR author = :author) AND (:origin IS NULL OR origin = :origin)",
           nativeQuery = true)
    Page<Book> nativeSearch(@Param("author") String author,
                            @Param("origin") String origin,
                            Pageable pageable);

    @Query(value = "SELECT book FROM Book book WHERE (:author IS NULL OR book.author = :author) AND (:origin IS NULL OR book.origin = :origin)")
    Page<Book> jpqlSearch(@Param("author") String author,
                            @Param("origin") String origin,
                            Pageable pageable);
}
