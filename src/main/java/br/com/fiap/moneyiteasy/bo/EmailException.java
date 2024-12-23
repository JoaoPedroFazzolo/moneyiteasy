package br.com.fiap.moneyiteasy.bo;

public class EmailException extends Exception {

    public EmailException() {
        super();
    }

    public EmailException(
            String message,
            Throwable cause,
            boolean enableSuppression,
            boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

    public EmailException(String message, Throwable cause) {
        super(message, cause);
    }

    public EmailException(String message) {
        super(message);
    }

    public EmailException(Throwable cause) {
        super(cause);
    }

}
