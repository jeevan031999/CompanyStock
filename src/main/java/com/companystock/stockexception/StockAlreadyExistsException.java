package com.companystock.stockexception;

public class StockAlreadyExistsException  extends RuntimeException {

    private String message;

    public StockAlreadyExistsException() {}

    public StockAlreadyExistsException(String msg)
    {
        super(msg);
        this.message = msg;
    }
}
