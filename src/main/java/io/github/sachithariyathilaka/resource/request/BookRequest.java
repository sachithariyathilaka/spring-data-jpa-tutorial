package io.github.sachithariyathilaka.resource.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Book request resource class.
 *
 * @author  Sachith Ariyathilaka
 * @version 1.0.0
 * @since   2024/06/22
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class BookRequest {

    private String title;

    private String description;

    private String author;

    private String origin;
}
