package com.companystock.service;

import com.companystock.model.CompanyRegisterModel;

import com.companystock.repository.ICompanyRepository;

//import com.companystock.service.ICompanyService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
public class CompanyServiceTest {
    @MockBean
    private ICompanyRepository companyRepo;

    @Autowired
    private CompanyService icompanyService;

    CompanyRegisterModel cr=new CompanyRegisterModel(12345,"jeevan","jeevan@gmail.com","Reddy","8000","abc.com","BSE",null);
    CompanyRegisterModel cr1 = new CompanyRegisterModel(12121, "abi", "abi@gmail.com", "karthik", "10000", "abi.com", "NSE", null);
    List<CompanyRegisterModel> record = new ArrayList<>(Arrays.asList(cr, cr1));

    @Test
    void testSaveCompany() throws Exception {
        when(companyRepo.save(cr)).thenReturn(cr);
        icompanyService.saveCompany(cr);
        assertEquals(cr, icompanyService.saveCompany(cr));
        status().isCreated();
    }
    @Test
    void testGetCompanyById() throws Exception{
        Mockito.when(companyRepo.getById(12121L)).thenReturn((cr1));
        assertEquals(cr1, icompanyService.getCompanyById(12121));
        status().isOk();

    }
    @Test
    void testDeleteCompany(){
        Mockito.when(companyRepo.findById(12121L)).thenReturn(Optional.ofNullable(cr1));
        assertEquals(cr1, icompanyService.deleteCompany(12121));
        status().isOk();
    }

    @Test
    void testUpdateCompany(){
        Mockito.when(companyRepo.save(cr)).thenReturn(cr);
        assertEquals(cr, icompanyService.updateCompany(cr));
        status().isOk();

    }
    @Test
    void testGetCompanies(){
        Mockito.when(companyRepo.findAll()).thenReturn(record);
        assertEquals(record, icompanyService.loadAllCompanyDetails());
        status().isOk();
    }
}

