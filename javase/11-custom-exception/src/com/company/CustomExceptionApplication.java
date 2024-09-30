package com.company;

import com.company.entity.Image;
import com.company.exception.ImageResponseCode;
import com.company.exception.ResponseException;

public class CustomExceptionApplication {
    public static void main (String[] args) throws ResponseException {
        Image image = new Image (400);

        if (image.getStatus() != ImageResponseCode.IMAGE_READY.getCode()) {
            throw new ResponseException(ImageResponseCode.IMAGE_STATUS_ERROR);
        }
    }
}