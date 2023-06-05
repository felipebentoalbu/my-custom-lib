package br.com.customlib.exception;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@AllArgsConstructor
@Getter
@Builder
@ToString
public class ExceptionData {

    private Integer code;
    private Integer status;
    private String title;

}
