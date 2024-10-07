package me.r3tnu.lab2.servlets.exceptions;

public class RequestException extends Exception {
    public RequestException() {
        super();
    }

    public RequestException(String message) {
        super(message);
    }
}
