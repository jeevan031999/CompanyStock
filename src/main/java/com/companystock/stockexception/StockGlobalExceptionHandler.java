package com.companystock.stockexception;

import com.companystock.companyexception.CompanyErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
@ControllerAdvice
public class StockGlobalExceptionHandler {

        @ExceptionHandler(value
                = NoSuchStockExistsException.class)
        @ResponseStatus(HttpStatus.BAD_REQUEST)
        public @ResponseBody CompanyErrorResponse
        handleException(NoSuchStockExistsException ex)
        {
            return new CompanyErrorResponse(
                    HttpStatus.NOT_FOUND.value(), ex.getMessage());
        }
    }

