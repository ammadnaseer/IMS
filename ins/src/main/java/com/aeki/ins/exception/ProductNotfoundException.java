package com.aeki.ins.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND, reason = "Product not found")
public class ProductNotfoundException extends RuntimeException{
    public ProductNotfoundException(String s) {
        super(s);
    }
}
