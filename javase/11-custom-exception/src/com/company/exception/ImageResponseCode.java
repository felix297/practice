package com.company.exception;

public enum ImageResponseCode implements ResponseCode {
    IMAGE_STATUS_ERROR (401, "镜像状态错误。"),
    IMAGE_NOT_EXISTS (402, "镜像不存在。"),
    IMAGE_READY (200, "镜像已准备好。"),
    ;

    private final int code;
    private final String msg;

    ImageResponseCode(int code, String msg) {
        this.code = code;
        this.msg = msg;

    }

    @Override
    public int getCode () {
        return this.code;
    }

    @Override
    public String getMsg () {
        return this.msg;
    }
}