package br.com.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ErrorDataCommon implements ErrorData {
    ERROR_001(1, 404, "Not Found Error Type");

    private final Integer code;
    private final Integer status;
    private final String title;
}