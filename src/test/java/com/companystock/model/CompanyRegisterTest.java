package com.companystock.model;


import org.junit.jupiter.api.Test;
import static org.junit.Assert.assertEquals;
public class CompanyRegisterTest {

    CompanyRegisterModel cr = new CompanyRegisterModel();
    CompanyRegisterModel cr1=new CompanyRegisterModel(12345,"jeevan","jeevan@gmail.com","Reddy","8000","abc.com","BSE",null);


    @Test
    void testGetCompanyCode() {
        cr.setCompanyCode(12121);
        assertEquals(12121,cr.getCompanyCode());
    }
    @Test
    void testGetCompanyName() {
        cr.setCompanyName("dhanush");
        assertEquals("dhanush",cr.getCompanyName());
    }
    @Test
    void testGetCompanyEmail() {
        cr.setCompanyEmail("dhanush@gmail.com");
        assertEquals("dhanush@gmail.com",cr.getCompanyEmail());
    }
    @Test
    void testGetCompanyCeo() {
        cr.setCompanyCeo("Gowda");
        assertEquals("Gowda",cr.getCompanyCeo());
    }
    @Test
    void testGetTurnover() {
        cr.setTurnover("9000");
        assertEquals("9000",cr.getTurnover());
    }
    @Test
    void testGetWebsite() {
        cr.setWebsite("www.dhanush.com");
        assertEquals("www.dhanush.com",cr.getWebsite());
    }
    @Test
    void testGetStockExchange() {
        cr.setStockExchange("BSE");
        assertEquals("BSE",cr.getStockExchange());
    }

}
