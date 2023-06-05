package br.com.customlib.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@AllArgsConstructor
@Getter
@ToString
public abstract class BasicException extends RuntimeException {

    private final Integer code;
    private final Integer status;
    private final String title;

}
