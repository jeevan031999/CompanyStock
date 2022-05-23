package com.companystock.controller;

import com.companystock.companyexception.CompanyAlreadyExistsException;
import com.companystock.model.CompanyRegisterModel;
import com.companystock.model.StockModel;

import com.companystock.service.ICompanyService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController

public class CompanyController {
    @Autowired
    ICompanyService companyService;

    @PostMapping(value="/saveCompany", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<CompanyRegisterModel> saveCompany(@RequestBody CompanyRegisterModel companyRegister) throws CompanyAlreadyExistsException {
        companyService.saveCompany(companyRegister);
        URI uri= ServletUriComponentsBuilder.fromCurrentRequest().path("/{companyCode}").buildAndExpand(companyRegister.getCompanyCode()).toUri();
        return ResponseEntity.created(uri).body(companyRegister);
    }


    @GetMapping(value = { "/viewCompany/{companyCode}" })
    public CompanyRegisterModel viewCompany(@PathVariable long companyCode) {
        CompanyRegisterModel company = companyService.getCompanyById(companyCode);
        return company;
    }

    @GetMapping("/viewCompany")
    public List<CompanyRegisterModel> viewAllCompany()
    {
        List<CompanyRegisterModel> companyList = companyService.loadAllCompanyDetails();
        return companyList;
    }

    @DeleteMapping("/deleteCompany/{companyCode}")
    public String deleteCompany(@PathVariable long companyCode) {
        companyService.deleteCompany(companyCode);
        return "company deleted";
    }

    @PutMapping (value="/updateCompany/{companyCode}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public String updateCompany(@RequestBody CompanyRegisterModel companyRegister) {
        companyService.updateCompany(companyRegister);
        return "company updated successfully";
    }

    @GetMapping("/viewStock/{companyCode}")
    public List<StockModel> viewCompanyStocks(@PathVariable long companyCode)
    {
        List<StockModel> stockList = companyService.getCompanyById(companyCode).getStockList();
        return stockList;
    }
    
}