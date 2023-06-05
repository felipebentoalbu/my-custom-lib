package br.com.customlib.exception;

public class BusinessException extends BasicException {

    public BusinessException(final ErrorData errorData) {
        super(errorData.getCode(), errorData.getStatus(), errorData.getTitle());
    }

}
