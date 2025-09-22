package com.itheima.common;

public class DeletionNotAllowedException extends RuntimeException {

    public DeletionNotAllowedException() {

    }

    public DeletionNotAllowedException(String msg) {
        super(msg);
    }

}