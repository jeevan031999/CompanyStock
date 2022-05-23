package com.companystock.stockexception;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class StockErrorResponse {

    private int statusCode;
    private String message;

    public StockErrorResponse(String message)
    {
        super();
        this.message = message;
    }

    @ExceptionHandler(value
            = StockAlreadyExistsException.class)
    @ResponseStatus(HttpStatus.CONFLICT)
    public StockErrorResponse
    handleStockAlreadyExistsException(
            StockAlreadyExistsException ex)
    {
        return new StockErrorResponse(HttpStatus.CONFLICT.value(),
                ex.getMessage());
    }
}

