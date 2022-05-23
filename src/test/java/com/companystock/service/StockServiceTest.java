package com.companystock.service;

import com.companystock.model.CompanyRegisterModel;
import com.companystock.model.StockModel;

import com.companystock.repository.IStockRepository;
//import com.companystock.service.IStockService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.time.LocalDate;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
@SpringBootTest
public class StockServiceTest {
    @MockBean
    private IStockRepository stockRepository;

    @Autowired
    private IStockService stockService;

    CompanyRegisterModel cr=new CompanyRegisterModel(12345,"jeevan","jeevan@gmail.com","Reddy","8000","abc.com","BSE",null);
    StockModel sm= new StockModel(1,"BSE",1000, LocalDate.parse("2021-06-01"),LocalDate.parse("2022-06-01"),cr);

    @Test
    void testSaveStock() throws Exception {
        when(stockRepository.save(sm)).thenReturn(sm);
        stockService.saveStock(sm);
        assertEquals(sm, stockService.saveStock(sm));
        status().isCreated();
    }
    @Test
    void testUpdateStock(){
        Mockito.when(stockRepository.save(sm)).thenReturn(sm);
        assertEquals(sm, stockService.updateStock(sm));
        status().isOk();
    }

}
