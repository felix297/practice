package com.company.exception;

public class ResponseException extends Exception {
    public ResponseException(ImageResponseCode imageResponseCode) {
        super(imageResponseCode.getMsg());
    }
}
