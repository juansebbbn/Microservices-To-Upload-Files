package com.juan.s3microservice.exception;

import lombok.Getter;

@Getter
public class InfraException extends Exception{
    private String msg;

    public InfraException(String msg){
        this.msg = msg;
    }
}
