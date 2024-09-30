package com.company.exception;

public interface ResponseCode {
    /**
     * 获取相应码
     *
     * @return 响应码
     */
    public int getCode();

    /**
     * 获取相应信息
     *
     * @return 相应信息
     */
    public String getMsg();
}