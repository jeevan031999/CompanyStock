package com.companystock.companyexception;



import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

@Data
    @AllArgsConstructor
    @NoArgsConstructor
    public class CompanyErrorResponse {

        private int statusCode;
        private String message;

        public CompanyErrorResponse(String message)
        {
            super();
            this.message = message;
        }

        @ExceptionHandler(value
                = CompanyAlreadyExistsException.class)
        @ResponseStatus(HttpStatus.CONFLICT)
        public CompanyErrorResponse
        handleCompanyAlreadyExistsException(
                CompanyAlreadyExistsException ex)
        {
            return new CompanyErrorResponse(HttpStatus.CONFLICT.value(),
                    ex.getMessage());
        }
    }


