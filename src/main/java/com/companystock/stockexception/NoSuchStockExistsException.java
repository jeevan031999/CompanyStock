package com.companystock.stockexception;

public class NoSuchStockExistsException  extends RuntimeException {

    private String message;

    public NoSuchStockExistsException() {
    }

    public NoSuchStockExistsException(String msg) {
        super(msg);
        this.message = msg;
    }
}