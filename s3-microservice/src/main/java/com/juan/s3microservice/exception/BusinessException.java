package com.juan.s3microservice.exception;

import lombok.Getter;

@Getter
public class BusinessException extends Exception{
    private String msg;

    public BusinessException(String s) {
        this.msg = s;
    }
}
