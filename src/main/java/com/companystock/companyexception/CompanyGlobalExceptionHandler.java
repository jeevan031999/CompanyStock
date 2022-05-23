package com.companystock.companyexception;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class CompanyGlobalExceptionHandler {

    @ExceptionHandler(value
            = NoSuchCompanyExistsException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public @ResponseBody CompanyErrorResponse
    handleException(NoSuchCompanyExistsException ex)
    {
        return new CompanyErrorResponse(
                HttpStatus.NOT_FOUND.value(), ex.getMessage());
    }
}
