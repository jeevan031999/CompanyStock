package com.companystock.controller;


import com.companystock.model.CompanyRegisterModel;
import com.companystock.model.StockModel;


import com.companystock.serviceImp.StockService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.time.LocalDate;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(StockController.class)
public class StockControllerTest {
    @Autowired
    MockMvc mockMvc;
    @Autowired
    ObjectMapper mapper;
    @MockBean
    private StockService stockService;

    CompanyRegisterModel cr = new CompanyRegisterModel(12345, "jeevan", "jeevan@gmail.com", "Reddy", "8000", "abc.com", "BSE", null);
    StockModel sm = new StockModel(1, "BSE", 1000, LocalDate.parse("2021-06-01"), LocalDate.parse("2022-06-01"), cr);

    @Test
    public void testSaveStock() throws Exception {
        Mockito.when(stockService.saveStock(sm)).thenReturn(sm);
        MockHttpServletRequestBuilder mockRequest = MockMvcRequestBuilders.post("/stock/saveStock")
                .contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON)
                .content(this.mapper.writeValueAsString(cr));
        mockMvc.perform(mockRequest).andExpect(status().isCreated());
    }

    @Test
    public void testUpdateStock() throws Exception {
        sm.setStockName("BSE");

        Mockito.when(stockService.updateStock(sm)).thenReturn(sm);
        MockHttpServletRequestBuilder mockRequest = MockMvcRequestBuilders.put("/stock/updateStock/12345")
                .contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON)
                .content(this.mapper.writeValueAsString(sm));
        mockMvc.perform(mockRequest).andExpect(status().isOk());

    }


}
