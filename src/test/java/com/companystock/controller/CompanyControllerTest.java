package com.companystock.controller;

import com.companystock.model.CompanyRegisterModel;
import com.companystock.service.CompanyService;
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

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(CompanyController.class)
public class CompanyControllerTest {
    @Autowired
    MockMvc mockMvc;
    @Autowired
    ObjectMapper mapper;
    @MockBean
    private CompanyService companyService;

    CompanyRegisterModel cr = new CompanyRegisterModel(12345, "jeevan", "jeevan@gmail.com", "Reddy", "8000", "abc.com", "BSE", null);

    CompanyRegisterModel cr1 = new CompanyRegisterModel(12121, "abi", "abi@gmail.com", "karthik", "10000", "abi.com", "NSE", null);
    List<CompanyRegisterModel> record = new ArrayList<>(Arrays.asList(cr, cr1));

    @Test
    public void testSaveCompany() throws Exception{
        Mockito.when(companyService.saveCompany(cr)).thenReturn(cr);
        MockHttpServletRequestBuilder mockRequest = MockMvcRequestBuilders.post("/saveCompany")
                .contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON)
                .content(this.mapper.writeValueAsString(cr));

        mockMvc.perform(mockRequest).andExpect(status().isCreated());
    }

    @Test
    void testGetViewCompany() throws Exception {

        Mockito.when(companyService.getCompanyById(cr.getCompanyCode())).thenReturn(cr);

        mockMvc.perform(MockMvcRequestBuilders.get("/viewCompany/12345")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @Test
    void testGetAllCompany() throws Exception {

        Mockito.when(companyService.loadAllCompanyDetails()).thenReturn(record);

        mockMvc.perform(MockMvcRequestBuilders.get("/viewCompany")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @Test
    public void testDeleteCompany() throws Exception {
        Mockito.when(companyService.deleteCompany(12345)).thenReturn(cr);
        mockMvc.perform(MockMvcRequestBuilders
                        .delete("/deleteCompany/12345")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }
    @Test
    public void testUpdateCompany() throws Exception {
        cr.setCompanyCode(12345);

        Mockito.when(companyService.updateCompany(cr)).thenReturn(cr);
        MockHttpServletRequestBuilder mockRequest = MockMvcRequestBuilders.put("/updateCompany/12345")
                .contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON)
                .content(this.mapper.writeValueAsString(cr));
        mockMvc.perform(mockRequest).andExpect(status().isOk());


    }
}



