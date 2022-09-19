package org.xdz.exception;

import lombok.Data;

@Data
public class WebException extends RuntimeException {
    public WebException(String message) {
        super(message);
    }
}
