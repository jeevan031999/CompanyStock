package com.companystock.companyexception;


    public class NoSuchCompanyExistsException
            extends RuntimeException {

        private String message;

        public NoSuchCompanyExistsException() {}

        public NoSuchCompanyExistsException(String msg)
        {
            super(msg);
            this.message = msg;
        }
    }


