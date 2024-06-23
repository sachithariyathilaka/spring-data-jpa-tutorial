package io.github.sachithariyathilaka.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Book entity class.
 *
 * @author  Sachith Ariyathilaka
 * @version 1.0.0
 * @since   2024/06/22
 */
@Entity
@Getter
@Setter
@NoArgsConstructor
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String title;
    private String description;
    private String author;
    private String origin;
}
