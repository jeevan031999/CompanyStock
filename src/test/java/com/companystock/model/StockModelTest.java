package com.companystock.model;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.Assert.assertEquals;


public class StockModelTest {
    CompanyRegisterModel cr=new CompanyRegisterModel(12345,"jeevan","jeevan@gmail.com","Reddy","8000","abc.com","BSE",null);
    StockModel sm= new StockModel(1,"BSE",1000, LocalDate.parse("2021-06-01"),LocalDate.parse("2022-06-01"),cr);


    @Test
    void testGetId() {
        sm.setId(11);
        assertEquals(11,sm.getId());
    }
    @Test
    void testGetStockName() {
        sm.setStockName("BSF");
        assertEquals("BSF",sm.getStockName());
    }
    @Test
    void testGetStockPrice() {
        sm.setStockPrice(1200);
        assertEquals(1200,sm.getStockPrice());
    }
}
