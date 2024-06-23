package io.github.sachithariyathilaka.resource.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * API response resource class for all the rest endpoint reply.
 *
 * @param   <T> return data type
 *
 * @author  Sachith Ariyathilaka
 * @version 1.0.0
 * @since   2024/06/22
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class APIResponse<T> {
    private int code;
    private String message;
    private T data;
}
